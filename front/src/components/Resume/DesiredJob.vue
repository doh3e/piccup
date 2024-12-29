<template>
  <div class="bg-white p-6 rounded-lg shadow">
    <h2 class="text-2xl font-bold text-[#006B40] mb-4">희망 직무</h2>
    <p class="text-sm text-gray-600 mb-4">
      관심 있는 직무, 직업, 또는 분야를 입력하세요. 최대 10개까지 등록할 수 있습니다. 
      입력 후 "등록" 버튼을 클릭하여 추가하세요.
    </p>
    <div class="space-y-4">
      <div class="flex space-x-2">
        <input
          v-model="newJob"
          type="text"
          placeholder="예: 프론트엔드 개발자, 데이터 분석가"
          class="flex-grow px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-[#006B40]"
          @keyup.enter="addJob"
        />
        <button
          @click="addJob"
          class="px-4 py-2 bg-[#006B40] text-white rounded-md hover:bg-opacity-90 transition"
          :disabled="localData.length >= 10"
        >
          등록
        </button>
      </div>
      <p v-if="errorMessage" class="text-red-500 mt-2">{{ errorMessage }}</p>
      <div class="mt-4">
        <h3 class="text-lg font-semibold mb-2">등록된 희망 직무:</h3>
        <ul class="space-y-2">
          <li v-for="(job, index) in localData" :key="index" class="flex items-center justify-between bg-gray-100 px-3 py-2 rounded-md">
            <span>{{ job }}</span>
            <button
              @click="removeJob(index)"
              class="text-red-500 hover:text-red-700"
            >
              삭제
            </button>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import { ref, watch } from 'vue'

export default {
  props: {
    data: Array
  },
  emits: ['update:data'],
  setup(props, { emit }) {
    const localData = ref(props.data || [])
    const newJob = ref('')
    const errorMessage = ref('')

    const addJob = () => {
      const trimmedJob = newJob.value.trim()
      if (trimmedJob) {
        if (localData.value.length >= 10) {
          errorMessage.value = "키워드가 이미 최대치에 도달했습니다."
        } else if (localData.value.includes(trimmedJob)) {
          errorMessage.value = "이미 등록된 직무입니다."
        } else {
          localData.value.push(trimmedJob)
          newJob.value = ''
          errorMessage.value = ''
          updateData()
        }
      }
    }

    const removeJob = (index) => {
      localData.value.splice(index, 1)
      updateData()
    }

    const updateData = () => {
      emit('update:data', localData.value)
    }

    watch(() => props.data, (newData) => {
      localData.value = newData || []
    })

    return {
      localData,
      newJob,
      addJob,
      removeJob,
      errorMessage
    }
  }
}
</script>

