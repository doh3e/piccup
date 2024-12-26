import { createApp } from 'vue'
import { createPinia } from 'pinia'
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'
import { authAxios, publicAxios } from '@/utils/axios'

import App from './App.vue'
import router from './router'
import '@/index.css';
import '@/assets/css/normalize.css'
import '@/assets/css/base.css'
import '@/assets/css/font.css'
import '@/assets/css/tailwind.css'


const app = createApp(App)
const pinia = createPinia()
pinia.use(piniaPluginPersistedstate)

app.use(router)

app.mount('#app')

// Axios 인스턴스를 전역에 추가
app.config.globalProperties.$authAxios = authAxios
app.config.globalProperties.$publicAxios = publicAxios