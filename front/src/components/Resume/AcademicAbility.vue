<template>
  <div class="bg-white p-6 rounded-lg shadow">
    <h2 class="text-2xl font-bold text-[#006B40] mb-6">학력</h2>
    <div
      v-for="(edu, index) in localData"
      :key="index"
      class="mb-8 border-b border-gray-200"
    >
      <div class="grid grid-cols-1 md:grid-cols-2 gap-4 mb-4">
        <!-- School Type and Name -->
        <div class="flex space-x-2">
          <select
            v-model="edu.schoolType"
            class="w-1/3 rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
          >
            <option value="선택안함">선택안함</option>
            <option value="고등학교">고등학교</option>
            <option value="대학(2,3년)">대학(2,3년)</option>
            <option value="대학교(4년)">대학교(4년)</option>
            <option value="대학원">대학원</option>
          </select>
          <div class="relative flex-1">
            <input
              v-model="edu.schoolName"
              type="text"
              class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50 pr-10"
              placeholder="학교명"
            />
            <p v-if="errors.schoolName" class="text-red-500 text-sm mt-1">
              {{ errors.schoolName }}
            </p>
          </div>
        </div>

        <!-- Period and Status -->
        <div class="flex items-center space-x-2">
          <div class="flex flex-col">
            <input
              v-model="edu.startDate"
              type="date"
              class="w-32 rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            />
            <p v-if="errors.startDate" class="text-red-500 text-sm mt-1">
              {{ errors.startDate }}
            </p>
          </div>
          <span>-</span>
          <div class="flex flex-col">
            <input
              v-model="edu.endDate"
              type="date"
              class="w-32 rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            />
            <p v-if="errors.endDate" class="text-red-500 text-sm mt-1">
              {{ errors.endDate }}
            </p>
          </div>
          <select
            v-model="edu.status"
            class="w-32 rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
          >
            <option value="선택안함">선택안함</option>
            <option value="졸업">졸업</option>
            <option value="졸업예정">졸업예정</option>
            <option value="재학 중">재학 중</option>
            <option value="중퇴">중퇴</option>
            <option value="수료">수료</option>
            <option value="휴학">휴학</option>
          </select>
        </div>

        <!-- Major and GPA -->
        <div class="relative">
          <input
            v-model="edu.major"
            type="text"
            class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            placeholder="전공"
          />
        </div>

        <!-- GPA -->
        <div class="flex items-center space-x-2">
          <input
            v-model="edu.gpa"
            type="number"
            step="0.01"
            min="0"
            placeholder="학점"
            class="w-24 rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
          />
          <p v-if="errors.gpa" class="text-red-500 text-sm mt-1">
            {{ errors.gpa }}
          </p>
          <span>/</span>
          <div class="flex flex-col">
            <input
              v-model="edu.gpaScale"
              type="number"
              step="0.01"
              min="0"
              placeholder="만점"
              class="w-24 rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            />
            <p v-if="errors.gpaScale" class="text-red-500 text-sm mt-1">
              {{ errors.gpaScale }}
            </p>
          </div>
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
              isTransfer: false,
              isQe: false,
              qeYear: null,
            },
          ]
    );

    const showDeleteModal = ref(false);
    const errors = ref({
      schoolType: "",
      schoolName: "",
      startDate: "",
      endDate: "",
      status: "",
      gpa: "",
      gpaScale: "",
    });

    // 에러 초기화 함수
    const resetErrors = () => {
      errors.value = {
        schoolType: "",
        schoolName: "",
        startDate: "",
        endDate: "",
        status: "",
        gpa: "",
        gpaScale: "",
      };
    };

    // 학교 유형 및 이름 검사
    watch(
      () => localData.value,
      (newData) => {
        resetErrors();

        newData.forEach((edu) => {
          // 학교 유형 검사
          if (
            ![
              "선택안함",
              "고등학교",
              "대학(2,3년)",
              "대학교(4년)",
              "대학원",
            ].includes(edu.schoolType)
          ) {
            errors.value.schoolType =
              "학교 유형은 선택안함, 고등학교, 대학(2,3년), 대학교(4년), 대학원 중 하나여야 합니다.";
          }

          // 학교 이름 검사
          if (!edu.schoolName.trim()) {
            errors.value.schoolName = "학교 이름은 필수입니다.";
          }
        });
      },
      { deep: true }
    );

    watch(
      () => localData.value.map((edu) => edu.startDate),
      (newStartDates) => {
        newStartDates.forEach((startDate, index) => {
          if (startDate) {
            const date = new Date(startDate);
            const today = new Date();

            if (!isNaN(date.getTime()) && date > today) {
              errors.value.startDate = "입학 날짜는 과거여야 합니다.";
            } else {
              errors.value.startDate = "";
            }
          }
        });
      },
      { deep: true }
    );

    watch(
      () => localData.value.map((edu) => edu.endDate),
      (newEndDates) => {
        newEndDates.forEach((endDate, index) => {
          if (endDate) {
            const date = new Date(endDate);
            const today = new Date();
            const startDate = new Date(localData.value[index].startDate);

            if (!isNaN(date.getTime())) {
              if (date > today) {
                errors.value.endDate = "졸업 날짜는 미래일 수 없습니다.";
              } else if (startDate && date < startDate) {
                errors.value.endDate = "종료일이 시작일보다 빠를 수 없습니다.";
              } else {
                errors.value.endDate = "";
              }
            }
          }
        });
      },
      { deep: true }
    );

    // GPA와 Scale 검사를 위한 개별 watch 함수
    watch(
      () =>
        localData.value.map((edu) => ({ gpa: edu.gpa, scale: edu.gpaScale })),
      (newValues) => {
        newValues.forEach(({ gpa, scale }) => {
          const gpaValue = parseFloat(gpa);
          const scaleValue = parseFloat(scale);

          // GPA 검사
          if (gpa !== "") {
            if (gpaValue < 0) {
              errors.value.gpa = "GPA는 0 이상이어야 합니다.";
            } else if (gpaValue > scaleValue) {
              errors.value.gpa = `학점이 ${scaleValue}보다 클 수 없습니다`;
            } else {
              errors.value.gpa = "";
            }
          }

          // Scale 검사
          if (scale !== "") {
            if (scaleValue <= 0) {
              errors.value.gpaScale = "GPA Scale은 0보다 커야 합니다.";
            } else {
              errors.value.gpaScale = "";
            }
          }
        });
      },
      { deep: true }
    );

    const addEducation = () => {
      localData.value.push({
        schoolType: "선택안함",
        schoolName: "",
        startDate: "",
        endDate: "",
        status: "선택안함",
        major: "",
        gpa: "",
        gpaScale: 4.5,
        isTransfer: false,
        isQe: false,
        qeYear: null,
      });
      updateData();
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
      errors,
      addEducation,
      confirmDelete,
      deleteLastEducation,
    };
  },
};
</script>
