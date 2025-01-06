<template>
  <div class="p-2 bg-white rounded-lg shadow">
    <!-- 제목 -->
    <div class="mb-2">
      <h2 class="text-lg font-bold text-center text-[#1f1f1f]">이번 달 일정 요약</h2>
    </div>

    <!-- 일정 리스트 -->
    <div
      class="flex overflow-x-auto space-x-2 py-2 cursor-grab"
      ref="scrollContainer"
      @mousedown="startDragging"
      @mouseup="stopDragging"
      @mouseleave="stopDragging"
      @mousemove="drag"
      style="white-space: nowrap; overflow-x: auto;"
    >
      <ScheduleBox
        v-for="(schedule, index) in filteredSchedules"
        :key="index"
        :title="schedule.title"
        :start="schedule.start"
        :end="schedule.end"
        class="inline-block"
      />
    </div>


    <!-- 하단 버튼 -->
    <div class="flex justify-between mt-2">
      <button
        class="px-3 py-1 bg-gray-300 text-black font-medium text-sm rounded hover:bg-gray-400"
        @click="handleViewAll"
      >
        전체목록
      </button>
      <button
        class="px-3 py-1 bg-[#8CD196] text-black font-medium text-sm rounded hover:bg-[#006B40] hover:text-white"
        @click="handleCreateSchedule"
      >
        신규일정
      </button>
    </div>
  </div>
</template>


<script setup>
import ScheduleBox from './ScheduleBox.vue';
import { computed, ref } from 'vue';

const props = defineProps({
  schedules: {
    type: Array,
    required: true,
  },
});

// 이번 달 일정 필터링
const today = new Date();
const firstDayOfMonth = new Date(today.getFullYear(), today.getMonth(), 1);
const lastDayOfMonth = new Date(today.getFullYear(), today.getMonth() + 1, 0);

const filteredSchedules = computed(() =>
  props.schedules.filter(schedule => {
    const startDate = new Date(schedule.start);
    const endDate = new Date(schedule.end);

    return (
      (startDate >= firstDayOfMonth && startDate <= lastDayOfMonth) ||
      (endDate >= firstDayOfMonth && endDate <= lastDayOfMonth) ||
      (startDate <= firstDayOfMonth && endDate >= lastDayOfMonth)
    );
  })
);

const handleViewAll = () => {
  console.log('전체 목록 버튼 클릭됨');
};

const handleCreateSchedule = () => {
  console.log('신규 일정 버튼 클릭됨');
};


const isDragging = ref(false);
const startX = ref(0);
const scrollLeft = ref(0);

const startDragging = (e) => {
  isDragging.value = true;
  startX.value = e.pageX - e.currentTarget.offsetLeft;
  scrollLeft.value = e.currentTarget.scrollLeft;
};

const stopDragging = () => {
  isDragging.value = false;
};

const drag = (e) => {
  if (!isDragging.value) return;
  e.preventDefault();
  const x = e.pageX - e.currentTarget.offsetLeft;
  const walk = (x - startX.value) * 1; // 스크롤 속도 조절
  e.currentTarget.scrollLeft = scrollLeft.value - walk;
};

</script>

<style scoped>
/* 가로 스크롤 스타일 추가 */
.flex {
  scroll-behavior: smooth;
}
.flex::-webkit-scrollbar {
  height: 6px; /* 스크롤바 높이 줄이기 */
}
.flex::-webkit-scrollbar-thumb {
  background-color: #8cd196;
  border-radius: 4px;
}
.flex::-webkit-scrollbar-track {
  background-color: #f1f1f1;
}
</style>
