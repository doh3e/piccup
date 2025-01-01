<template>
    <div class="bg-white p-6 rounded-lg shadow">
      <h2 class="text-2xl font-bold text-[#006B40] mb-6">인턴·대외활동</h2>
      
      <div v-for="(activity, index) in localData" :key="index" class="mb-8 pb-6 border-b border-gray-200 relative">
        <!-- Delete button for individual entry -->
        <button 
          @click="removeActivity(index)"
          class="absolute top-0 right-0 text-gray-400 hover:text-gray-600"
        >
          <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
            <path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd" />
          </svg>
        </button>
  
        <div class="grid grid-cols-1 md:grid-cols-2 gap-4 mb-4">
          <!-- Activity Type -->
          <div>
            <label class="block text-sm font-medium text-gray-700 mb-1">
              활동구분 <span class="text-red-500">*</span>
            </label>
            <select
              v-model="activity.type"
              class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
              required
            >
              <option value="">선택하기</option>
              <option value="인턴">인턴</option>
              <option value="대외활동">대외활동</option>
              <option value="동아리">동아리</option>
              <option value="봉사활동">봉사활동</option>
              <option value="기타">기타</option>
            </select>
          </div>
  
          <!-- Organization Name -->
          <div>
            <label class="block text-sm font-medium text-gray-700 mb-1">
              회사/기관/단체명 <span class="text-red-500">*</span>
            </label>
            <input
              v-model="activity.organization"
              type="text"
              class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
              required
            />
          </div>
  
          <!-- Period -->
          <div class="flex items-center space-x-2">
            <div class="flex-1">
              <label class="block text-sm font-medium text-gray-700 mb-1">
                시작년월
              </label>
              <input
                v-model="activity.startDate"
                type="text"
                placeholder="YYYY.MM"
                class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
              />
            </div>
            <span class="mt-7">-</span>
            <div class="flex-1">
              <label class="block text-sm font-medium text-gray-700 mb-1">
                종료년월
              </label>
              <input
                v-model="activity.endDate"
                type="text"
                placeholder="YYYY.MM"
                class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
              />
            </div>
          </div>
        </div>
  
        <!-- Description -->
        <div>
          <label class="block text-sm font-medium text-gray-700 mb-1">
            활동내용
          </label>
          <textarea
            v-model="activity.description"
            rows="3"
            placeholder="직무와 관련된 경험에 대해 (상황 - 노력 - 결과)순으로 작성하는것이 좋습니다."
            class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
          ></textarea>
        </div>
      </div>
  
      <!-- Action Buttons -->
      <div class="flex space-x-2">
        <button
          @click="addActivity"
          class="px-4 py-2 bg-[#006B40] text-white rounded-md hover:bg-opacity-90 transition flex items-center"
        >
          <span class="mr-1">인턴·대외활동 추가</span>
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
              @click="deleteLastActivity"
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
        type: '',
        organization: '',
        startDate: '',
        endDate: '',
        description: ''
      }])
  
      const showDeleteModal = ref(false)
  
      const addActivity = () => {
        localData.value.push({
          type: '',
          organization: '',
          startDate: '',
          endDate: '',
          description: ''
        })
        updateData()
      }
  
      const removeActivity = (index) => {
        if (localData.value.length > 1) {
          localData.value.splice(index, 1)
          updateData()
        }
      }
  
      const confirmDelete = () => {
        showDeleteModal.value = true
      }
  
      const deleteLastActivity = () => {
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
        addActivity,
        removeActivity,
        confirmDelete,
        deleteLastActivity
      }
    }
  }
  </script>
  
  