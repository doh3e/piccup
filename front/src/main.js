import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router'
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'
import { authAxios, publicAxios } from '@/utils/axios'
import '@/assets/css/tailwind.css'
import '@/assets/css/normalize.css'
import '@/assets/css/base.css'
import '@/assets/css/font.css'


const app = createApp(App)
// const pinia = createPinia()
// pinia.use(piniaPluginPersistedstate)
// 위의 두개로 인식이 안돼서 밑에껄로 수정
app.use(createPinia()) 

app.use(router)

app.mount('#app')

// Axios 인스턴스를 전역에 추가
app.config.globalProperties.$authAxios = authAxios
app.config.globalProperties.$publicAxios = publicAxios