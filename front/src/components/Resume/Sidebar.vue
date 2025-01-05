<template>
  <div class="w-64 relative">
    <div class="fixed top-20 w-64 bg-white shadow-md p-4 flex flex-col">
      <h2 class="text-xl font-bold text-[#006B40] mb-4">이력서 항목</h2>
      <ul class="space-y-2">
        <li v-for="section in sections" :key="section.id">
          <button
            @click="$emit('toggle-section', section.id)"
            class="w-full text-left px-3 py-2 rounded transition"
            :class="{
              'bg-[#E6FF94] text-[#006B40]': section.isActive,
              'hover:bg-gray-100': !section.isActive,
            }"
          >
            {{ section.name }}
          </button>
        </li>
      </ul>
      <button
        @click="saveResume"
        class="w-full px-4 py-2 bg-[#006B40] text-white rounded hover:bg-opacity-90 transition mt-4"
      >
        저장
      </button>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    sections: Array,
    saveResume: Function,
  },
  emits: ["toggle-section"],
};
</script>
