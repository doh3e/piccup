<template>
  <div class="mydata-main flex flex-col items-center mx-auto h-screen w-9/10">
    <!-- 제목 섹션 -->
    <div class="mydata-title mb-4">
      <h1 class="text-3xl font-bold text-center text-primary text-[#006B40]">마이데이터</h1>
    </div>

    <div 
      class="flex flex-grow w-full h-full lg:flex-row flex-col"
    >
      <!-- 왼쪽: 일정 요약 + 캘린더 -->
      <div 
        class="flex flex-col w-full lg:w-1/2 bg-gray-100 p-5"
      >
        <!-- 일정 요약 -->
        <div 
          class="w-full lg:w-auto p-4 bg-f8f8f8 rounded-lg transition-all mb-12"
          :class="{
            'h-full mx-auto text-center max-w-sm': isMobileView,
            'h-1/5': !isMobileView
          }"
        >
          <CalendarTop :schedules="events" @open-modal="openModal" />
        </div>

        <!-- 캘린더 -->
        <div 
          class="w-full h-4/5 p-4 bg-f8f8f8 rounded-lg hidden lg:block"
        >
          <Calendar :events="events" />
        </div>
      </div>

      <!-- 오른쪽: Dashboard -->
      <div 
        class="bg-gray-200 w-full h-full lg:w-1/2 overflow-y-auto p-4"
      >
        <Dashboard />
      </div>
    </div>

    <!-- 일정 생성 모달 -->
    <ScheduleModal
      :isOpen="isModalOpen"
      title="일정 생성"
      @close-modal="closeModal"
    />
  </div>
</template>

<script setup>
import Calendar from '@/components/Mydata/Calendar.vue';
import CalendarTop from '@/components/Mydata/CalendarTop.vue';
import Dashboard from '@/components/Mydata/Dashboard.vue';
import ScheduleModal from '@/components/Mydata/ScheduleModal.vue';
import { ref, onMounted, onUnmounted } from 'vue';
import { apiAuth } from '@/api/index.js';

const isMobileView = ref(window.innerWidth < 1024);

const handleResize = () => {
  isMobileView.value = window.innerWidth < 1024; // 화면 크기 변경 시 업데이트
};

const events = ref([]); // FullCalendar 이벤트 배열
const isModalOpen = ref(false); // 모달 상태

// 모달 열기/닫기
const openModal = () => {
  isModalOpen.value = true;
};

const closeModal = () => {
  isModalOpen.value = false;
};

// 데이터 로드 함수
const loadAllSchedules = async () => {
  try {
    const [mySchedulesResponse, myApplySchedulesResponse] = await Promise.all([
      apiAuth.get('/mydata/calendar'),
      apiAuth.get('/mydata/applyschedule'),
    ]);

    events.value = [
        ...mySchedulesResponse.data.schedules.map(schedule => {
      let backgroundColor = ''; // 기본값: 중요도 1
      let textColor = ''; // 기본값: 검은 텍스트

      if (schedule.importance === 3) {
        backgroundColor = '#006B40'; // 중요도 3: 진한 녹색
        textColor = '#FFFFFF'; // 흰색 텍스트
      } else if (schedule.importance === 2) {
        backgroundColor = '#8CD196'; // 중요도 2: 연한 녹색
        textColor = '#FFFFFF'; // 흰색 텍스트
      } else if (schedule.importance === 1) {
        backgroundColor = '#e8e8e8'; // 중요도 2: 연한 녹색
        textColor = '#000000'; // 흰색 텍스트
      }

      return {
        title: schedule.scheduleName,
        start: schedule.startAt,
        end: schedule.endAt,
        backgroundColor: backgroundColor,
        textColor: textColor,
      };
    }),

      ...myApplySchedulesResponse.data.applySchedules.map(schedule => ({
        title: `${schedule.companyName} (${schedule.currentStatus})`,
        start: schedule.startDate,
        end: schedule.endDate,
        backgroundColor: schedule.progressing ? '#E35454' : '#FFDCDC',
        textColor: schedule.progressing ? '#FFFFFF' : '#000000',
      })),
    ];

    console.log(events.value)
  } catch (error) {
    console.error('스케줄 로드 실패:', error);
  }
};

// 초기 데이터 로드
onMounted(() => {
  loadAllSchedules();
  window.addEventListener('resize', handleResize); // 화면 크기 변경 이벤트 등록
});

onUnmounted(() => {
  window.removeEventListener('resize', handleResize); // 컴포넌트가 언마운트될 때 이벤트 제거
});

</script>
