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
import { onMounted, watchEffect, ref } from 'vue';
import { Calendar } from '@fullcalendar/core';
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import { apiAuth } from '@/api/index.js';

const events = ref([]); // FullCalendar에서 사용하는 이벤트 배열
const mySchedules = ref([]); // 개인 스케줄
const myApplySchedules = ref([]); // 취업 일정 스케줄

const initCalendar = () => {
  const calendarEl = document.getElementById('calendar');
  if (!calendarEl) {
    console.error("Calendar element not found");
    return;
  }

  const calendar = new Calendar(calendarEl, {
    plugins: [dayGridPlugin, interactionPlugin],
    headerToolbar: {
      left: 'prev',
      center: 'title',
      right: 'today next',
    },
    editable: true,
    droppable: true,
    events: events.value, // 초기 이벤트 데이터
    dateClick(info) {
      console.log('Date clicked:', info.dateStr);
    },
    eventClick(info) {
      console.log('Event clicked:', info.event);
    },
  });

  calendar.render();

  watchEffect(() => {
    calendar.removeAllEvents();
    calendar.addEventSource(events.value);
  });
};

// 개인 스케줄 로드
const loadMySchedules = async () => {
  try {
    const response = await apiAuth.get('/mydata/calendar');
    const schedules = response.data.schedules;

    mySchedules.value = schedules.map(schedule => {
      let backgroundColor = '#6c757d';
      let textColor = '#FFFFFF';

      if (schedule.importance === 3) {
        backgroundColor = '#006B40';
      } else if (schedule.importance === 2) {
        backgroundColor = '#8CD196';
      }

      const startDate = schedule.startAt.split(' ')[0];
      const endDate = schedule.endAt.split(' ')[0];

      return {
        title: schedule.scheduleName,
        start: startDate,
        end: endDate,
        color: backgroundColor,
        textColor: textColor,
      };
    });
  } catch (error) {
    console.error('Failed to load personal schedules:', error);
  }
};

// 취업 스케줄 로드
const loadMyApplySchedules = async () => {
  try {
    const response = await apiAuth.get('/mydata/applyschedule');
    console.log(response.data.applySchedules)
    const schedules = response.data.applySchedules;

    myApplySchedules.value = schedules.map(schedule => {
      let backgroundColor = '#007BFF';
      let textColor = '#FFFFFF';

      if (schedule.progressing) {
        backgroundColor = '#E35454'
      } else if (!schedule.progressing) {
        backgroundColor = '#FFDCDC'
        textColor = '#000000'
      }

      const startDate = schedule.startDate.split(' ')[0];
      const endDate = schedule.endDate.split(' ')[0];

      return {
        title: `${schedule.companyName} (${schedule.currentStatus})`,
        start: startDate,
        end: endDate,
        color: backgroundColor,
        textColor: textColor,
      };
    });
  } catch (error) {
    console.error('Failed to load application schedules:', error);
  }
};

// 모든 스케줄 로드 후 events에 합치기
const loadAllSchedules = async () => {
  await Promise.all([loadMySchedules(), loadMyApplySchedules()]);
  events.value = [...mySchedules.value, ...myApplySchedules.value]; // 두 스케줄을 합침
};

onMounted(async () => {
  await loadAllSchedules();
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
