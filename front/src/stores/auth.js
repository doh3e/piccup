import { defineStore } from 'pinia'
import { apiAuth, api } from '@/api'
import { ref } from 'vue'

export const useAuthStore = defineStore('auth', () => {
  const user = ref(null)
  const isLoggedIn = ref(false)

  if(localStorage.getItem('token')) {
    isLoggedIn.value = true
  }
  

  async function login(email, password) {
      try {
        console.log(email, password)
        const response = await api.post("/user/login", {
          email, password,
        })
        
        const token = response.data["refresh-token"]
        user.value = { email }; // 사용자 정보 저장
        localStorage.setItem("users", JSON.stringify(user.value)); // 사용자 정보 저장
        localStorage.setItem("token", token) // 토큰저장
        isLoggedIn.value = true;
        return { success: true, message: "로그인이 완료되었습니다." };
      } catch (err) {
          if (err.response && err.response.status === 401) {
            return { success: false, message: "이메일 또는 비밀번호가 잘못되었습니다." };
          } else {
            console.error("로그인 오류", err);
            return { success: false, message: "로그인 중 문제가 발생했습니다. 다시 시도해주세요." };
          }
      }
  }

  async function logout() {
    try {
      await apiAuth.post("/user/logout")
      localStorage.removeItem("token")
      localStorage.removeItem("email")
      user.value = null;
      isLoggedIn.value = false;
      return { success: true, message: "로그아웃이 완료되었습니다." };
    } catch (err) {
      console.error("로그아웃 오류", err);
      return { success: false, message: "로그아웃 중 문제가 발생했습니다. 다시 시도해주세요." };
    }
  }

  // function checkAuth() {
  //     // const storedUser = localStorage.getItem('user')
  //     // if (isLoggedIn) {
  //     //   user.value = JSON.parse(storedUser)
  //     //   isLoggedIn = true
  //     // }
  // }
  function checkAuth() {
    const storedUser = localStorage.getItem('user');
    if (storedUser) {
      user.value = JSON.parse(storedUser);
      isLoggedIn.value = true;
    }
  }
  

  return {
    user,
    isLoggedIn,
    login,
    logout,
    checkAuth
  }
})

