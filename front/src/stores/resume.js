import { ref, computed, TrackOpTypes } from 'vue'
import { defineStore } from 'pinia'
import { apiAuth, api } from '@/api'

export const useResumeStore = defineStore('resume', () => {
  // 이력서 데이터
  const personalFile = ref(null)

  const resumeData = ref({
    resumeId: null,
    userId: null,
    updatedAt: '',

    personalInfo: {
      infoId: null,
      resumeId: null,
      username: '',
      birthDate: '',
      gender: '미지정',
      email: '',
      homePhone: '',
      mobilePhone: '',
      address: '',
      addressDetail: '',
      postalCode : null,
      profileImgPath : '',
      profileImgName : '',
      degree : '미지정',
      hobby : '', 
      specialty : '',
    },
    preference: {
      preId: null,
      resumeId: null,
      disLevel: "해당없음",
      military: "해당없음",
      isVeteran: false,
      isProtected: false,
      isDisabled: false,
      isAgree: false,
    },
    activities: [],
    awards: [],
    certifications: [],
    educations: [],
    languages: [],
    overseas: [],
    papers: [],
    patents: [],
    portfolios: [],
    projects: [],
    skills: [],
    trainings: [],
    workExperiences: [],

})

  const isLoading = ref(false) // 로딩 상태
  const error = ref(null) // 에러 메세지

  // resume 조회 
  async function readResume() {
    isLoading.value = true
    error.value = null

    try{
      const response = await apiAuth.get('/resume')
      resumeData.value = response.data

      console.log('resume 조회 성공: ', response.data)
      console.log('resumeData.value : ', resumeData.value)
    } catch (err){
      console.error('Resume 조회 실패: ', err)
      err.value = '이력서 정보를 불러오기 실패'
    }finally{
      isLoading.value = false
      // console.log("Resume데이터 ", resumeData.value)
    }
  }

  // resume 저장
  async function saveResume() {
    console.log('[debug] resume 저장요청 데이터 - personalFile.value :', personalFile.value);

    const formData = new FormData();
    formData.append('personalFile', personalFile.value || null);
    
    isLoading.value = true;
    error.value = null;
    
    try {
      await apiAuth.post('/resume', resumeData.value, {
        headers: {
          'Content-Type': 'application/json',
        },
      })

      await apiAuth.post('/resume/files', formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      })

      return true // 성공
    } catch (err) {
      console.error('Resume 저장 실패: ', err);
      error.value = '이력서 저장 실패';
      return false // 실패
    } finally {
      isLoading.value = false;
    }
  }
  return { resumeData, isLoading, error, readResume, saveResume, personalFile }
})
