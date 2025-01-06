<template>
  <div
    v-if="isOpen"
    class="fixed inset-0 bg-black bg-opacity-50 flex justify-center items-center z-50"
  >
    <div class="bg-white w-96 p-5 rounded shadow">
      <!-- 모달 헤더 -->
      <div class="flex justify-between items-center mb-4">
        <h2 class="text-lg font-bold">{{ title }}</h2>
        <button
          class="text-gray-500 hover:text-gray-800"
          @click="$emit('close-modal')"
        >
          &times;
        </button>
      </div>

      <!-- 일정 생성 폼 -->
      <form @submit.prevent="handleSubmit">
        <!-- 스케줄명 -->
        <div class="mb-4">
          <label for="scheduleName" class="block text-sm font-medium text-gray-700">스케줄명</label>
          <input
            id="scheduleName"
            type="text"
            v-model="form.scheduleName"
            class="w-full p-2 border rounded"
            required
          />
        </div>

        <!-- 시작 시간 -->
        <div class="mb-4">
          <label for="startAt" class="block text-sm font-medium text-gray-700">시작 시간</label>
          <input
            id="startAt"
            type="datetime-local"
            v-model="form.startAt"
            class="w-full p-2 border rounded"
            required
          />
        </div>

        <!-- 종료 시간 -->
        <div class="mb-4">
          <label for="endAt" class="block text-sm font-medium text-gray-700">종료 시간</label>
          <input
            id="endAt"
            type="datetime-local"
            v-model="form.endAt"
            class="w-full p-2 border rounded"
            required
          />
        </div>

        <!-- 중요도 -->
        <div class="mb-4">
          <label for="importance" class="block text-sm font-medium text-gray-700">중요도</label>
          <select
            id="importance"
            v-model="form.importance"
            class="w-full p-2 border rounded"
            required
          >
            <option value="1">안중요</option>
            <option value="2">보통</option>
            <option value="3">개중요</option>
          </select>
        </div>

        <!-- 버튼 -->
        <div class="flex justify-end space-x-2">
          <button
            type="button"
            class="px-4 py-2 bg-gray-300 rounded hover:bg-gray-400"
            @click="$emit('close-modal')"
          >
            취소
          </button>
          <button
            type="submit"
            class="px-4 py-2 bg-[#8CD196] text-white rounded hover:bg-[#006B40]"
          >
            저장
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { reactive } from 'vue';
import { apiAuth } from '@/api/index.js';

const props = defineProps({
  isOpen: { type: Boolean, required: true }, // 모달 열림 상태
  title: { type: String, required: true },  // 모달 제목
});

const emits = defineEmits(['close-modal']);

// 폼 데이터
const form = reactive({
  scheduleName: '',
  startAt: '',
  endAt: '',
  importance: 2,
});

// API 호출 로직
const handleSubmit = async () => {
  try {
    const response = await apiAuth.post('/mydata/calendar', form);
    console.log('일정 생성 성공:', response.data);

    // 모달 닫기
    emits('close-modal');
  } catch (error) {
    console.error('일정 생성 실패:', error);
  }
};
</script>

<style scoped>

</style>
