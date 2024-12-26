<template>
  <div class="min-h-screen bg-gray-50 flex flex-col">
    <LoadingView v-if="isLoading" />
    <template v-else>
      <main class="flex-grow mt-24">
        <Hero />
        <JobSearch v-intersection-animate />
        <PopularJobs :jobs="popularJobs" v-intersection-animate />
        <Features :features="features" v-intersection-animate />
        <Companies :companies="companies" v-intersection-animate />
      </main>
      <Footer />
    </template>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import Header from '@/components/Main/Header.vue'
import Hero from '@/components/Main/Hero.vue'
import JobSearch from '@/components/Main/JobSearch.vue'
import PopularJobs from '@/components/Main/PopularJobs.vue'
import Features from '@/components/Main/Features.vue'
import Companies from '@/components/Main/Companies.vue'
import Footer from '@/components/Main/Footer.vue'
import LoadingView from '@/views/LoadingView.vue'

const navItems = ['홈', '채용정보', '이력서', '기업리뷰', '커리어 성장']

const features = [
  { title: '맞춤 채용 추천', description: 'AI 기반으로 개인화된 채용 정보를 제공합니다', icon: 'ai' },
  { title: '원클릭 지원', description: '간편한 지원 프로세스로 빠르게 지원하세요', icon: 'click' },
  { title: '기업 연봉 정보', description: '실제 직원들의 연봉 정보를 확인하세요', icon: 'money' },
  { title: '커리어 성장', description: '다양한 교육 컨텐츠로 역량을 키우세요', icon: 'growth' },
]

const popularJobs = [
  { id: 1, title: '프론트엔드 개발자', company: '테크 솔루션즈', location: '서울', salary: '6000만원', icon: 'computer' },
  { id: 2, title: '마케팅 매니저', company: '브랜드 인사이트', location: '부산', salary: '5000만원', icon: 'megaphone' },
  { id: 3, title: '데이터 분석가', company: '데이터 마인드', location: '대전', salary: '5500만원', icon: 'chart' },
]

const companies = [
  { name: '삼성전자', logo: 'samsung.png' },
  { name: 'LG전자', logo: 'lg.png' },
  { name: '네이버', logo: 'naver.png' },
  { name: '카카오', logo: 'kakao.png' },
  { name: 'SK하이닉스', logo: 'sk-hynix.png' },
  { name: '현대자동차', logo: 'hyundai.png' },
]

// Custom directive for intersection observer animations
const vIntersectionAnimate = {
  mounted: (el) => {
    const observer = new IntersectionObserver((entries) => {
      entries.forEach(entry => {
        if (entry.isIntersecting) {
          el.classList.add('animate-on-scroll')
          observer.unobserve(el)
        }
      })
    }, {
      threshold: 0.1
    })
    
    observer.observe(el)
  }
}

const isLoading = ref(true)

onMounted(() => {
  setTimeout(() => {
    isLoading.value = false
  }, 3000)
})
</script>

<style>

:root {
  --bg-color: #F8F8F8;
  --text-color: #1F1F1F;
  --primary-color: #006B40;
  --secondary-color: #8CD196;
  --accent-color: #E6FF94;
  --highlight-color: #FFDCDC;
}

body {
  font-family: 'NotoSansKR', sans-serif;
  font-size: 16px;
  line-height: 1.5;
  color: var(--text-color);
  background-color: var(--bg-color);
}

.animate-on-scroll {
  animation: fadeInUp 0.8s ease-out forwards;
}

@keyframes fadeInUp {
  from {
    opacity: 0;
    transform: translateY(40px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

/* Responsive container styles */
.container {
  width: 100%;
  margin-right: auto;
  margin-left: auto;
  padding: 1rem;
}

@media (min-width: 640px) {
  .container {
    max-width: 640px;
    padding: 2rem;
  }
}

@media (min-width: 768px) {
  .container {
    max-width: 768px;
  }
}

@media (min-width: 1024px) {
  .container {
    max-width: 1024px;
    padding: 4rem;
  }
}

@media (min-width: 1280px) {
  .container {
    max-width: 1280px;
  }
}

/* Global transition styles */
.transition-all {
  transition-property: all;
  transition-timing-function: cubic-bezier(0.4, 0, 0.2, 1);
  transition-duration: 300ms;
}

/* Hover effect utilities */
.hover-lift {
  transition: transform 0.2s ease;
}

.hover-lift:hover {
  transform: translateY(-2px);
}

/* Focus styles */
.focus-visible:focus {
  outline: 2px solid var(--primary-color);
  outline-offset: 2px;
}

/* Animation utilities */
.animate-fade-in {
  animation: fadeIn 0.5s ease-in forwards;
}

@keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}
</style>

