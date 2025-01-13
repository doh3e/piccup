<template>
  <div
    class="flex flex-col items-center justify-between p-3 bg-[#f8f8f8] rounded-lg shadow h-[7.5rem] min-w-[6rem] flex-shrink-0"
  >
    <h3 class="text-sm font-bold text-[#1f1f1f] text-center">{{ title }}</h3>
    <p class="text-[13px] text-gray-500 text-center">{{ start }} ~ {{ end }}</p>
  </div>
</template>


<script setup>
const props = defineProps({
  title: { type: String, required: true },
  start: { type: String, required: true },
  end: { type: String, required: true },
});
</script>

<style scoped>
</style>
