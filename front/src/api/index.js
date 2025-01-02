// index.js 이름으로 사용하면 import 한 것처럼 동작함
import axios from "axios";

// axios 인스턴스 생성
// 1. Auth 인증/인가
const apiAuth = axios.create({
  baseURL: "/api/v1",
  timeout: 5000, // 제한시간

})
// 2. 인증x
const api = axios.create({
  baseURL: "/api/v1",
  timeout: 5000,
})

//interceptor로 token값이 있을 때, Authorization 헤더 추가
apiAuth.interceptors.request.use((config) => {
  const token = localStorage.getItem("token")
  if (token){
    config.headers.Authorization = `Bearer ${token}`
  }
  return config
})

// 외부에서 axios instance 사용하기위해 내보냄
export { apiAuth, api }