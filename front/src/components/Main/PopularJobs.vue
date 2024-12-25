<template>
  <section class="py-20 bg-gray-50">
    <div class="container mx-auto px-4 sm:px-6 lg:px-8">
      <h2 class="text-3xl font-bold mb-12 text-center text-primary">인기 채용 정보</h2>
      <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
        <div v-for="job in jobs" 
             :key="job.id" 
             class="bg-white p-6 rounded-lg shadow-md hover:shadow-lg transition-all duration-300 hover:-translate-y-1 cursor-pointer">
          <div class="flex items-center mb-4">
            <div class="icon-wrapper mr-4">
              <img :src="`/icons/${job.icon}.svg`" 
                   :alt="job.company" 
                   class="h-12 w-12 transform transition-transform duration-300 hover:scale-110" />
            </div>
            <div>
              <h3 class="font-bold text-lg text-primary hover:text-secondary transition-colors">
                {{ job.title }}
              </h3>
              <p class="text-gray-600">{{ job.company }}</p>
            </div>
          </div>
          <p class="text-gray-600 mb-2">{{ job.location }}</p>
          <p class="text-secondary font-bold transform transition-all duration-300 hover:scale-105">
            연봉 {{ job.salary }}
          </p>
        </div>
      </div>
      <div class="text-center mt-12">
        <button class="btn btn-outline-primary hover-lift focus-visible">
          더 많은 채용정보 보기
        </button>
      </div>
    </div>
  </section>
</template>

<script setup>
defineProps({
  jobs: {
    type: Array,
    required: true
  }
})
</script>

<style scoped>
.btn-outline-primary {
  border: 2px solid var(--primary-color);
  color: var(--primary-color);
  padding: 0.75rem 1.5rem;
  font-size: 1rem;
  border-radius: 0.375rem;
  font-weight: bold;
  transition: all 0.3s ease;
}

.btn-outline-primary:hover {
  background-color: var(--primary-color);
  color: white;
  transform: translateY(-2px);
  box-shadow: 0 4px 6px -1px rgba(0, 107, 64, 0.1), 
              0 2px 4px -1px rgba(0, 107, 64, 0.06);
}

.icon-wrapper {
  position: relative;
  overflow: hidden;
  border-radius: 0.5rem;
}

.icon-wrapper::after {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: radial-gradient(circle, transparent 50%, rgba(140, 209, 150, 0.1) 100%);
  opacity: 0;
  transition: opacity 0.3s ease;
}

.icon-wrapper:hover::after {
  opacity: 1;
}
</style>

