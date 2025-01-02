<template>
  <div class="min-h-screen bg-[#F8F8F8] flex">
    <!-- Sidebar -->
    <Sidebar
      :sections="resumeSections"
      @toggle-section="toggleSection"
    />

    <!-- Main Content -->
    <div class="flex-1 p-6 pt-16 overflow-y-auto">
      <div class="max-w-4xl mx-auto">
        <h1 class="text-3xl font-bold text-[#006B40] mb-6">Resume Builder</h1>
        <PersonalInfo
          :data="resumeStore.resumeData?.personalInfo"
        />
        <!-- @update:data="updatePersonalInfo" -->

        <ResumeBuilder
          class="section-margin"
          :sections="resumeSections"
          :resumeData="resumeStore.resumeData"
          @update:resumeData="updateResumeData"
        />
        <div class="mt-6 flex justify-end space-x-4">
          <button
            @click="togglePreview"
            class="px-4 py-2 bg-[#8CD196] text-[#006B40] rounded hover:bg-opacity-90 transition"
          >
            {{ isPreviewMode ? 'Edit Resume' : 'Preview Resume' }}
          </button>
          <button
            @click="saveResume"
            class="px-4 py-2 bg-[#006B40] text-white rounded hover:bg-opacity-90 transition"
          >
            Save Resume
          </button>
        </div>
      </div>
    </div>

    <!-- Preview Mode -->
    <PreviewMode
      v-if="isPreviewMode"
      :resumeData="resumeData"
      @close="togglePreview"
    />
  </div>
</template>

<script>
import { ref, reactive, onMounted } from 'vue'
import { useResumeStore } from '@/stores/resume'
import Sidebar from '@/components/Resume/Sidebar.vue'
import ResumeBuilder from '@/components/Resume/ResumeBuilder.vue'
import PreviewMode from '@/components/Resume/PreviewMode.vue'
import PersonalInfo from '@/components/Resume/PersonalInfo.vue'
import axios from 'axios'

export default {
  components: {
    Sidebar,
    ResumeBuilder,
    PreviewMode,
    PersonalInfo
  },
  setup() {
    const resumeStore = useResumeStore()

    onMounted(() => {
      resumeStore.readResume(); // 데이터 가져오기
    })

    const resumeSections = reactive([
      { id: 'desiredJob', name: '희망 직무', isActive: true },
      { id: 'skills', name: '스킬', isActive: true },
      { id: 'educations', name: '학력', isActive: true },
      { id: 'workExperiences', name: '경력', isActive: true },
      { id: 'activities', name: '인턴 및 대외 활동', isActive: false },
      { id: 'trainings', name: '교육 이수', isActive: false },
      { id: 'certifications', name: '자격증', isActive: false },
      { id: 'awards', name: '수상 내역', isActive: false },
      { id: 'portfolios', name: '포트폴리오', isActive: false },
    ])

    const resumeData = reactive({
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

    const isPreviewMode = ref(false)

    const toggleSection = (sectionId) => {
      const section = resumeSections.find(s => s.id === sectionId)
      if (section) {
        section.isActive = !section.isActive
      }
    }



    // const updatePersonalInfo = (newData) => {
    //   resumeData.personalInfo = newData
    //   trackChanges("personalInfo", newData)
    // }

    // const updateSectionData = (sectionId, newData) => {
    //   resumeData[sectionId] = newData;
    //   trackChanges(sectionId, newData);
    // }


    const togglePreview = () => {
      isPreviewMode.value = !isPreviewMode.value
    }

    // resume 저장 
    const modifiedData = ref({})
    const trackChanges = (sectionId, newData) => {
      modifiedData.value[sectionId] = newData
    }

    const updateResumeData = (newData) => {
      // Object.assign(resumeData, newData)
      resumeData[sectionId] = newData;
      trackChanges(sectionId, newData);
    }

    
    const saveResume = async () => {
      try{
        console.log("새 데이터: modifiedData", modifiedData.value)
        console.log("새 데이터: resumeData", resumeData.value)
        const response = await axios.post('http://localhost:8080/api/v1/resume',
          modifiedData.value,
          {
            headers: {
              'Content-Type': 'application/json',
              Authorization: `Bearer ${localStorage.getItem('token')}`,
            },
          }
        )
        console.log("Saved data: ", response.data);
        // console.log('Saving resume:', resumeData)
        // alert('Resume saved successfully!')
        // console.log('Saved data: ', response.data)
         // 변경 데이터 초기화  
        modifiedData.value = {};
      } catch(err){
        console.log('Error saving resume: ', err)
      }
    }



    return {
      resumeStore,
      resumeSections,
      resumeData,
      isPreviewMode,
      toggleSection,
      updateResumeData,
      togglePreview,
      saveResume,
      updateResumeData
      // updatePersonalInfo,
      // updateSectionData
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

