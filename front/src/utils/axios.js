import axios from 'axios'

// 인증이 필요한 Axios 인스턴스
const authAxios = axios.create({
  baseURL: 'http://localhost:8080/api/v1',
  headers: {
    'X-Requested-With': 'XMLHttpRequest',
    'Content-Type': 'application/json',
  },
})

// 요청 인터셉터: 로컬 스토리지에서 JWT 토큰을 가져와 헤더에 추가
authAxios.interceptors.request.use(config => {
  const token = localStorage.getItem('authToken')
  if (token) {
    config.headers['Authorization'] = `Bearer ${token}`
  }
  return config
})

// 인증이 필요하지 않은 Axios 인스턴스
const publicAxios = axios.create({
  baseURL: 'http://localhost:8080/api/v1',
  headers: {
    'X-Requested-With': 'XMLHttpRequest',
    'Content-Type': 'application/json',
  },
})

export { authAxios, publicAxios }
