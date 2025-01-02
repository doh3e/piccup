import { ref, computed, TrackOpTypes } from 'vue'
import { defineStore } from 'pinia'
import { apiAuth, api } from '@/api'

export const useResumeStore = defineStore('resume', () => {
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

}) // 이력서 데이터

  const isLoading = ref(false) // 로딩 상태
  const error = ref(null) // 에러 메세지

  // resume 조회 
  async function readResume() {
    isLoading.value = true
    error.value = null

    try{
      const response = await apiAuth.get('/resume')
      resumeData.value = response.data
      console.log(resumeData.value.educations, "here")
    } catch (err){
      console.error('Resume 조회 실패: ', err)
      err.value = '이력서 정보를 불러오기 실패'
    }finally{
      isLoading.value = false
      // console.log("Resume데이터 ", resumeData.value)
    }
  }

  return { resumeData, isLoading, error, readResume }
})
