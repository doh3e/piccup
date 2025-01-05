<template>
  <div class="bg-white p-6 rounded-lg shadow">
    <h2 class="text-2xl font-bold text-[#006B40] mb-6">경력</h2>
    <div
      v-for="(exp, index) in localData"
      :key="index"
      class="mb-8 pb-6 border-b border-gray-200"
    >
      <div class="grid grid-cols-1 md:grid-cols-2 gap-4 mb-4">
        <!-- Company and Department -->
        <div class="relative">
          <label class="block text-sm font-medium text-gray-700 mb-1">
            회사명 <span class="text-red-500">*</span>
          </label>
          <input
            v-model="exp.company"
            type="text"
            class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            required
            @blur="validateField(index, 'company')"
          />
          <p v-if="errors[index]?.company" class="text-red-500 text-sm mt-1">
            {{ errors[index].company }}
          </p>
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
              type="date"
              class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
              required
            />
            <p
              v-if="errors[index]?.startDate"
              class="text-red-500 text-sm mt-1"
            >
              {{ errors[index].startDate }}
            </p>
          </div>
          <span class="mt-6">-</span>
          <div class="flex-1">
            <label class="block text-sm font-medium text-gray-700 mb-1">
              퇴사년월
            </label>
            <input
              v-model="exp.endDate"
              type="date"
              class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
              :required="!exp.isCurrent"
            />
            <p v-if="errors[index]?.endDate" class="text-red-500 text-sm mt-1">
              {{ errors[index].endDate }}
            </p>
          </div>
          <div class="mt-6">
            <input
              type="checkbox"
              :id="`currentJob-${index}`"
              v-model="exp.isCurrent"
              class="rounded border-gray-300 text-[#006B40] focus:ring-[#8CD196]"
            />
            <label
              :for="`currentJob-${index}`"
              class="ml-2 text-sm text-gray-700"
              >재직중</label
            >
          </div>
        </div>

        <!-- Position and Salary -->
        <div class="flex space-x-2">
          <div class="flex-1">
            <label class="block text-sm font-medium text-gray-700 mb-1">
              직급/직책
            </label>
            <input
              v-model="exp.position"
              type="text"
              class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            />
          </div>
          <div class="flex-1">
            <label class="block text-sm font-medium text-gray-700 mb-1">
              연봉
            </label>
            <div class="flex items-center">
              <input
                v-model.number="exp.salary"
                type="number"
                min="0"
                placeholder="만원"
                class="w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
                @blur="validateField(index, 'salary')"
              />
              <span class="ml-2 whitespace-nowrap">만원</span>
            </div>
            <p v-if="errors[index]?.salary" class="text-red-500 text-sm mt-1">
              {{ errors[index].salary }}
            </p>
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
    </div>

    <!-- Action Buttons -->
    <div class="flex space-x-2">
      <button
        @click="addExperience"
        class="px-4 py-2 bg-[#006B40] text-white rounded-md hover:bg-opacity-90 transition flex items-center"
      >
        <span class="mr-1">경력 추가</span>
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
            @click="deleteLastExperience"
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
              company: "",
              department: "",
              startDate: "",
              endDate: "",
              position: "",
              salary: "",
              isCurrent: false,
              description: "",
            },
          ]
    );
    const showDeleteModal = ref(false);
    const errors = ref({});

    const resetErrors = (index) => {
      errors.value[index] = {
        company: "",
        salary: "",
        startDate: "",
        endDate: "",
      };
    };

    const validateField = (index, field) => {
      resetErrors(index);
      const exp = localData.value[index];

      if (field === "company" && (!exp.company || exp.company.trim() === "")) {
        errors.value[index].company = "기관 이름은 필수입니다. (Not Blank)";
      }

      if (
        field === "salary" &&
        exp.salary !== "" &&
        (exp.salary < 0 || isNaN(exp.salary))
      ) {
        errors.value[index].salary = "연봉은 0 이상이어야 합니다.";
      }

      if (field === "startDate" && exp.startDate) {
        const startDate = new Date(exp.startDate);
        const today = new Date();
        if (startDate > today) {
          errors.value[index].startDate = "입사일은 오늘 이후일 수 없습니다.";
        }
      }

      if (field === "endDate" && exp.endDate) {
        const startDate = new Date(exp.startDate);
        const endDate = new Date(exp.endDate);
        if (endDate < startDate) {
          errors.value[index].endDate = "퇴사일은 입사일 이전일 수 없습니다.";
        }
      }
    };

    const validateData = () => {
      let isValid = true;
      localData.value.forEach((exp, index) => {
        validateField(index, "company");
        validateField(index, "salary");
        validateField(index, "startDate");
        validateField(index, "endDate");
        if (
          errors.value[index].company ||
          errors.value[index].salary ||
          errors.value[index].startDate ||
          errors.value[index].endDate
        ) {
          isValid = false;
        }
      });

      if (!isValid) {
        const errorMessages = Object.values(errors.value)
          .flatMap(Object.values)
          .filter((msg) => msg !== "");
        alert(errorMessages.join("\n"));
      }

      return isValid;
    };

    const addExperience = () => {
      if (validateData()) {
        const newIndex = localData.value.length;
        resetErrors(newIndex);
        localData.value.push({
          company: "",
          department: "",
          startDate: "",
          endDate: "",
          isCurrent: false,
          position: "",
          salary: "",
          description: "",
        });
        updateData();
      }
    };

    const confirmDelete = () => {
      showDeleteModal.value = true;
    };

    const deleteLastExperience = () => {
      if (localData.value.length > 1) {
        localData.value.pop();
        updateData();
      }
      showDeleteModal.value = false;
    };

    const updateData = () => {
      if (validateData()) {
        emit("update:data", localData.value);
      }
    };

    watch(
      () => localData.value.map((exp) => exp.startDate),
      (newStartDates) => {
        newStartDates.forEach((startDate, index) => {
          if (startDate) {
            const date = new Date(startDate);
            const today = new Date();

            if (!isNaN(date.getTime())) {
              if (date > today) {
                errors.value[index].startDate = "입사일은 미래일 수 없습니다.";
              } else {
                errors.value[index].startDate = "";
              }
            }
          }
        });
      },
      { deep: true }
    );

    watch(
      () => localData.value.map((exp) => exp.endDate),
      (newEndDates) => {
        newEndDates.forEach((endDate, index) => {
          if (endDate) {
            const date = new Date(endDate);
            const today = new Date();
            const startDate = new Date(localData.value[index].startDate);

            if (!isNaN(date.getTime())) {
              if (date > today) {
                errors.value[index].endDate = "퇴사일은 미래일 수 없습니다.";
              } else if (startDate && date < startDate) {
                errors.value[index].endDate =
                  "퇴사일이 입사일보다 빠를 수 없습니다.";
              } else {
                errors.value[index].endDate = "";
              }
            }
          }
        });
      },
      { deep: true }
    );

    return {
      localData,
      showDeleteModal,
      errors,
      addExperience,
      confirmDelete,
      deleteLastExperience,
      validateField,
    };
  },
};
</script>
