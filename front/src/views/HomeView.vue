<template>
  <main>
    <h1>{{ message }}</h1>
  </main>
</template>

<script setup>

import { publicAxios } from '@/utils/axios'
import { ref, onMounted } from 'vue'

const message = ref('')

const fetchPublicData = async () => {
  try {
    const response = await publicAxios.get('/index')
    message.value = response.data
  } catch (error) {
    console.error('Error:', error)
  }
}

onMounted(() => {
  fetchPublicData()
})

</script>

