<template>
  <div class="bg-white p-6 rounded-lg shadow">
    <h2 class="text-2xl font-bold text-[#006B40] mb-4">스킬</h2>
    <p class="text-sm text-gray-600 mb-4">
      보유하고 있는 기술 스킬을 입력하세요. 프로그래밍 언어, 프레임워크, 도구 등을 포함할 수 있습니다.
      최대 10개까지 등록할 수 있으며, 입력 후 "등록" 버튼을 클릭하거나 Enter 키를 눌러 추가하세요.
    </p>
    <div class="space-y-4">
      <div class="flex space-x-2">
        <input
          v-model="newSkill"
          type="text"
          placeholder="예: JavaScript, React, Python"
          class="flex-grow px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-[#006B40]"
          @keyup.enter="addSkill"
        />
        <button
          @click="addSkill"
          class="px-4 py-2 bg-[#006B40] text-white rounded-md hover:bg-opacity-90 transition"
          :disabled="localData.length >= 10"
        >
          등록
        </button>
      </div>
      <p v-if="errorMessage" class="text-red-500 mt-2">{{ errorMessage }}</p>
      <div class="mt-4">
        <h3 class="text-lg font-semibold mb-2">등록된 스킬:</h3>
        <ul class="space-y-2">
          <li v-for="(skill, index) in localData" :key="index" class="flex items-center justify-between bg-gray-100 px-3 py-2 rounded-md">
            <span>{{ skill.skillName }} / {{ skill.skillLevel }}</span>
            <button
              @click="removeSkill(index)"
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
    const newSkill = ref('')
    const errorMessage = ref('')

    const addSkill = () => {
      const trimmedSkill = newSkill.value.trim()
      if (trimmedSkill) {
        if (localData.value.length >= 10) {
          errorMessage.value = "스킬이 이미 최대치에 도달했습니다."
        } else if (localData.value.includes(trimmedSkill)) {
          errorMessage.value = "이미 등록된 스킬입니다."
        } else {

          localData.value.push({skillName: trimmedSkill, skillLevel:'미지정'})
          newSkill.value = ''
          errorMessage.value = ''
          updateData()
        }
      }
    }

    const removeSkill = (index) => {
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
      newSkill,
      addSkill,
      removeSkill,
      errorMessage
    }
  }
}
</script>

