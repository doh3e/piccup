<template>
  <section class="py-20 bg-gradient-to-br from-primary to-secondary relative overflow-hidden">
    <div class="container mx-auto px-4 sm:px-6 lg:px-8">
      <div class="max-w-4xl mx-auto">
        <div class="carousel-container relative">
          <transition name="fade" mode="out-in">
            <div :key="currentSlide" class="text-center">
              <h1 class="text-4xl md:text-5xl lg:text-6xl font-black mb-4 text-black animate-title">
                {{ slides[currentSlide].title }}
              </h1>
              <p class="text-xl mb-8 text-accent animate-subtitle">
                {{ slides[currentSlide].description }}
              </p>
              <button class="btn btn-accent animate-button" @click="handleCTA(slides[currentSlide].action)">
                {{ slides[currentSlide].buttonText }}
              </button>
            </div>
          </transition>
          
          <div class="flex justify-center mt-8 space-x-2">
            <button v-for="(_, index) in slides" 
                    :key="index"
                    @click="currentSlide = index"
                    class="w-3 h-3 rounded-full transition-colors duration-300"
                    :class="currentSlide === index ? 'bg-accent' : 'bg-white bg-opacity-30'">
            </button>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup>
import { ref, onMounted, onBeforeUnmount } from 'vue'

const slides = [
  {
    id: 1,
    title: "당신의 취업 여정을 관리하세요",
    description: "이력서 작성, 자기소개서 작성, 지원 현황 관리를 한 곳에서",
    buttonText: "시작하기",
    action: "start"
  },
  {
    id: 2,
    title: "AI 기반 맞춤 채용 추천",
    description: "당신의 경력과 스킬에 맞는 최적의 채용 정보를 제공합니다",
    buttonText: "채용 보기",
    action: "jobs"
  },
  {
    id: 3,
    title: "실시간 채용 일정 관리",
    description: "중요한 마감일과 면접 일정을 놓치지 마세요",
    buttonText: "일정 확인",
    action: "calendar"
  }
]

const currentSlide = ref(0)
let slideInterval

const startSlideShow = () => {
  slideInterval = setInterval(() => {
    currentSlide.value = (currentSlide.value + 1) % slides.length
  }, 5000)
}

const handleCTA = (action) => {
  // Handle different CTA actions
  console.log('CTA clicked:', action)
}

onMounted(() => {
  startSlideShow()
})

onBeforeUnmount(() => {
  clearInterval(slideInterval)
})
</script>

<style scoped>
.btn-accent {
  background-color: var(--accent-color);
  color: var(--primary-color);
  padding: 0.75rem 1.5rem;
  font-size: 1.125rem;
  border-radius: 0.5rem;
  font-weight: bold;
  transition: all 0.3s ease;
}

.btn-accent:hover {
  background-color: var(--highlight-color);
  transform: translateY(-2px);
}

.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s ease;
}

.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}

.animate-title {
  animation: slideUp 0.8s ease-out;
}

.animate-subtitle {
  animation: slideUp 0.8s ease-out 0.2s both;
}

.animate-button {
  animation: slideUp 0.8s ease-out 0.4s both;
}

@keyframes slideUp {
  from {
    opacity: 0;
    transform: translateY(20px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}
</style>

