<template>
  <div class="min-h-screen bg-[#F8F8F8] flex">
    <!-- Sidebar -->
    <Sidebar
      :sections="resumeSections"
      @toggle-section="toggleSection"
    />

    <!-- Main Content -->
    <div class="flex-1 p-6 overflow-y-auto">
      <div class="max-w-4xl mx-auto">
        <h1 class="text-3xl font-bold text-[#006B40] mb-6">이력서 수정</h1>
        <PersonalInfo
          :data="resumeData.personalInfo"
          @update:data="updatePersonalInfo"
        />
        <ResumeBuilder
          class="section-margin"
          :sections="resumeSections"
          :resumeData="resumeData"
          @update:resumeData="updateResumeData"
        />
        <div class="mt-6 flex justify-end space-x-4">
          <button
            @click="saveResume"
            class="px-4 py-2 bg-[#006B40] text-white rounded hover:bg-opacity-90 transition"
          >
            저장
          </button>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import { ref, reactive } from 'vue'
import Sidebar from '@/components/Resume/Sidebar.vue'
import ResumeBuilder from '@/components/Resume/ResumeBuilder.vue'
import PersonalInfo from '@/components/Resume/PersonalInfo.vue'

export default {
  components: {
    Sidebar,
    ResumeBuilder,
    PersonalInfo
  },
  setup() {
    const resumeSections = reactive([
      { id: 'desiredJob', name: '희망 직무', isActive: true },
      { id: 'skills', name: '스킬', isActive: true },
      { id: 'academicAbility', name: '학력', isActive: true },
      { id: 'experience', name: '경력', isActive: true },
      { id: 'internships', name: '인턴 및 대외 활동', isActive: false },
      { id: 'training', name: '교육 이수', isActive: false },
      { id: 'certifications', name: '자격증', isActive: false },
      { id: 'awards', name: '수상 내역', isActive: false },
      { id: 'portfolio', name: '포트폴리오', isActive: false },
    ])

    const resumeData = reactive({
      personalInfo: {
        name: '',
        email: '',
        phone: '',
      },
      desiredJob: '',
      skills: [],
      academicAbility: [],
      experience: [],
      internships: [], 
      training: [],
      certifications: [],
      awards: [],
      portfolio: [],
    })

    const toggleSection = (sectionId) => {
      const section = resumeSections.find(s => s.id === sectionId)
      if (section) {
        section.isActive = !section.isActive
      }
    }

    const updateResumeData = (newData) => {
      Object.assign(resumeData, newData)
    }

    const saveResume = () => {
      console.log('Saving resume:', resumeData)
      alert('성공적으로 저장되었습니다! :)')
    }

    const updatePersonalInfo = (newData) => {
      resumeData.personalInfo = newData
    }

    return {
      resumeSections,
      resumeData,
      toggleSection,
      updateResumeData,
      saveResume,
      updatePersonalInfo
    }
  }
}
</script>

<style>
@import 'tailwindcss/base';
@import 'tailwindcss/components';
@import 'tailwindcss/utilities';
.section-margin {
  margin-top: 2rem;
}
</style>

