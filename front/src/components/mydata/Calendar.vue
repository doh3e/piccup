<template>
  <div class="flex justify-center items-center w-full h-full">
    <div id="calendar" class="w-full h-[60vh] p-4 bg-white rounded-lg shadow"></div>
  </div>
</template>

<script setup>
import { onMounted, watchEffect } from 'vue';
import { Calendar } from '@fullcalendar/core';
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';

const props = defineProps({
  events: {
    type: Array,
    required: true, // 부모 컴포넌트에서 반드시 전달해야 함
  },
});

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
    events: props.events,
    eventBorderColor: 'transparent',
    eventContent: function(info) {
      return { html: `<span style="overflow: hidden;">${info.event.title}</span>` };
    },
    dateClick(info) {
      console.log('Date clicked:', info.dateStr);
    },
    eventClick(info) {
      console.log('Event clicked:', info.event);
    },
  });

  calendar.render();

  // events가 변경되면 FullCalendar 업데이트
  watchEffect(() => {
    calendar.removeAllEvents();
    calendar.addEventSource(props.events);
  });
};

onMounted(initCalendar);
</script>

<style scoped>



</style>
