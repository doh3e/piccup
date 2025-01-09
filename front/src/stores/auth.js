import { defineStore } from 'pinia'
import { apiAuth, api } from '@/api'
import { ref } from 'vue'

export const useAuthStore = defineStore('auth', () => {
  const loginUser = ref(null)
  const isLoggedIn = ref(false)
  let tokenCheckInterval = null

  if (localStorage.getItem('token')) {
    isLoggedIn.value = true
  }

  async function login(email, password) {
    try {
      const response = await api.post("/user/login", { email, password })
      const token = response.data["refresh-token"]
      loginUser.value = { email }
      localStorage.setItem("loginUser", JSON.stringify(loginUser.value))
      localStorage.setItem("token", token)
      isLoggedIn.value = true
      return { success: true, message: "로그인이 완료되었습니다." }
    } catch (err) {
      if (err.response && err.response.status === 401) {
        return { success: false, message: "이메일 또는 비밀번호가 잘못되었습니다." }
      } else {
        console.error("로그인 오류", err)
        return { success: false, message: "로그인 중 문제가 발생했습니다. 다시 시도해주세요." }
      }
    }
  }

  async function logout() {
    try {
      const token = localStorage.getItem("token")
      if (!token || isTokenExpired(token)) {
        handleClientLogout()
        return { success: true, message: "로그아웃이 완료되었습니다." }
      }
      await apiAuth.post("/user/logout")
      handleClientLogout()
      return { success: true, message: "로그아웃이 완료되었습니다." }
    } catch (err) {
      console.error("로그아웃 오류", err)
      handleClientLogout()
      return { success: false, message: "로그아웃 중 문제가 발생했습니다. 다시 시도해주세요." }
    }
  }

  function handleClientLogout() {
    clearInterval(tokenCheckInterval) // 토큰 확인 중지
    localStorage.removeItem("token")
    localStorage.removeItem("loginUser")
    loginUser.value = null
    isLoggedIn.value = false
  }

  function checkAuth() {
    const token = localStorage.getItem('token')
    const storedUser = localStorage.getItem('loginUser')

    if (token && storedUser && !isTokenExpired(token)) {
      loginUser.value = JSON.parse(storedUser)
      isLoggedIn.value = true
    } else {
      logout()
    }
  }

  function isTokenExpired(token) {
    try {
      const payload = JSON.parse(atob(token.split('.')[1])) // JWT 디코딩
      const currentTime = Math.floor(Date.now() / 1000) // 현재 시간 (초 단위)
      return payload.exp < currentTime // 만료 여부 확인
    } catch (err) {
      console.error("토큰 디코딩 오류", err)
      return true // 디코딩 실패 시 만료된 것으로 처리
    }
  }

  function startTokenCheck() {
    if (tokenCheckInterval) return // 중복 실행 방지
    tokenCheckInterval = setInterval(() => {
      const token = localStorage.getItem("token")
      if (token && isTokenExpired(token)) {
        logout()
        alert("세션이 만료되었습니다. 다시 로그인해주세요.")
      }
    }, 300000) // 5분마다 확인
  }

  checkAuth()
  startTokenCheck()

  return {
    loginUser,
    isLoggedIn,
    login,
    logout,
    checkAuth,
    startTokenCheck,
  }
})
