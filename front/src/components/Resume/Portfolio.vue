<template>
    <div class="bg-white p-6 rounded-lg shadow">
      <h2 class="text-2xl font-bold text-[#006B40] mb-6">포트폴리오</h2>
      
      <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
        <!-- URL Add Button -->
        <button 
          @click="openUrlModal"
          class="h-32 border-2 border-dashed border-gray-300 rounded-lg flex flex-col items-center justify-center hover:border-[#006B40] transition-colors"
        >
          <svg xmlns="http://www.w3.org/2000/svg" class="h-8 w-8 text-gray-400" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M13.828 10.172a4 4 0 00-5.656 0l-4 4a4 4 0 105.656 5.656l1.102-1.101m-.758-4.899a4 4 0 005.656 0l4-4a4 4 0 00-5.656-5.656l-1.1 1.1" />
          </svg>
          <span class="mt-2 text-sm text-gray-600">URL 추가</span>
        </button>
  
        <!-- File Add Button -->
        <button 
          @click="openFileModal"
          class="h-32 border-2 border-dashed border-gray-300 rounded-lg flex flex-col items-center justify-center hover:border-[#006B40] transition-colors"
        >
          <svg xmlns="http://www.w3.org/2000/svg" class="h-8 w-8 text-gray-400" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 13h6m-3-3v6m5 5H7a2 2 0 01-2-2V5a2 2 0 012-2h5.586a1 1 0 01.707.293l5.414 5.414a1 1 0 01.293.707V19a2 2 0 01-2 2z" />
          </svg>
          <span class="mt-2 text-sm text-gray-600">파일추가</span>
        </button>
      </div>
  
      <!-- URL List -->
      <div v-if="localData.urls.length > 0" class="mt-6">
        <h3 class="text-lg font-semibold mb-3">등록된 URL</h3>
        <ul class="space-y-2">
          <li v-for="(url, index) in localData.urls" :key="index" class="flex items-center justify-between bg-gray-50 p-3 rounded-md">
            <a :href="url" target="_blank" class="text-[#006B40] hover:underline">{{ url }}</a>
            <button @click="removeUrl(index)" class="text-red-500 hover:text-red-700">
              <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                <path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd" />
              </svg>
            </button>
          </li>
        </ul>
      </div>
  
      <!-- File List -->
      <div v-if="localData.files.length > 0" class="mt-6">
        <h3 class="text-lg font-semibold mb-3">등록된 파일</h3>
        <ul class="space-y-2">
          <li v-for="(file, index) in localData.files" :key="index" class="flex items-center justify-between bg-gray-50 p-3 rounded-md">
            <span>{{ file.name }}</span>
            <button @click="removeFile(index)" class="text-red-500 hover:text-red-700">
              <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                <path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd" />
              </svg>
            </button>
          </li>
        </ul>
      </div>
  
      <!-- URL Modal -->
      <div v-if="showUrlModal" class="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50">
        <div class="bg-white p-6 rounded-lg shadow-lg max-w-md w-full">
          <div class="flex justify-between items-center mb-4">
            <h3 class="text-lg font-bold">포트폴리오 URL 추가</h3>
            <button @click="closeUrlModal" class="text-gray-400 hover:text-gray-600">
              <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" />
              </svg>
            </button>
          </div>
          <input
            v-model="newUrl"
            type="url"
            placeholder="http://"
            class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-[#006B40] mb-4"
          />
          <div class="flex justify-end space-x-2">
            <button
              @click="closeUrlModal"
              class="px-4 py-2 text-gray-600 hover:text-gray-800"
            >
              취소
            </button>
            <button
              @click="addUrl"
              class="px-4 py-2 bg-blue-600 text-white rounded hover:bg-blue-700"
            >
              등록
            </button>
          </div>
        </div>
      </div>
  
      <!-- File Modal -->
      <div v-if="showFileModal" class="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50">
        <div class="bg-white p-6 rounded-lg shadow-lg max-w-md w-full">
          <div class="flex justify-between items-center mb-4">
            <h3 class="text-lg font-bold">포트폴리오 파일 추가</h3>
            <button @click="closeFileModal" class="text-gray-400 hover:text-gray-600">
              <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" />
              </svg>
            </button>
          </div>
          <div 
            class="border-2 border-dashed border-gray-300 rounded-lg p-6 text-center"
            @drop.prevent="handleFileDrop"
            @dragover.prevent
          >
            <input
              ref="fileInput"
              type="file"
              class="hidden"
              @change="handleFileSelect"
            />
            <button
              @click="triggerFileInput"
              class="px-4 py-2 bg-gray-100 text-gray-700 rounded hover:bg-gray-200"
            >
              찾아보기
            </button>
            <p class="mt-2 text-sm text-gray-500">
              개인정보보호를 위해 개인정보가 포함된 파일은 사전동의 없이 삭제될 수 있습니다.
            </p>
          </div>
          <div class="flex justify-end space-x-2 mt-4">
            <button
              @click="closeFileModal"
              class="px-4 py-2 text-gray-600 hover:text-gray-800"
            >
              취소
            </button>
            <button
              @click="addFile"
              class="px-4 py-2 bg-blue-600 text-white rounded hover:bg-blue-700"
              :disabled="!selectedFile"
            >
              등록
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
      data: Object
    },
    emits: ['update:data'],
    setup(props, { emit }) {
      const localData = ref({
        urls: [],
        files: [],
        ...(props.data || {})
      })
  
      const showUrlModal = ref(false)
      const showFileModal = ref(false)
      const newUrl = ref('')
      const fileInput = ref(null)
      const selectedFile = ref(null)
  
      const openUrlModal = () => {
        showUrlModal.value = true
        newUrl.value = ''
      }
  
      const closeUrlModal = () => {
        showUrlModal.value = false
        newUrl.value = ''
      }
  
      const openFileModal = () => {
        showFileModal.value = true
        selectedFile.value = null
      }
  
      const closeFileModal = () => {
        showFileModal.value = false
        selectedFile.value = null
      }
  
      const addUrl = () => {
        if (newUrl.value.trim()) {
          localData.value.urls.push(newUrl.value.trim())
          updateData()
          closeUrlModal()
        }
      }
  
      const removeUrl = (index) => {
        localData.value.urls.splice(index, 1)
        updateData()
      }
  
      const triggerFileInput = () => {
        fileInput.value.click()
      }
  
      const handleFileSelect = (event) => {
        const file = event.target.files[0]
        if (file) {
          selectedFile.value = file
        }
      }
  
      const handleFileDrop = (event) => {
        const file = event.dataTransfer.files[0]
        if (file) {
          selectedFile.value = file
        }
      }
  
      const addFile = () => {
        if (selectedFile.value) {
          localData.value.files.push({
            name: selectedFile.value.name,
            file: selectedFile.value
          })
          updateData()
          closeFileModal()
        }
      }
  
      const removeFile = (index) => {
        localData.value.files.splice(index, 1)
        updateData()
      }
  
      const updateData = () => {
        emit('update:data', localData.value)
      }
  
      watch(() => props.data, (newData) => {
        if (newData) {
          localData.value = {
            urls: [],
            files: [],
            ...newData
          }
        }
      }, { deep: true })
  
      return {
        localData,
        showUrlModal,
        showFileModal,
        newUrl,
        fileInput,
        selectedFile,
        openUrlModal,
        closeUrlModal,
        openFileModal,
        closeFileModal,
        addUrl,
        removeUrl,
        triggerFileInput,
        handleFileSelect,
        handleFileDrop,
        addFile,
        removeFile
      }
    }
  }
  </script>
  