<template>
  <section class="bg-pixel-bg py-20" style="background-color: var(--color-dark);">
    <div class="container mx-auto px-4 sm:px-6 lg:px-8">
      <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
        <div class="pixel-box p-6" style="background-color: var(--bg);">
          <h3 class="text-lg font-semibold mb-4 text-color-tan pixel-text">빠른 접근</h3>
          <div class="space-y-4">
            <button v-for="action in quickActions" :key="action" class="pixel-button w-full text-xs pixel-text" style="background-color: var(--color-light); color: var(--color-dark);">
              {{ action }}
            </button>
          </div>
        </div>
        <div class="pixel-box p-6" style="background-color: var(--bg);">
          <h3 class="text-lg font-semibold mb-4 text-color-tan pixel-text">이력서/자기소개서 템플릿</h3>
          <p class="text-color-light mb-4 text-xs pixel-text">다양한 산업과 직무에 맞는 전문적인 템플릿을 제공합니다.</p>
          <button class="pixel-button bg-color-light text-xs pixel-text" style="color: var(--color-dark);">템플릿 보기</button>
        </div>
        <div class="pixel-box p-6" style="background-color: var(--bg);">
          <h3 class="text-lg font-semibold mb-4 text-color-tan pixel-text">다가오는 일정</h3>
          <ul class="space-y-2">
            <li v-for="event in upcomingEvents" :key="event.date" class="flex justify-between items-center">
              <span class="text-color-light text-xs pixel-text">{{ event.title }}</span>
              <span class="text-color-tan text-xs pixel-text">{{ event.date }}</span>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup>
defineProps({
  quickActions: {
    type: Array,
    required: true
  },
  upcomingEvents: {
    type: Array,
    required: true
  }
})
</script>

