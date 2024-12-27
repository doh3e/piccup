<template>
<div class="content">
    <div class="container-fluid h-100">
      <div class="row h-100">
        <div class="col-3">
          <div class="card">
            <div class="card-header">
              <h3 class="card-title">
                이벤트
              </h3>
            </div>
            <div class="card-body p-0">
              <div id="external-events">
                <div class="external-event bg-success" data-toggle="modal" data-target="#maintenance">
                  1
                </div>
                <div class="external-event bg-warning">
                  2
                </div>
                <div class="external-event bg-info">
                  3
                </div>
                <div class="external-event bg-primary">
                  4
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-9 h-100">
          <div class="card cal">
            <div class="card-body p-0 h-100">
              <div
                id="calendar"
                class="h-100"
              />
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- /.content -->
    <div id="maintenance" class="modal fade">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">
              이벤트 등록
            </h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="row">
              <label for="title" class="col-3">이벤트명</label>
              <div class="col-9">
                <input id="title" v-model="maintenance.title" class="form-control w-100" type="text">
              </div>
            </div>
            <div class="row">
              <label for="title" class="col-3">색상선택</label>
              <div class="col-9 btn-group w-100 my-20">
                <ul id="color-chooser" class="fc-color-picker">
                  <li><a class="text-primary" href="#" @click="maintenance.color='primary'"><i class="fas fa-square" /></a></li>
                  <li><a class="text-warning" href="#" @click="maintenance.color='warning'"><i class="fas fa-square" /></a></li>
                  <li><a class="text-success" href="#" @click="maintenance.color='success'"><i class="fas fa-square" /></a></li>
                  <li><a class="text-danger" href="#" @click="maintenance.color='danger'"><i class="fas fa-square" /></a></li>
                  <li><a class="text-muted" href="#" @click="maintenance.color='muted'"><i class="fas fa-square" /></a></li>
                </ul>
              </div>
            </div>
            <div class="row">
              <label for="detail" class="col-3">이벤트 세부내용</label>
              <div class="col-9">
                <textarea id="detail" v-model="maintenance.description" class="form-control" rows="3" />
              </div>
            </div>
            <div class="row">
              <span class="col-3">시간</span>
              <input id="bannerDataSdate" type="hidden" name="bannerDataSdate" value="">
              <input id="bannerDataEdate" type="hidden" name="bannerDataEdate" value="">
              <div class="form-group col-9">
                <div class="input-group w-100">
                  <div class="input-group-prepend">
                    <span class="input-group-text"><i class="far fa-clock" /></span>
                  </div>
                  <input id="reservationtime" type="text" class="form-control float-right">
                </div>
              </div>
            </div>
          </div>
          <div class="modal-footer justify-content-between">
            <button type="button" class="btn btn-default" data-dismiss="modal">
              Close
            </button>
            <button type="button" class="btn btn-primary" @click="save()">
              Save changes
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import moment from 'moment';
import { Calendar } from '@fullcalendar/core';
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import $ from 'jquery';

const maintenance = ref({
  title: null,
  description: null,
  color: null,
  startedAt: moment().format('YYYY-MM-DD HH:mm:ss'),
  endedAt: moment().format('YYYY-MM-DD HH:mm:ss'),
});

const save = () => {
  // API Post 로직 작성
};

const setDate = (date1, date2) => {
  maintenance.value.startedAt = moment(date1).format('YYYY-MM-DD 09:00:00');
  maintenance.value.endedAt = moment(date2).format('YYYY-MM-DD 18:00:00');

  $('#reservationtime').daterangepicker({
    timePicker: true,
    startDate: moment(date1).format('YYYY-MM-DD 09:00:00'),
    endDate: moment(date2).format('YYYY-MM-DD 18:00:00'),
    timePickerIncrement: 30,
    locale: {
      format: 'YYYY-MM-DD HH:mm:ss',
    },
  });
};

const initCalendar = () => {
  const calendarEl = document.getElementById('calendar');

  const calendar = new Calendar(calendarEl, {
    plugins: [dayGridPlugin, interactionPlugin],
    headerToolbar: {
      left: 'prev,next today',
      center: 'title',
      right: 'dayGridMonth,timeGridWeek,timeGridDay',
    },
    editable: true,
    droppable: true,
    drop(info) {
      $('#maintenance').modal('show');
      setDate(new Date(info.dateStr), new Date(info.dateStr));
    },
    dateClick(info) {
      $('#maintenance').modal('show');
      setDate(new Date(info.dateStr), new Date(info.dateStr));
    },
    eventClick(info) {
      $('#maintenance').modal('show');
    },
  });
  calendar.render();
};

onMounted(() => {
  initCalendar();
  setDate(new Date(), new Date());
});
</script>


<style scoped>
</style>