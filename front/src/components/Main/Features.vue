<template>
  <section class="py-20 bg-white">
    <div class="container mx-auto px-4 sm:px-6 lg:px-8">
      <h2 class="text-3xl font-bold mb-12 text-center text-primary">
        원 클릭 PICCUP 사용
      </h2>
      <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-8">
        <div
          v-for="feature in features"
          :key="feature.title"
          class="text-center p-6 bg-white rounded-lg shadow-md"
        >
          <div class="icon-container h-16 w-16 mx-auto mb-4">
            <img
              :src="`/src/assets/icons/${feature.icon}.gif`"
              :class="['feature-icon', `icon-${feature.icon}`]"
              :alt="feature.title"
              @mouseenter="playGif"
              @mouseleave="pauseGif"
            />
          </div>
          <h3 class="text-xl font-bold mb-2 text-primary">
            {{ feature.title }}
          </h3>
          <p class="text-gray-600 mb-4">{{ feature.description }}</p>
          <button class="btn btn-primary">자세히 보기</button>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup>
const playGif = (event) => {
  event.target.style.animationPlayState = "running";
};

const pauseGif = (event) => {
  event.target.style.animationPlayState = "paused";
};

const features = [
  {
    title: "이력서 작성",
    description: "맞춤형 템플릿으로 전문적인 이력서를 쉽게 작성하세요",
    icon: "resume",
  },
  {
    title: "자기소개서 작성",
    description: "이력서 기반으로 쉽게 자기소개서를 만들어보세요",
    icon: "coverletter",
  },
  {
    title: "자기소개서 목록",
    description: "작성한 자기소개서를 한눈에 보고 기업별로 관리하세요",
    icon: "board",
  },
  {
    title: "채용 달력",
    description: "채용 일정과 마감일을 놓치지 않도록 체계적으로 관리해요",
    icon: "calendar",
  },
];
</script>

<style scoped>
.feature-icon {
  width: 100%;
  height: 100%;
  object-fit: contain;
  animation-play-state: paused;
}

.icon-container {
  display: flex;
  align-items: center;
  justify-content: center;
}
.btn-primary {
  background-color: var(--primary-color);
  color: white;
  padding: 0.5rem 1rem;
  font-size: 0.875rem;
  border-radius: 0.375rem;
  font-weight: bold;
  transition: all 0.2s;
}

.btn-primary:hover {
  background-color: var(--secondary-color);
}
</style>
