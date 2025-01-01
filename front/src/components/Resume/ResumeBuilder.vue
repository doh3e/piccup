<template>
  <div class="space-y-8">
    <!-- Render active sections -->
    <template v-for="section in sections" :key="section.id">
      <component
        v-if="section.isActive"
        :is="getSectionComponent(section.id)"
        :data="resumeData[section.id]"
        @update:data="(newData) => updateSectionData(section.id, newData)"
      />
    </template>
  </div>
</template>

<script>
import { computed } from 'vue'
import PersonalInfo from '@/components/Resume/PersonalInfo.vue'
import DesiredJob from '@/components/Resume/DesiredJob.vue'
import Skills from '@/components/Resume/Skills.vue'
import AcademicAbility from '@/components/Resume/AcademicAbility.vue'
import Experience from '@/components/Resume/Experience.vue'
import InternExtraActivities from '@/components/Resume/InternExtraActivities.vue'
import Educations from '@/components/Resume/Educations.vue'
import Certifications from '@/components/Resume/Certifications.vue'
import Portfolio from '@/components/Resume/Portfolio.vue'
import Awards from '@/components/Resume/Awards.vue'

export default {
  name: 'ResumeBuilder',
  components: {
    PersonalInfo,
    DesiredJob,
    Skills,
    AcademicAbility,
    Experience,
    InternExtraActivities,
    Educations,
    Certifications,
    Portfolio,
    Awards,
  },
  props: {
    sections: {
      type: Array,
      required: true
    },
    resumeData: {
      type: Object,
      required: true
    }
  },
  emits: ['update:resumeData'],
  setup(props, { emit }) {
    const getSectionComponent = (sectionId) => {
      const componentMap = {
        personalInfo: 'PersonalInfo',
        desiredJob: 'DesiredJob',
        skills: 'Skills',
        academicAbility: 'AcademicAbility',
        experience: 'Experience',
        internships: 'InternExtraActivities',
        training: 'Educations',
        certifications: 'Certifications',
        portfolio: 'Portfolio',
        awards: 'Awards',
      }
      return componentMap[sectionId]
    }

    const updateSectionData = (sectionId, newData) => {
      emit('update:resumeData', {
        ...props.resumeData,
        [sectionId]: newData
      })
    }

    return {
      getSectionComponent,
      updateSectionData
    }
  }
}
</script>
