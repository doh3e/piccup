<template>
  <div class="bg-white p-6 rounded-lg shadow">
    <h2 class="text-2xl font-bold text-[#006B40] mb-4">스킬</h2>
    <p class="text-sm text-gray-600 mb-4">
      보유하고 있는 기술 스킬을 입력하세요. 프로그래밍 언어, 프레임워크, 도구
      등을 포함할 수 있습니다. 최대 10개까지 등록할 수 있으며, 입력 후 "등록"
      버튼을 클릭하거나 Enter 키를 눌러 추가하세요.
    </p>
    <div class="space-y-4">
      <div class="flex items-center space-x-2">
        <input
          v-model="newSkill"
          type="text"
          placeholder="예: JavaScript, React, Python"
          class="w-96 px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-[#006B40]"
          @keyup.enter="addSkill"
        />
        <select
          v-model="selectedLevel"
          class="w-40 px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-[#006B40]"
        >
          <option value="미지정">미지정</option>
          <option value="초급">초급</option>
          <option value="중급">중급</option>
          <option value="고급">고급</option>
          <option value="전문가">전문가</option>
          <option value="직접작성">직접작성</option>
        </select>
        <input
          v-if="selectedLevel === '직접작성'"
          v-model="customLevel"
          type="text"
          placeholder="스킬 레벨을 입력하세요"
          class="w-40 px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-[#006B40]"
        />
        <div
          v-else
          class="w-40 px-3 py-2 bg-gray-50 border border-gray-300 rounded-md text-gray-500"
        >
          {{ selectedLevel }}
        </div>
        <button
          @click="addSkill"
          class="px-4 py-2 bg-[#006B40] text-white rounded-md hover:bg-opacity-90 transition"
        >
          등록
        </button>
      </div>
      <p v-if="errorMessage" class="text-red-500 mt-2">{{ errorMessage }}</p>
      <div class="mt-4">
        <h3 class="text-lg font-semibold mb-2">등록된 스킬:</h3>
        <ul class="space-y-2">
          <li
            v-for="(skill, index) in localData"
            :key="index"
            class="flex items-center justify-between bg-gray-100 px-3 py-2 rounded-md"
          >
            <div>
              <span class="font-medium">{{ skill.skillName }}</span>
              <span class="text-gray-600 ml-2">/ {{ skill.skillLevel }}</span>
            </div>
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
import { ref, computed, watch } from "vue";
export default {
  props: {
    data: Array,
  },
  emits: ["update:data"],
  setup(props, { emit }) {
    const localData = ref(props.data || []);
    const newSkill = ref("");
    const selectedLevel = ref("미지정");
    const errorMessage = ref("");
    const errors = ref({
      skillName: "",
      skillLevel: "",
    });
    const customLevel = ref("");

    // 유효성 검사를 위한 computed 속성
    const hasErrors = computed(() => {
      return Object.values(errors.value).some((error) => error !== "");
    });

    // 스킬 레벨 유효성 검사
    watch(
      () => selectedLevel.value,
      (newValue) => {
        const validLevels = [
          "미지정",
          "초급",
          "중급",
          "고급",
          "전문가",
          "직접작성",
        ];
        if (!validLevels.includes(newValue)) {
          errors.value.skillLevel =
            "스킬 레벨은 '미지정', '초급', '중급', '고급', '전문가' 중 하나여야 합니다.";
        } else {
          errors.value.skillLevel = "";
        }
      }
    );

    const addSkill = () => {
      const trimmedSkill = newSkill.value.trim();
      const finalSkillLevel =
        selectedLevel.value === "직접작성"
          ? customLevel.value
          : selectedLevel.value;

      if (!trimmedSkill) {
        errorMessage.value = "스킬 이름은 필수입니다.";
        return;
      }

      if (localData.value.some((skill) => skill.skillName === trimmedSkill)) {
        errorMessage.value = "이미 등록된 스킬입니다.";
        return;
      }

      localData.value.push({
        skillName: trimmedSkill,
        skillLevel: finalSkillLevel,
      });

      newSkill.value = "";
      selectedLevel.value = "미지정";
      customLevel.value = "";
      errorMessage.value = "";
      updateData();
    };

    const removeSkill = (index) => {
      localData.value.splice(index, 1);
      updateData();
    };

    const updateData = () => {
      emit("update:data", localData.value);
    };

    watch(
      () => props.data,
      (newData) => {
        localData.value = newData || [];
      }
    );

    return {
      localData,
      newSkill,
      selectedLevel,
      addSkill,
      removeSkill,
      errorMessage,
      errors,
      hasErrors,
      customLevel,
    };
  },
};
</script>
