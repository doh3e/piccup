<template>
  <div class="p-4 bg-white rounded-lg shadow">
    <!-- 제목 -->
    <div class="mb-4">
      <h2 class="text-lg font-bold text-[#1f1f1f]">이번 달 일정 요약</h2>
    </div>

    <!-- 일정 리스트 -->
    <div
      class="listbox flex overflow-x-auto space-x-4 py-4 cursor-grab"
      ref="scrollContainer"
      @mousedown="startDragging"
      @mouseup="stopDragging"
      @mouseleave="stopDragging"
      @mousemove="drag"
      @touchstart="startDragging"
      @touchend="stopDragging"
      @touchmove="drag"
    >
      <ScheduleBox
        v-for="(schedule, index) in filteredSchedules"
        :key="index"
        :title="schedule.title"
        :start="schedule.start"
        :end="schedule.end"
      />
    </div>

    <!-- 하단 버튼 -->
    <div class="flex justify-between mt-4">
      <button
        class="px-4 py-2 bg-gray-300 text-black font-medium text-sm rounded hover:bg-gray-400"
        @click="handleViewAll"
      >
        전체목록
      </button>
      <button
        class="px-4 py-2 bg-[#8CD196] text-black font-medium text-sm rounded hover:bg-[#006B40] hover:text-white"
        @click="emitOpenModal"
      >
        신규일정
      </button>
    </div>
  </div>
</template>

<script setup>
import ScheduleBox from './ScheduleBox.vue';
import { computed, ref } from 'vue';

// 부모로 이벤트 전달
const emit = defineEmits(['open-modal']);

// props로 받은 schedules
const props = defineProps({
  schedules: {
    type: Array,
    required: true,
  },
});

// 현재 날짜 기준 이번 달의 첫날과 마지막 날 계산
const today = new Date();
const firstDayOfMonth = new Date(today.getFullYear(), today.getMonth(), 1);
const lastDayOfMonth = new Date(today.getFullYear(), today.getMonth() + 1, 0);

// 이번 달에 포함된 일정 필터링
const filteredSchedules = computed(() => {
  return props.schedules.filter(schedule => {
    const startDate = new Date(schedule.start);
    const endDate = new Date(schedule.end);

    return (
      (startDate >= firstDayOfMonth && startDate <= lastDayOfMonth) ||
      (endDate >= firstDayOfMonth && endDate <= lastDayOfMonth) ||
      (startDate <= firstDayOfMonth && endDate >= lastDayOfMonth)
    );
  });
});

// 드래그 및 스와이프 스크롤 동작
const isDragging = ref(false);
const startX = ref(0);
const scrollLeft = ref(0);

const startDragging = (e) => {
  isDragging.value = true;
  startX.value = e.pageX || e.touches[0].pageX;
  scrollLeft.value = e.currentTarget.scrollLeft;
};

const stopDragging = () => {
  isDragging.value = false;
};

const drag = (e) => {
  if (!isDragging.value) return;
  e.preventDefault();
  const x = e.pageX || e.touches[0].pageX;
  const walk = (x - startX.value) * 1; // 스크롤 속도 조절
  e.currentTarget.scrollLeft = scrollLeft.value - walk;
};

// 전체 목록 보기
const handleViewAll = () => {
  console.log("전체 목록 버튼 클릭됨");
};

// 신규 일정 생성 버튼 클릭 시 부모로 이벤트 전달
const emitOpenModal = () => {
  emit('open-modal');
};
</script>

<style scoped>
/* 가로 스크롤 스타일 추가 */
.listbox {
  overflow-x: scroll;
  scroll-behavior: smooth;
  cursor: grab;
}

.listbox:active {
  cursor: grabbing;
}

.listbox::-webkit-scrollbar {
  display: none;
}
</style>
