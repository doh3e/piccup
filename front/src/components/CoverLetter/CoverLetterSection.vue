<template>
  <div class="bg-white p-6 rounded-lg shadow-md">
    <h2 class="text-2xl font-bold text-primary mb-4">{{ title }}</h2>
    <div class="relative">
      <textarea
        v-model="localContent"
        @input="$emit('update:content', localContent)"
        rows="6"
        class="w-full p-2 border border-gray-300 rounded-md focus:ring-primary focus:border-primary"
        :placeholder="`${title}을(를) 작성해주세요...`"
      ></textarea>
      <div class="absolute bottom-2 right-2 text-sm text-gray-500">
        {{ characterCount }}자
      </div>
    </div>
    <div class="flex justify-end mt-4">
      <button 
        @click="$emit('save')"
        class="bg-secondary text-[#006B40] px-4 py-2 rounded-md hover:bg-opacity-90 transition duration-300 border border-gray-300"
      >
        저장
      </button>
    </div>
  </div>
</template>

<script setup>
import { ref, watch, computed } from 'vue';

const props = defineProps({
  title: {
    type: String,
    required: true
  },
  content: {
    type: String,
    default: ''
  }
});

const emit = defineEmits(['update:content', 'save']);

const localContent = ref(props.content);

const characterCount = computed(() => {
  return localContent.value ? localContent.value.length : 0;
});

watch(() => props.content, (newContent) => {
  localContent.value = newContent;
});
</script>
