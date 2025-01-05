<template>
  <div class="container mx-auto px-4 sm:px-6 lg:px-8">
    <div
      class="max-w-4xl mx-auto bg-white shadow-md rounded-lg p-8 relative"
      @click="openModal"
    >
      <!-- Overlay to block interactions -->
      <div
        class="absolute inset-0 bg-transparent cursor-pointer"
        style="pointer-events: auto"
      ></div>

      <!-- Header -->
      <header class="text-center mb-8">
        <h1 class="text-4xl font-bold text-[#006B40]">이력서</h1>
        <p class="text-gray-600">작성된 이력서를 확인하세요</p>
      </header>

      <!-- Personal Information -->
      <div class="mb-12">
        <h2 class="text-2xl font-bold text-[#006B40] mb-4">인적사항</h2>
        <PersonalInfo :data="resumeData.personalInfo" />
      </div>

      <!-- Resume Sections -->
      <div v-for="section in resumeSections" :key="section.id" class="mb-12">
        <h3 class="text-xl font-bold text-[#006B40] mb-4">
          {{ section.name }}
        </h3>
        <component
          :is="getSectionComponent(section.id)"
          :data="resumeData[section.id]"
        />
      </div>
    </div>

    <!-- Modal -->
    <div
      v-if="isModalOpen"
      class="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 z-50"
    >
      <div class="bg-white rounded-lg shadow-lg p-6 w-full max-w-md">
        <p class="text-lg font-semibold text-gray-800 mb-4">
          이력서 수정을 하시겠습니까?
        </p>
        <div class="flex justify-end space-x-4">
          <button
            @click="goToResumeEdit"
            class="px-4 py-2 bg-green-600 text-white rounded hover:bg-green-700"
          >
            이력서 수정
          </button>
          <button
            @click="closeModal"
            class="px-4 py-2 bg-gray-300 text-gray-800 rounded hover:bg-gray-400"
          >
            취소
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { computed } from "vue";
import { useResumeStore } from "@/stores/resume";

// 컴포넌트 import
import PersonalInfo from "@/components/Resume/PersonalInfo.vue";
import Skills from "@/components/Resume/Skills.vue";
import AcademicAbility from "@/components/Resume/AcademicAbility.vue";
import Experience from "@/components/Resume/Experience.vue";
import InternExtraActivities from "@/components/Resume/InternExtraActivities.vue";
import Educations from "@/components/Resume/Educations.vue";
import Certifications from "@/components/Resume/Certifications.vue";
import Portfolio from "@/components/Resume/Portfolio.vue";
import Awards from "@/components/Resume/Awards.vue";

// Vuex Store에서 데이터 가져오기
const resumeStore = useResumeStore();
const resumeData = computed(() => resumeStore.resumeData);

// 각 섹션 정의
const resumeSections = [
  { id: "skills", name: "스킬" },
  { id: "educations", name: "학력" },
  { id: "workExperiences", name: "경력" },
  { id: "activities", name: "인턴 및 대외 활동" },
  { id: "trainings", name: "교육 이수" },
  { id: "certifications", name: "자격증" },
  { id: "awards", name: "수상 내역" },
  { id: "portfolios", name: "포트폴리오" },
];

// 섹션 ID에 따라 적절한 컴포넌트를 반환
const getSectionComponent = (sectionId) => {
  const components = {
    skills: Skills,
    educations: AcademicAbility,
    workExperiences: Experience,
    activities: InternExtraActivities,
    trainings: Educations,
    certifications: Certifications,
    awards: Awards,
    portfolios: Portfolio,
  };
  return components[sectionId];
};

// 모달 상태 관리
const isModalOpen = ref(false);
const router = useRouter();

// 모달 열기
const openModal = () => {
  isModalOpen.value = true;
};

// 모달 닫기
const closeModal = () => {
  isModalOpen.value = false;
};

// 이력서 수정 페이지로 이동
const goToResumeEdit = () => {
  closeModal();
  router.push("/resume");
};
</script>

<style scoped>
.container {
  max-width: 800px;
}

header h1 {
  margin-bottom: 0.5rem;
}

header p {
  color: #4a5568; /* Tailwind gray-600 */
}

h2,
h3 {
  border-bottom: 2px solid #006b40;
  padding-bottom: 0.5rem;
}

/* 추가 스타일 */
.relative {
  position: relative;
}

.absolute {
  position: absolute;
}

.inset-0 {
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
}

/* 모달 스타일 */
.fixed {
  position: fixed;
}

.z-50 {
  z-index: 50;
}

.bg-opacity-50 {
  background-color: rgba(0, 0, 0, 0.5);
}
</style>
