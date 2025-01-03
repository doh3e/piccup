<template>
  <div class="bg-white p-6 rounded-lg shadow">
    <h2 class="text-2xl font-bold text-[#006B40] mb-6">학력</h2>

    <div
      v-for="(edu, index) in localData"
      :key="index"
      class="mb-8 pb-6 border-b border-gray-200"
    >
      <div class="grid grid-cols-1 md:grid-cols-2 gap-4 mb-4">
        <!-- School Type and Name -->
        <div class="flex space-x-2">
          <select
            v-model="edu.schoolType"
            class="w-1/3 rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
          >
            <option value="선택안함">선택안함</option>
            <option value="대학교(4년)">대학교(4년)</option>
            <option value="대학교(2년)">대학교(2년)</option>
            <option value="고등학교">고등학교</option>
          </select>
          <div class="relative flex-1">
            <input
              v-model="edu.schoolName"
              type="text"
              class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50 pr-10"
              placeholder="학교명"
            />
            <button
              class="absolute right-2 top-1/2 transform -translate-y-1/2 text-gray-400"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                class="h-5 w-5"
                viewBox="0 0 20 20"
                fill="currentColor"
              >
                <path
                  fill-rule="evenodd"
                  d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z"
                  clip-rule="evenodd"
                />
              </svg>
            </button>
          </div>
        </div>

        <!-- Period and Status -->
        <div class="flex items-center space-x-2">
          <input
            v-model="edu.startDate"
            type="text"
            placeholder="YYYY.MM"
            class="w-24 rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
          />
          <span>-</span>
          <input
            v-model="edu.endDate"
            type="text"
            placeholder="YYYY.MM"
            class="w-24 rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
          />
          <select
            v-model="edu.status"
            class="w-24 rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
          >
            <option value="졸업">졸업</option>
            <option value="재학중">재학중</option>
            <option value="휴학중">휴학중</option>
            <option value="중퇴">중퇴</option>
          </select>
        </div>

        <!-- Major and GPA -->
        <div class="relative">
          <input
            v-model="edu.major"
            type="text"
            class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50 pr-10"
            placeholder="전공"
          />
          <button
            class="absolute right-2 top-1/2 transform -translate-y-1/2 text-gray-400"
          >
            <svg
              xmlns="http://www.w3.org/2000/svg"
              class="h-5 w-5"
              viewBox="0 0 20 20"
              fill="currentColor"
            >
              <path
                fill-rule="evenodd"
                d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z"
                clip-rule="evenodd"
              />
            </svg>
          </button>
        </div>

        <!-- GPA -->
        <div class="flex items-center space-x-2">
          <input
            v-model="edu.gpa"
            type="text"
            placeholder="학점"
            class="w-20 rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
          />
          <span>/</span>
          <select
            v-model="edu.gpaScale"
            class="w-20 rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
          >
            <option value="4.5">4.5</option>
            <option value="4.3">4.3</option>
            <option value="4.0">4.0</option>
          </select>
        </div>
      </div>
    </div>

    <!-- Action Buttons -->
    <div class="flex space-x-2">
      <button
        @click="addEducation"
        class="px-4 py-2 bg-[#006B40] text-white rounded-md hover:bg-opacity-90 transition flex items-center"
      >
        <span class="mr-1">학력 추가</span>
        <svg
          xmlns="http://www.w3.org/2000/svg"
          class="h-4 w-4"
          viewBox="0 0 20 20"
          fill="currentColor"
        >
          <path
            fill-rule="evenodd"
            d="M10 3a1 1 0 011 1v5h5a1 1 0 110 2h-5v5a1 1 0 11-2 0v-5H4a1 1 0 110-2h5V4a1 1 0 011-1z"
            clip-rule="evenodd"
          />
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
    <div
      v-if="showDeleteModal"
      class="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50"
    >
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
            @click="deleteLastEducation"
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
import { ref, watch } from "vue";

export default {
  props: {
    data: Array,
  },
  emits: ["update:data"],
  setup(props, { emit }) {
    const localData = ref(
      props.data && props.data.length > 0
        ? props.data
        : [
            {
              schoolType: "선택안함",
              schoolName: "",
              startDate: "",
              endDate: "",
              status: "선택안함",
              major: "",
              gpa: "",
              gpaScale: 4.5,
            },
          ]
    );

    const showDeleteModal = ref(false);

    const addEducation = () => {
      localData.value.push({
        schoolType: "대학교(4년)",
        schoolName: "",
        startDate: "",
        endDate: "",
        status: "졸업",
        major: "",
        gpa: "",
        gpaScale: 4.5,
      });
      updateData();
    };

    const addSameSchool = () => {
      if (localData.value.length > 0) {
        const lastSchool = localData.value[localData.value.length - 1];
        localData.value.push({
          ...lastSchool,
          major: "",
          gpa: "",
          gpaScale:4.5,
        });
        updateData();
      }
    };

    const confirmDelete = () => {
      showDeleteModal.value = true;
    };

    const deleteLastEducation = () => {
      if (localData.value.length > 1) {
        localData.value.pop();
        updateData();
      }
      showDeleteModal.value = false;
    };

    const updateData = () => {
      emit("update:data", localData.value);
    };

    watch(
      () => props.data,
      (newData) => {
        if (newData && newData.length > 0) {
          localData.value = newData;
        }
      },
      { deep: true }
    );

    return {
      localData,
      showDeleteModal,
      addEducation,
      addSameSchool,
      confirmDelete,
      deleteLastEducation,
    };
  },
};
</script>
