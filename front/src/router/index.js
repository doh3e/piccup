import { createRouter, createWebHistory } from 'vue-router'

import HomeView from '@/views/MainView.vue'
import MydataView from '@/views/MydataView.vue'
import ResumeView from '@/views/ResumeView.vue'

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
      path: '/resume',
      name: 'resume',
      component: ResumeView
    },
  ],
})

export default router
