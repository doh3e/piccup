<template>
  <section class="bg-pixel-bg py-20" style="background-color: var(--color-dark);">
    <div class="container mx-auto px-4 sm:px-6 lg:px-8">
      <h2 class="text-xl font-bold text-center mb-12 text-color-tan pixel-text">최신 채용 정보</h2>
      <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
        <div v-for="job in jobs" :key="job.id" class="pixel-box p-6" style="background-color: var(--bg);">
          <div class="flex items-center mb-4">
            <img :src="`/icons/${job.icon}.png`" :alt="job.company" class="h-12 w-12 mr-4" />
            <div>
              <h3 class="font-semibold text-color-tan text-sm pixel-text">{{ job.title }}</h3>
              <p class="text-color-light text-xs pixel-text">{{ job.company }}</p>
            </div>
          </div>
          <p class="text-color-light text-xs pixel-text">{{ job.location }}</p>
        </div>
      </div>
      <div class="text-center mt-12">
        <button class="pixel-button bg-color-light text-color-dark text-sm pixel-text">�� 보기</button>
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

