<template>
    <div class="bg-white p-6 rounded-lg shadow-md">
      <h2 class="text-2xl font-bold text-primary mb-4">내 이력서</h2>
      <div class="relative">
        <div class="overflow-hidden">
          <div class="flex transition-transform duration-300 ease-in-out" :style="carouselStyle">
            <div v-for="resume in resumes" :key="resume.id" class="w-full flex-shrink-0 px-4">
              <div class="border border-gray-200 rounded-lg p-4">
                <h3 class="text-lg font-semibold mb-2">{{ resume.title }}</h3>
                <!-- Add more resume details here -->
              </div>
            </div>
          </div>
        </div>
        <button 
          @click="prevSlide" 
          class="absolute left-0 top-1/2 transform -translate-y-1/2 bg-white p-2 rounded-full shadow-md"
          :disabled="currentIndex === 0"
        >
          <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 19l-7-7 7-7" />
          </svg>
        </button>
        <button 
          @click="nextSlide" 
          class="absolute right-0 top-1/2 transform -translate-y-1/2 bg-white p-2 rounded-full shadow-md"
          :disabled="currentIndex === resumes.length - 1"
        >
          <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7" />
          </svg>
        </button>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, computed } from 'vue';
  
  const props = defineProps({
    resumes: {
      type: Array,
      required: true
    }
  });
  
  const currentIndex = ref(0);
  
  const carouselStyle = computed(() => {
    return {
      transform: `translateX(-${currentIndex.value * 100}%)`
    };
  });
  
  const prevSlide = () => {
    if (currentIndex.value > 0) {
      currentIndex.value--;
    }
  };
  
  const nextSlide = () => {
    if (currentIndex.value < props.resumes.length - 1) {
      currentIndex.value++;
    }
  };
  </script>
  
  