import { ref, computed, TrackOpTypes } from 'vue'
import { defineStore } from 'pinia'
import { apiAuth, api } from '@/api'

export const useResumeStore = defineStore('resume', () => {
  // 이력서 데이터
  const personalFile = ref(null)
  const eduFile = ref(null) 
  const workFile = ref(null)
  const portFile = ref(null)
  const resumeData = ref({})

  const isLoading = ref(false) // 로딩 상태
  const error = ref(null) // 에러 메세지

  // resume 조회 
  async function readResume() {
    isLoading.value = true
    error.value = null

    try{
      const response = await apiAuth.get('/resume')
      resumeData.value = response.data

      console.log('조회) resume 조회 성공: ', response.data)
      console.log('조회) resumeData.value : ', resumeData.value)
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
    const filteredResumeData = removeEmptyFields(resumeData.value)
    const formData = new FormData();
    formData.append('personalFile', personalFile.value || null);
    isLoading.value = true;
    error.value = null;
    
    console.log('[debug] resume 저장요청 데이터 - personalFile.value :', personalFile.value);
    console.log('저장) 필터링된 resumeData.value : ', filteredResumeData);
    
    try {
      // console.log('저장) resumeData.value : ', resumeData.value)
      console.log('저장) filteredResumeData : ', filteredResumeData)
      await apiAuth.post('/resume', filteredResumeData || {}, {
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

  // Helper 함수: null, 빈 배열, 빈 객체 필터링
  // - 수정 필요
  // - 이력서 생성 안된 상태에서 (특히, PersonalInfo 생성 안된 상태에서 사진 추가 불가)
  // - 각 항목이 생성 안된경우, 항목명 (skills, personalInfo, preference 등을 전달 안 하면 필수필드 안 채워도 오류 안남)
function removeEmptyFields(data) {

  console.log("첫 데이터 : ", data)
  if (Array.isArray(data)) {
    return data
      .filter((item) => item && Object.keys(item).length > 0)
      .map(removeEmptyFields); // 재귀적으로 배열 내 요소 필터링
  } else if (typeof data === 'object' && data !== null) {
    const filteredObject = {};
    Object.entries(data).forEach(([key, value]) => {
      if (
        value !== null &&
        value !== undefined &&
        (Array.isArray(value) ? value.length > 0 : true) && // 빈 배열 제외
        (typeof value === 'object' ? Object.keys(value).length > 0 : true) // 빈 객체 제외
      ) {
        filteredObject[key] = removeEmptyFields(value); // 재귀적으로 필터링
      }
    });
    return filteredObject;
  }
  return data; // 원시 값 그대로 반환
}

  return { resumeData, isLoading, error, readResume, saveResume, personalFile }
})
