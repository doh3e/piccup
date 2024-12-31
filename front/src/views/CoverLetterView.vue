<template>
    <div class="min-h-screen bg-gray-50 py-12 px-4 sm:px-6 lg:px-8">
      <div class="max-w-4xl mx-auto">
        <h1 class="text-3xl font-bold text-center text-primary mb-8">자기소개서 작성</h1>
  
        <!-- Resume Carousel or No Resume Message -->
        <div v-if="resumeData.length > 0" class="mb-8">
          <ResumeCarousel :resumes="resumeData" />
        </div>
        <div v-else class="bg-white p-6 rounded-lg shadow-md mb-8 text-center">
          <p class="text-lg mb-4">아직 이력서를 작성하지 않으셨어요! 이력서를 작성하러 가볼까요?</p>
          <router-link 
            to="/resume" 
            class="inline-block bg-primary text-white px-6 py-2 rounded-md hover:bg-opacity-90 transition duration-300"
          >
            이력서 작성하기
          </router-link>
        </div>
  
        <!-- Cover Letter Form -->
        <form @submit.prevent="saveCoverLetter" class="space-y-8">
          <CoverLetterSection 
            v-for="section in coverLetterSections" 
            :key="section.id"
            :title="section.title"
            :content="coverLetterData[section.id]"
            @update:content="updateSection(section.id, $event)"
            @save="saveSection(section.id)"
          />
  
          <div class="flex justify-end">
            <button 
              type="submit" 
              class="bg-primary text-white px-8 py-3 rounded-md hover:bg-opacity-90 transition duration-300"
            >
              전체 저장
            </button>
          </div>
        </form>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import { useRouter } from 'vue-router';
  import ResumeCarousel from '@/components/CoverLetter/ResumeCarousel.vue';
  import CoverLetterSection from '@/components/CoverLetter/CoverLetterSection.vue';
  
  const router = useRouter();
  const resumeData = ref([]);
  const coverLetterData = ref({});
  
  const coverLetterSections = [
    { id: 'motivation', title: '지원동기' },
    { id: 'aspirations', title: '입사후 포부' },
    { id: 'background', title: '성장배경' },
    { id: 'personality', title: '성격 및 장단점' },
    { id: 'crisisManagement', title: '위기극복사례' },
    { id: 'initiative', title: '주도적으로 업무를 수행한 사례' },
    { id: 'additional', title: '기타 하고싶은 말' },
  ];
  
  onMounted(async () => {
    // Check if user is logged in
    const isLoggedIn = checkUserAuthentication();
    if (!isLoggedIn) {
      router.push('/auth');
      return;
    }
  
    // Fetch resume data
    await fetchResumeData();
  
    // Fetch existing cover letter data
    await fetchCoverLetterData();
  });
  
  const checkUserAuthentication = () => {
    // Implement your authentication check logic here
    // For example, check if there's a valid token in localStorage
    const token = localStorage.getItem('authToken');
    return !!token;
  };
  
  const fetchResumeData = async () => {
    try {
      // Implement API call to fetch resume data
      // For now, we'll use mock data
      resumeData.value = [
        { id: 1, title: '소프트웨어 개발자 이력서' },
        { id: 2, title: '프로젝트 매니저 이력서' },
      ];
    } catch (error) {
      console.error('Failed to fetch resume data:', error);
    }
  };
  
  const fetchCoverLetterData = async () => {
    try {
      // Implement API call to fetch existing cover letter data
      // For now, we'll use an empty object
      coverLetterData.value = {};
    } catch (error) {
      console.error('Failed to fetch cover letter data:', error);
    }
  };
  
  const updateSection = (sectionId, content) => {
    coverLetterData.value[sectionId] = content;
  };
  
  const saveSection = async (sectionId) => {
    try {
      // Implement API call to save individual section
      console.log(`Saving section ${sectionId}:`, coverLetterData.value[sectionId]);
      // Show success message to user
    } catch (error) {
      console.error(`Failed to save section ${sectionId}:`, error);
      // Show error message to user
    }
  };
  
  const saveCoverLetter = async () => {
    try {
      // Implement API call to save entire cover letter
      console.log('Saving entire cover letter:', coverLetterData.value);
      // Show success message to user
    } catch (error) {
      console.error('Failed to save cover letter:', error);
      // Show error message to user
    }
  };
  </script>
  
  <style scoped>
  /* Add any additional scoped styles here */
  </style>
  
  