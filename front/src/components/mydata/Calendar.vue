<template>
  <div class="content">
    <div class="container-fluid h-100 d-flex justify-content-center align-items-center">
      <div class="row w-75">
        <div class="col-12">
          <div class="card cal">
            <div class="card-body p-3">
              <div id="calendar" class="calendar-size" />
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { onMounted } from 'vue';
import { Calendar } from '@fullcalendar/core';
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';

const initCalendar = () => {
  const calendarEl = document.getElementById('calendar');

  const calendar = new Calendar(calendarEl, {
    plugins: [dayGridPlugin, interactionPlugin],
    headerToolbar: {
      left: 'prev',
      center: 'title',
      right: 'today next',
    },
    editable: true,
    droppable: true,
    events: [
      {
        title: '약속', // 일정 제목
        start: '2025-01-04', // 시작 날짜
        end: '2025-01-04', // 끝 날짜 (같은 날이라면 생략 가능)
        color: '#007BFF', // 일정 배경 색상
        textColor: '#FFFFFF', // 일정 텍스트 색상
      },
    ],
    dateClick(info) {
      console.log('Date clicked:', info.dateStr);
    },
    eventClick(info) {
      console.log('Event clicked:', info.event);
    },
  });
  calendar.render();
};

onMounted(() => {
  initCalendar();
});
</script>

<style scoped>
.calendar-size {
  width: 100%;
  height: 60%;
  margin: 0 auto;
}
</style>
