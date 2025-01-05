<template>
  <div class="mydata-main flex flex-col items-center mx-auto h-screen w-9/10">
    <div class="mydata-title mb-4">
      <h1 class="text-3xl font-bold text-center text-primary text-[#006B40]">마이데이터</h1>
    </div>
    <div class="flex flex-grow w-full h-full">
      <div class="w-1/2 bg-gray-100 overflow-y-auto">
        <Calendar />
      </div>
      <div class="w-1/2 bg-gray-200 overflow-y-auto">
        <Dashboard />
      </div>
    </div>
  </div>
</template>

<script setup>
import Calendar from '@/components/Mydata/Calendar.vue';
import Dashboard from '@/components/Mydata/Dashboard.vue';
</script>

<style scoped>
</style>
