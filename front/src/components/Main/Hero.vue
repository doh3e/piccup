<template>
  <section
    class="py-20 bg-gradient-to-br from-primary to-secondary relative overflow-hidden"
  >
    <div class="container mx-auto px-4 sm:px-6 lg:px-8">
      <div class="max-w-4xl mx-auto">
        <div class="carousel-container relative">
          <transition name="fade" mode="out-in">
            <div :key="currentSlide" class="text-center">
              <h1
                class="text-4xl md:text-5xl lg:text-6xl font-black mb-4 text-black animate-title"
              >
                {{ slides[currentSlide].title }}
              </h1>
              <p class="text-xl mb-8 text-accent animate-subtitle">
                {{ slides[currentSlide].description }}
              </p>
              <button
                class="btn btn-accent animate-button"
                @click="handleCTA(slides[currentSlide].action)"
              >
                {{ slides[currentSlide].buttonText }}
              </button>
            </div>
          </transition>

          <div class="flex justify-center mt-8 space-x-2">
            <button
              v-for="(_, index) in slides"
              :key="index"
              @click="currentSlide = index"
              class="w-3 h-3 rounded-full transition-colors duration-300"
              :class="
                currentSlide === index ? 'bg-accent' : 'bg-white bg-opacity-30'
              "
            ></button>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup>
import { ref, onMounted, onBeforeUnmount } from "vue";
import { useRouter } from "vue-router";

const slides = [
  {
    id: 1,
    title: "전문적인 이력서를 작성하세요",
    description: "당신의 경력을 돋보이게 만들어 줄 맞춤형 이력서 템플릿",
    buttonText: "이력서 작성하기",
    action: "/resume-preview",
  },
  {
    id: 2,
    title: "인상적인 자기소개서 작성",
    description: "당신의 이야기를 효과적으로 전달할 수 있는 자기소개서 가이드",
    buttonText: "자기소개서 시작하기",
    action: "/cover-letter",
  },
  {
    id: 3,
    title: "자기소개서 관리 및 비교",
    description: "작성한 자기소개서를 한눈에 보고 관리할 수 있는 대시보드",
    buttonText: "자기소개서 목록 보기",
    action: "/board",
  },
  {
    id: 4,
    title: "궁금한 점이 있으신가요?",
    description: "취업 준비에 관한 모든 질문에 답해드립니다",
    buttonText: "고객센터 방문하기",
    action: "/faq",
  },
  {
    id: 5,
    title: "나만의 취업 데이터 관리",
    description: "지원 이력, 면접 일정, 피드백 등을 체계적으로 관리하세요",
    buttonText: "마이데이터 확인하기",
    action: "/mydata",
  },
];

const currentSlide = ref(0);
let slideInterval;

const startSlideShow = () => {
  slideInterval = setInterval(() => {
    currentSlide.value = (currentSlide.value + 1) % slides.length;
  }, 5000);
};

const router = useRouter();

const handleCTA = (action) => {
  router.push(action);
};

onMounted(() => {
  startSlideShow();
});

onBeforeUnmount(() => {
  clearInterval(slideInterval);
});
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
