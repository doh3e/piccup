<template>
  <div class="bg-white p-6 rounded-lg shadow">
    <div class="flex justify-between items-center mb-6">
      <h2 class="text-2xl font-bold text-[#006B40]">자격증</h2>
    </div>
    
    <div v-for="(qualification, index) in localData" :key="index" class="mb-8 pb-6 border-b border-gray-200 relative">
      <!-- Delete button for individual entry -->
      <button 
        @click="removeQualification(index)"
        class="absolute top-0 right-0 text-gray-400 hover:text-gray-600"
      >
        <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
          <path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd" />
        </svg>
      </button>

      <div class="grid grid-cols-1 md:grid-cols-3 gap-4">
        <!-- Qualification Name -->
        <div class="md:col-span-1">
          <label class="block text-sm font-medium text-gray-700 mb-1">
            자격증 명 <span class="text-red-500">*</span>
          </label>
          <div class="relative">
            <input
              v-model="qualification.certName"
              type="text"
              class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50 pr-10"
              required
              @blur="validateField(index, 'certName')"
            />
            <button class="absolute right-2 top-1/2 transform -translate-y-1/2 text-gray-400">
              <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                <path fill-rule="evenodd" d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z" clip-rule="evenodd" />
              </svg>
            </button>
          </div>
          <p v-if="errors[index]?.certName" class="text-red-500 text-sm mt-1">
            {{ errors[index].certName }}
          </p>
        </div>

        <!-- Issuing Organization -->
        <div class="md:col-span-1">
          <label class="block text-sm font-medium text-gray-700 mb-1">
            발행처
          </label>
          <input
            v-model="qualification.publisher"
            type="text"
            class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
          />
        </div>

        <!-- Acquisition Date -->
        <div class="md:col-span-1">
          <label class="block text-sm font-medium text-gray-700 mb-1">
            취득월
          </label>
          <input
            v-model="qualification.obtainedDate"
            type="date"
            class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            @blur="validateField(index, 'obtainedDate')"
          />
          <p v-if="errors[index]?.obtainedDate" class="text-red-500 text-sm mt-1">
            {{ errors[index].obtainedDate }}
          </p>
        </div>
      </div>
    </div>

    <!-- Action Buttons -->
    <div class="flex space-x-2">
      <button
        @click="addQualification"
        class="px-4 py-2 bg-[#006B40] text-white rounded-md hover:bg-opacity-90 transition flex items-center"
      >
        <span class="mr-1">자격증 추가</span>
        <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4" viewBox="0 0 20 20" fill="currentColor">
          <path fill-rule="evenodd" d="M10 3a1 1 0 011 1v5h5a1 1 0 110 2h-5v5a1 1 0 11-2 0v-5H4a1 1 0 110-2h5V4a1 1 0 011-1z" clip-rule="evenodd" />
        </svg>
      </button>
      <button
        v-if="localData.length > 1"
        @click="confirmDelete"
        class="px-4 py-2 bg-red-500 text-white rounded-md hover:bg-opacity-90 transition"
      >
        삭제
      </button>
    </div>

    <!-- Delete Confirmation Modal -->
    <div v-if="showDeleteModal" class="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50">
      <div class="bg-white p-6 rounded-lg shadow-lg max-w-sm w-full">
        <h3 class="text-lg font-bold mb-4">삭제 확인</h3>
        <p class="mb-6">정말로 삭제하시겠습니까?</p>
        <div class="flex justify-end space-x-4">
          <button
            @click="showDeleteModal = false"
            class="px-4 py-2 bg-gray-200 text-gray-800 rounded hover:bg-gray-300 transition"
          >
            취소
          </button>
          <button
            @click="deleteLastQualification"
            class="px-4 py-2 bg-red-500 text-white rounded hover:bg-red-600 transition"
          >
            삭제
          </button>
        </div>
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
    const localData = ref(props.data && props.data.length > 0 ? props.data : [{
      certName: '',
      publisher: '',
      obtainedDate: '',
      certCode: '',
    }])

    const showDeleteModal = ref(false)
    const errors = ref({})

    const resetErrors = (index) => {
      if (!errors.value[index]) {
        errors.value[index] = {}
      }
      errors.value[index].certName = ''
      errors.value[index].obtainedDate = ''
    }

    const validateField = (index, field) => {
      resetErrors(index)
      const qualification = localData.value[index]

      if (field === 'certName' && (!qualification.certName || qualification.certName.trim() === '')) {
        errors.value[index].certName = '자격증 명은 필수입니다. (Not Blank)'
      }

      if (field === 'obtainedDate' && qualification.obtainedDate) {
        const obtainedDate = new Date(qualification.obtainedDate)
        const today = new Date()
        if (obtainedDate > today) {
          errors.value[index].obtainedDate = '취득 날짜는 미래일 수 없습니다.'
        }
      }
    }

    const validateData = () => {
      let isValid = true
      localData.value.forEach((qualification, index) => {
        validateField(index, 'certName')
        validateField(index, 'obtainedDate')
        if (errors.value[index]?.certName || errors.value[index]?.obtainedDate) {
          isValid = false
        }
      })

      if (!isValid) {
        const errorMessages = Object.values(errors.value)
          .flatMap(Object.values)
          .filter(msg => msg !== '')
        alert(errorMessages.join('\n'))
      }

      return isValid
    }

    const addQualification = () => {
      if (validateData()) {
        localData.value.push({
          certName: '',
          publisher: '',
          obtainedDate: '',
          certCode: '',
        })
        updateData()
      }
    }

    const removeQualification = (index) => {
      if (localData.value.length > 1) {
        localData.value.splice(index, 1)
        updateData()
      }
    }

    const confirmDelete = () => {
      showDeleteModal.value = true
    }

    const deleteLastQualification = () => {
      if (localData.value.length > 1) {
        localData.value.pop()
        updateData()
      }
      showDeleteModal.value = false
    }

    const updateData = () => {
      if (validateData()) {
        emit('update:data', localData.value)
      }
    }

    watch(() => props.data, (newData) => {
      if (newData && newData.length > 0) {
        localData.value = newData
      }
    }, { deep: true })

    watch(() => localData.value, () => {
      validateData()
    }, { deep: true })

    return {
      localData,
      showDeleteModal,
      errors,
      addQualification,
      removeQualification,
      confirmDelete,
      deleteLastQualification,
      validateField
    }
  }
}
</script>
