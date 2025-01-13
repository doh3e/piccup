<template>
  <div class="dashboard-main">

  </div>
</template>

<script setup>

import { onMounted, ref } from 'vue';
import { apiAuth } from '@/api/index.js';

const dashboard = ref([]);
const summary = ref({});

// 대시보드 데이터 로드
const loadDashBoardData = async () => {
  try {
    const response = await apiAuth.get('/mydata/dashboard');
    dashboard.value = response.data.dashboard;
    summary.value = response.data.summary;
    console.log(dashboard.value);
    console.log(summary.value);

  } catch (error) {
    console.error('대시보드 생성 중 에러:', error);
  }
};

onMounted(async () => {
  loadDashBoardData();
});

</script>

<style scoped>
</style>