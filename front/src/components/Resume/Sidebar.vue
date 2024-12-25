<template>
  <div class="w-64 bg-white shadow-md p-4 overflow-y-auto">
    <h2 class="text-xl font-bold text-[#006B40] mb-4">Resume Sections</h2>
    <ul class="space-y-2">
      <li v-for="section in sections" :key="section.id">
        <button
          @click="$emit('toggle-section', section.id)"
          class="w-full text-left px-3 py-2 rounded transition"
          :class="{
            'bg-[#E6FF94] text-[#006B40]': section.isActive,
            'hover:bg-gray-100': !section.isActive
          }"
        >
          {{ section.name }}
        </button>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  props: {
    sections: Array,
  },
  emits: ['toggle-section']
}
</script>

