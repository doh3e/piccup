<template>
  <div class="bg-white p-6 rounded-lg shadow">
    <h2 class="text-2xl font-bold text-[#006B40] mb-6">경력</h2>
    
    <div v-for="(exp, index) in localData" :key="index" class="mb-8 pb-6 border-b border-gray-200">
      <div class="grid grid-cols-1 md:grid-cols-2 gap-4 mb-4">
        <!-- Company and Department -->
        <div class="relative">
          <label class="block text-sm font-medium text-gray-700 mb-1">
            회사명 <span class="text-red-500">*</span>
          </label>
          <input
            v-model="exp.companyName"
            type="text"
            class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            required
          />
        </div>
        <div class="relative">
          <label class="block text-sm font-medium text-gray-700 mb-1">
            부서명
          </label>
          <input
            v-model="exp.department"
            type="text"
            class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
          />
        </div>

        <!-- Period -->
        <div class="flex items-center space-x-2">
          <div class="flex-1">
            <label class="block text-sm font-medium text-gray-700 mb-1">
              입사년월 <span class="text-red-500">*</span>
            </label>
            <input
              v-model="exp.startDate"
              type="text"
              placeholder="YYYY.MM"
              class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
              required
            />
          </div>
          <span class="mt-6">-</span>
          <div class="flex-1">
            <label class="block text-sm font-medium text-gray-700 mb-1">
              퇴사년월 <span class="text-red-500">*</span>
            </label>
            <input
              v-model="exp.endDate"
              type="text"
              placeholder="YYYY.MM"
              class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
              required
            />
          </div>
          <div class="mt-6">
            <input
              type="checkbox"
              :id="`currentJob-${index}`"
              v-model="exp.isCurrent"
              class="rounded border-gray-300 text-[#006B40] focus:ring-[#8CD196]"
            />
            <label :for="`currentJob-${index}`" class="ml-2 text-sm text-gray-700">재직중</label>
          </div>
        </div>

        <!-- Position and Salary -->
        <div class="flex space-x-2">
          <div class="flex-1">
            <label class="block text-sm font-medium text-gray-700 mb-1">
              직급/직책
            </label>
            <select
              v-model="exp.position"
              class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            >
              <option value="">선택하기</option>
              <option value="사원">사원</option>
              <option value="대리">대리</option>
              <option value="과장">과장</option>
              <option value="차장">차장</option>
              <option value="부장">부장</option>
            </select>
          </div>
          <div class="flex-1">
            <label class="block text-sm font-medium text-gray-700 mb-1">
              연봉
            </label>
            <input
              v-model="exp.salary"
              type="text"
              placeholder="만원"
              class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            />
          </div>
        </div>
      </div>

      <!-- Job Description -->
      <div class="mb-4">
        <label class="block text-sm font-medium text-gray-700 mb-1">
          담당업무
        </label>
        <textarea
          v-model="exp.description"
          rows="4"
          placeholder="담당하신 업무와 성과에 대해 간단명료하게 작성해주세요."
          class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
        ></textarea>
      </div>

      <!-- Tags -->
      <div class="flex flex-wrap gap-2 mb-4">
        <div
          v-for="tag in exp.tags"
          :key="tag"
          class="flex items-center bg-gray-100 px-3 py-1 rounded-full"
        >
          <span class="text-sm text-gray-700">{{ tag }}</span>
          <button
            @click="removeTag(index, tag)"
            class="ml-2 text-gray-500 hover:text-gray-700"
          >
            ×
          </button>
        </div>
        <button
          @click="addTag(index)"
          class="text-[#006B40] hover:text-[#8CD196] text-sm"
        >
          + 태그 추가
        </button>
      </div>

      <!-- Document Upload -->
      <div class="bg-gray-50 p-4 rounded-md">
        <div class="flex items-center justify-between">
          <span class="text-sm text-gray-700">경력기술서</span>
          <button
            @click="uploadDocument(index)"
            class="text-[#006B40] hover:text-[#8CD196] text-sm"
          >
            첨부하기
          </button>
        </div>
      </div>
    </div>

    <!-- Action Buttons -->
    <div class="flex space-x-2">
      <button
        @click="addExperience"
        class="px-4 py-2 bg-[#006B40] text-white rounded-md hover:bg-opacity-90 transition flex items-center"
      >
        <span class="mr-1">추가</span>
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
            @click="deleteLastExperience"
            class="px-4 py-2 bg-red-500 text-white rounded hover:bg-red-600 transition"
          >
            삭제
          </button>
        </div>
      </div>
    </div>

    <!-- Tag Input Modal -->
    <div v-if="showTagModal" class="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50">
      <div class="bg-white p-6 rounded-lg shadow-lg max-w-sm w-full">
        <h3 class="text-lg font-bold mb-4">태그 추가</h3>
        <input
          v-model="newTag"
          type="text"
          placeholder="태그를 입력하세요"
          class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50 mb-4"
          @keyup.enter="confirmAddTag"
        />
        <div class="flex justify-end space-x-4">
          <button
            @click="showTagModal = false"
            class="px-4 py-2 bg-gray-200 text-gray-800 rounded hover:bg-gray-300 transition"
          >
            취소
          </button>
          <button
            @click="confirmAddTag"
            class="px-4 py-2 bg-[#006B40] text-white rounded hover:bg-opacity-90 transition"
          >
            추가
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
      companyName: '',
      department: '',
      startDate: '',
      endDate: '',
      isCurrent: false,
      position: '',
      salary: '',
      description: '',
      tags: [],
      documents: []
    }])

    const showDeleteModal = ref(false)
    const showTagModal = ref(false)
    const newTag = ref('')
    const currentTagIndex = ref(0)

    const addExperience = () => {
      localData.value.push({
        companyName: '',
        department: '',
        startDate: '',
        endDate: '',
        isCurrent: false,
        position: '',
        salary: '',
        description: '',
        tags: [],
        documents: []
      })
      updateData()
    }

    const confirmDelete = () => {
      showDeleteModal.value = true
    }

    const deleteLastExperience = () => {
      if (localData.value.length > 1) {
        localData.value.pop()
        updateData()
      }
      showDeleteModal.value = false
    }

    const addTag = (index) => {
      currentTagIndex.value = index
      showTagModal.value = true
      newTag.value = ''
    }

    const confirmAddTag = () => {
      if (newTag.value.trim()) {
        if (!localData.value[currentTagIndex.value].tags) {
          localData.value[currentTagIndex.value].tags = []
        }
        localData.value[currentTagIndex.value].tags.push(newTag.value.trim())
        updateData()
      }
      showTagModal.value = false
      newTag.value = ''
    }

    const removeTag = (expIndex, tag) => {
      const tagIndex = localData.value[expIndex].tags.indexOf(tag)
      if (tagIndex > -1) {
        localData.value[expIndex].tags.splice(tagIndex, 1)
        updateData()
      }
    }

    const uploadDocument = (index) => {
      // Implement document upload functionality
      console.log('Upload document for experience:', index)
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
      showTagModal,
      newTag,
      addExperience,
      confirmDelete,
      deleteLastExperience,
      addTag,
      confirmAddTag,
      removeTag,
      uploadDocument
    }
  }
}
</script>

