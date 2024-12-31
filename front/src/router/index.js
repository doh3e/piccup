import { createRouter, createWebHistory } from 'vue-router'

import HomeView from '@/views/MainView.vue'
import MydataView from '@/views/MydataView.vue'
import AuthView from '../views/AuthView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/mydata',
      name: 'mydata',
      component: MydataView,
    },
    {
      path: '/auth',
      name: 'auth',
      component: AuthView
    },
  ],
})

export default router
