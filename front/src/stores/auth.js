import { defineStore } from 'pinia'

export const useAuthStore = defineStore('auth', {
  state: () => ({
    user: null,
    isLoggedIn: false,
  }),
  actions: {
    login(userData) {
      this.user = userData
      this.isLoggedIn = true
      localStorage.setItem('user', JSON.stringify(userData))
    },
    logout() {
      this.user = null
      this.isLoggedIn = false
      localStorage.removeItem('user')
    },
    checkAuth() {
      const storedUser = localStorage.getItem('user')
      if (storedUser) {
        this.user = JSON.parse(storedUser)
        this.isLoggedIn = true
      }
    },
  },
})

