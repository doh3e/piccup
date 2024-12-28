<template>
  <section class="py-20 bg-white">
    <div class="container mx-auto px-4 sm:px-6 lg:px-8">
      <h2 class="text-3xl font-bold mb-12 text-center text-primary">PICCUP의 특징</h2>
      <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-8">
        <div v-for="feature in features" :key="feature.title" class="text-center p-6 bg-white rounded-lg shadow-md">
          <img :src="`/icons/${feature.icon}.svg`" :alt="feature.title" class="h-16 w-16 mx-auto mb-4" />
          <h3 class="text-xl font-bold mb-2 text-primary">{{ feature.title }}</h3>
          <p class="text-gray-600 mb-4">{{ feature.description }}</p>
          <button class="btn btn-primary">자세히 보기</button>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup>
const features = [
  { title: '맞춤 채용 추천', description: 'AI 기반으로 개인화된 채용 정보를 제공합니다', icon: 'ai' },
  { title: '원클릭 지원', description: '간편한 지원 프로세스로 빠르게 지원하세요', icon: 'click' },
  { title: '기업 연봉 정보', description: '실제 직원들의 연봉 정보를 확인하세요', icon: 'money' },
  { title: '커리어 성장', description: '다양한 교육 컨텐츠로 역량을 키우세요', icon: 'growth' },
]
</script>

<style scoped>
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

