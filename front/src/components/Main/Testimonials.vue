<template>
  <section class="py-20 bg-pixel-bg" style="background-color: var(--color-dark);">
    <div class="container mx-auto px-4 sm:px-6 lg:px-8">
      <h2 class="text-xl font-bold text-center mb-12 text-color-tan pixel-text">사용자 후기</h2>
      <div class="grid grid-cols-1 md:grid-cols-3 gap-8">
        <div v-for="testimonial in testimonials" :key="testimonial.name" class="pixel-box p-6" style="background-color: var(--bg);">
          <div class="flex items-center mb-4">
            <img :src="`/avatars/${testimonial.avatar}.png`" :alt="testimonial.name" class="h-12 w-12 mr-4" />
            <div>
              <h3 class="font-semibold text-color-tan text-sm pixel-text">{{ testimonial.name }}</h3>
              <p class="text-color-light text-xs pixel-text">{{ testimonial.position }}</p>
            </div>
          </div>
          <p class="text-color-light text-xs italic pixel-text">"{{ testimonial.quote }}"</p>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup>
defineProps({
  testimonials: {
    type: Array,
    required: true
  }
})
</script>

