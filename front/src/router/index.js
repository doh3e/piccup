import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/MainView.vue'
import AuthView from '../views/AuthView.vue'
import ResumeView from '../views/ResumeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/auth',
      name: 'auth',
      component: AuthView
    },
    {
      path: '/resume',
      name: 'resume',
      component: ResumeView
    },

  ],
})

export default router
