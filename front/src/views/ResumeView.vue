<template>
  <div class="min-h-screen bg-[#F8F8F8]">
    <div class="relative flex">
      <!-- Sidebar -->
      <div class="absolute left-0 w-64">
        <Sidebar
          :sections="resumeSections"
          @toggle-section="toggleSection"
          :saveResume="saveResume"
        />
      </div>

      <!-- Main Content -->
      <div class="flex-1 ml-64 p-6 overflow-y-auto">
        <div class="max-w-4xl mx-auto">
          <h1 class="text-3xl font-bold text-[#006B40] mb-6">이력서 수정</h1>
          <PersonalInfo
            :data="resumeStore.resumeData?.personalInfo"
            @update:data="updatePersonalInfo"
          />

          <ResumeBuilder
            class="section-margin"
            :sections="resumeSections"
            :resumeData="resumeStore.resumeData"
            @update:resumeData="updateSectionData"
          />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { reactive, onMounted } from "vue";
import { useResumeStore } from "@/stores/resume";
import Sidebar from "@/components/Resume/Sidebar.vue";
import ResumeBuilder from "@/components/Resume/ResumeBuilder.vue";
import PersonalInfo from "@/components/Resume/PersonalInfo.vue";

export default {
  components: {
    Sidebar,
    ResumeBuilder,
    PersonalInfo,
  },
  setup() {
    const resumeStore = useResumeStore();

    onMounted(() => {
      resumeStore.readResume(); // 데이터 가져오기
    });

    const resumeSections = reactive([
      { id: "skills", name: "스킬", isActive: true },
      { id: "educations", name: "학력", isActive: true },
      { id: "workExperiences", name: "경력", isActive: true },
      { id: "activities", name: "인턴 및 대외 활동", isActive: true },
      { id: "trainings", name: "교육 이수", isActive: true },
      { id: "certifications", name: "자격증", isActive: true },
      { id: "awards", name: "수상 내역", isActive: true },
      { id: "portfolios", name: "포트폴리오", isActive: true },
    ]);

    const toggleSection = (sectionId) => {
      const section = resumeSections.find((s) => s.id === sectionId);
      if (section) {
        section.isActive = !section.isActive;
      }
    };

    // resume 수정
    const updatePersonalInfo = (newData) => {
      resumeStore.resumeData.personalInfo = newData;
    };
    const updateSectionData = (sectionId, newData) => {
      resumeStore.resumeData[sectionId] = newData;
      console.log("반영시점 resumeStore.resumeData", resumeStore.resumeData);
    };

    // resume 저장
    const saveResume = async () => {
      console.log("저장시점 resumeStore.resumeData", resumeStore.resumeData);
      const success = await resumeStore.saveResume();
      if (success) {
        alert("저장 성공하였습니다.");
      } else {
        alert("저장 실패하였습니다.");
      }
    };

    return {
      resumeStore,
      resumeSections,
      toggleSection,
      updatePersonalInfo,
      updateSectionData,
      saveResume,
    };
  },
};
</script>

<style>
@import "tailwindcss/base";
@import "tailwindcss/components";
@import "tailwindcss/utilities";
.section-margin {
  margin-top: 2rem;
}
</style>
