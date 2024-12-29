<template>
  <section class="py-20 bg-gray-50">
    <div class="container mx-auto px-4 sm:px-6 lg:px-8">
      <h2 class="text-3xl font-bold mb-12 text-center text-primary">주요 채용 기업</h2>
      <div class="grid grid-cols-2 md:grid-cols-3 lg:grid-cols-6 gap-8">
        <div v-for="company in companies" :key="company.name" class="flex items-center justify-center">
          <img :src="`/company-logos/${company.logo}`" :alt="company.name" class="h-12 w-auto grayscale hover:grayscale-0 transition-all" />
        </div>
      </div>
    </div>
  </section>
</template>

<script setup>
defineProps({
  companies: {
    type: Array,
    required: true
  }
})
</script>

