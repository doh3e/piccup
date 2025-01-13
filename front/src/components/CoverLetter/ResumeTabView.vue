<template>
  <div class="bg-white p-6 rounded-lg shadow-md">
    <h2 class="text-2xl font-bold text-primary mb-4 text-[#006B40]">내 이력서</h2>
    <div class="grid grid-cols-2 md:grid-cols-4 gap-3 mb-6">
      <button 
        v-for="(component, index) in resumeComponents" 
        :key="index"
        @click="currentIndex = index"
        :class="[
          'px-4 py-2 rounded-md transition duration-300',
          currentIndex === index 
            ? 'bg-[#E6FF94] text-[#006B40] border border-gray-300'
            : 'bg-white text-gray-700 border border-gray-300 hover:bg-gray-50'
        ]"
      >
        {{ component.name }}
      </button>
    </div>
    
    <div class="mt-6">
      <component 
        :is="resumeComponents[currentIndex].component" 
        :data="{}" 
        @update:data="() => {}"
      />
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import PersonalInfo from '@/components/Resume/PersonalInfo.vue'
import Skills from '@/components/Resume/Skills.vue'
import AcademicAbility from '@/components/Resume/AcademicAbility.vue'
import Experience from '@/components/Resume/Experience.vue'
import InternExtraActivities from '@/components/Resume/InternExtraActivities.vue'
import Educations from '@/components/Resume/Educations.vue'
import Certifications from '@/components/Resume/Certifications.vue'
import Portfolio from '@/components/Resume/Portfolio.vue'
import Awards from '@/components/Resume/Awards.vue'

const resumeComponents = [
  { name: '개인 정보', component: PersonalInfo },
  { name: '스킬', component: Skills },
  { name: '학력', component: AcademicAbility },
  { name: '경력', component: Experience },
  { name: '인턴 및 대외활동', component: InternExtraActivities },
  { name: '교육', component: Educations },
  { name: '자격증', component: Certifications },
  { name: '포트폴리오', component: Portfolio },
  { name: '수상 내역', component: Awards },
];

const currentIndex = ref(0);
</script>

<style scoped>
.grid {
  display: grid;
  grid-auto-rows: minmax(40px, auto);
}
</style>