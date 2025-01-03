<template>
    <div class="bg-white p-6 rounded-lg shadow">
      <h2 class="text-2xl font-bold text-[#006B40] mb-6">수상</h2>
      
      <div v-for="(award, index) in localData" :key="index" class="mb-8 pb-6 border-b border-gray-200 relative">
        <!-- Delete button for individual entry -->
        <button 
          @click="removeAward(index)"
          class="absolute top-0 right-0 text-gray-400 hover:text-gray-600"
        >
          <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
            <path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd" />
          </svg>
        </button>
  
        <div class="grid grid-cols-1 md:grid-cols-3 gap-4 mb-4">
          <!-- Award Name -->
          <div class="md:col-span-1">
            <label class="block text-sm font-medium text-gray-700 mb-1">
              수상명 <span class="text-red-500">*</span>
            </label>
            <input
              v-model="award.awardName"
              type="text"
              class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
              required
            />
          </div>
  
          <!-- Issuing Organization -->
          <div class="md:col-span-1">
            <label class="block text-sm font-medium text-gray-700 mb-1">
              수여기관
            </label>
            <input
              v-model="award.awardOrganization"
              type="text"
              class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            />
          </div>
  
          <!-- Award Year -->
          <div class="md:col-span-1">
            <label class="block text-sm font-medium text-gray-700 mb-1">
              수상연도
            </label>
            <input
              v-model="award.awardDate"
              type="text"
              placeholder="YYYY"
              class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            />
          </div>
        </div>
  
        <!-- Description -->
        <div>
          <label class="block text-sm font-medium text-gray-700 mb-1">
            수여내용
          </label>
          <textarea
            v-model="award.description"
            rows="3"
            placeholder="수여 내용 및 결과를 자세히 입력해주세요."
            class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
          ></textarea>
        </div>
      </div>
  
      <!-- Action Buttons -->
      <div class="flex space-x-2">
        <button
          @click="addAward"
          class="px-4 py-2 bg-[#006B40] text-white rounded-md hover:bg-opacity-90 transition flex items-center"
        >
          <span class="mr-1">수상 추가</span>
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
              @click="deleteLastAward"
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
        awardName: '',
        awardOrganization: '',
        awardDate: '',
        description: ''
      }])
  
      const showDeleteModal = ref(false)
  
      const addAward = () => {
        localData.value.push({
          name: '',
          organization: '',
          year: '',
          description: ''
        })
        updateData()
      }
  
      const removeAward = (index) => {
        if (localData.value.length > 1) {
          localData.value.splice(index, 1)
          updateData()
        }
      }
  
      const confirmDelete = () => {
        showDeleteModal.value = true
      }
  
      const deleteLastAward = () => {
        if (localData.value.length > 1) {
          localData.value.pop()
          updateData()
        }
        showDeleteModal.value = false
      }
  
      const updateData = () => {
        emit('update:data', localData.value)
      }
  
      watch(() => props.data, (newData) => {
        if (newData && newData.length > 0) {
          localData.value = newData
        }
      }, { deep: true })
  
      return {
        localData,
        showDeleteModal,
        addAward,
        removeAward,
        confirmDelete,
        deleteLastAward
      }
    }
  }
  </script>
  