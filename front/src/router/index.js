import { createRouter, createWebHistory } from 'vue-router'

import HomeView from '@/views/MainView.vue'
import MydataView from '@/views/MydataView.vue'
import CoverLetterView from '@/views/CoverLetterView.vue'
import ResumeView from '@/views/ResumeView.vue'
import FAQView from '@/views/FAQView.vue'
import AuthView from '@/views/AuthView.vue'
import CoverLetterBoardView from '@/views/CoverLetterBoardView.vue'
import ResumePreviewView from '@/views/ResumePreviewView.vue'

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
      component: ResumeView,
    },
    {
      path: '/FAQ',
      name: 'faq',
      component: FAQView,
    },
    {
      path: '/auth',
      name: 'auth',
      component: AuthView
    },
    {
      path: '/cover-letter',
      name: 'CoverLetter',
      component: CoverLetterView
    },
    {
      path: '/board',
      name: 'CoverLetterBoard',
      component: CoverLetterBoardView
    },
    {
      path: "/resume-preview",
      name: "ResumePreview",
      component: ResumePreviewView,
    }    
  ],
})

export default router
