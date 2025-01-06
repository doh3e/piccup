<template>
  <div class="bg-white p-6 rounded-lg shadow">
    <h2 class="text-2xl font-bold text-[#006B40] mb-6">인적사항</h2>
    <p class="text-right text-red-500 text-sm mb-4">* 필수 입력 정보입니다.</p>

    <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
      <!-- Left Column -->
      <div class="space-y-4">
        <!-- Name -->
        <div>
          <label class="flex items-center text-sm font-medium text-gray-700">
            이름 <span class="text-red-500 ml-0.5">*</span>
          </label>
          <input
            v-model="localData.username"
            type="text"
            class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            @input="updateData"
          />
        </div>

        <!-- Birth Date -->
        <div>
          <label class="flex items-center text-sm font-medium text-gray-700">
            생년월일 <span class="text-red-500 ml-0.5">*</span>
          </label>
          <input
            v-model="localData.birthDate"
            type="date"
            class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            @input="updateData"
          />
          <p v-if="errors.birthDate" class="mt-1 text-sm text-red-500">
            {{ errors.birthDate }}
          </p>
        </div>

        <!-- Gender -->
        <div>
          <label class="flex items-center text-sm font-medium text-gray-700">
            성별 <span class="text-red-500 ml-0.5">*</span>
          </label>
          <select
            v-model="localData.gender"
            class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            @change="updateData"
          >
            <option value="남">남자</option>
            <option value="여">여자</option>
            <option value="미지정">미지정</option>
          </select>
          <p v-if="errors.gender" class="mt-1 text-sm text-red-500">
            {{ errors.gender }}
          </p>
        </div>

        <!-- Email -->
        <div>
          <label class="flex items-center text-sm font-medium text-gray-700">
            이메일 <span class="text-red-500 ml-0.5">*</span>
          </label>
          <input
            v-model="localData.email"
            type="email"
            class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            @input="updateData"
          />
          <p v-if="errors.email" class="mt-1 text-sm text-red-500">
            {{ errors.email }}
          </p>
        </div>

        <!-- Mobile Phone -->
        <div>
          <label class="flex items-center text-sm font-medium text-gray-700">
            휴대전화 <span class="text-red-500 ml-0.5">*</span>
          </label>
          <input
            v-model="localData.mobilePhone"
            type="tel"
            placeholder="010-0000-0000"
            class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            @input="formatMobilePhone"
          />
          <p v-if="errors.mobilePhone" class="mt-1 text-sm text-red-500">
            {{ errors.mobilePhone }}
          </p>
        </div>

        <!-- Home Phone -->
        <div>
          <label class="flex items-center text-sm font-medium text-gray-700">
            집전화
          </label>
          <input
            v-model="localData.homePhone"
            type="tel"
            placeholder="02-0000-0000"
            class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            @input="formatHomePhone"
          />
          <p v-if="errors.homePhone" class="mt-1 text-sm text-red-500">
            {{ errors.homePhone }}
          </p>
        </div>

        <!-- Degree -->
        <div>
          <label class="flex items-center text-sm font-medium text-gray-700">
            학위 <span class="text-red-500 ml-0.5">*</span>
          </label>
          <select
            v-model="localData.degree"
            class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            @change="updateData"
          >
            <option value="미지정">미지정</option>
            <option value="중등교육이수">고등학교</option>
            <option value="학사">학사</option>
            <option value="석사">석사</option>
            <option value="박사">박사</option>
          </select>
          <p v-if="errors.degree" class="mt-1 text-sm text-red-500">
            {{ errors.degree }}
          </p>
        </div>

        <!-- Address -->
        <div>
          <label class="flex items-center text-sm font-medium text-gray-700"
            >주소</label
          >
          <div class="flex gap-2">
            <input
              v-model="localData.address"
              type="text"
              readonly
              class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            />
            <button
              @click="openAddressSearch"
              class="mt-1 px-3 py-2 bg-gray-100 rounded-md hover:bg-gray-200 focus:outline-none focus:ring-2 focus:ring-[#006B40]"
            >
              주소 검색
            </button>
          </div>
          <input
            v-model="localData.addressDetail"
            type="text"
            placeholder="상세주소"
            class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            @input="updateData"
          />
        </div>
      </div>

      <!-- Right Column - Photo Upload -->
      <div class="flex justify-center items-start">
        <div class="w-40 h-10 relative">
          <div
            class="w-full h-full border-2 border-dashed border-gray-300 rounded-lg flex flex-col items-center justify-center cursor-pointer hover:border-[#006B40]"
            @click="triggerFileInput"
          >
            <svg
              xmlns="http://www.w3.org/2000/svg"
              class="h-8 w-8 text-gray-400"
              fill="none"
              viewBox="0 0 24 24"
              stroke="currentColor"
            >
              <path
                stroke-linecap="round"
                stroke-linejoin="round"
                stroke-width="2"
                d="M12 4v16m8-8H4"
              />
            </svg>
            <span class="mt-2 text-sm text-gray-500">사진변경</span>
          </div>
          <input
            ref="fileInput"
            type="file"
            accept="image/*"
            class="hidden"
            @change="handleFileUpload"
          />
          <div v-if="previewUrl || localData.profileImgPath">
              <img
              :src="previewUrl ? previewUrl : getPhotoUrl(localData.profileImgPath)"
              class="w-full h-full object-cover rounded-lg"
              :alt="previewUrl ? '사진 미리보기' : localData.profileImgName"
              />
              <button
              @click="removePhoto"
              class="absolute top-10 right-1 -mt-2 -mr-2 bg-red-500 text-white rounded-full p-1 hover:bg-red-600 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-red-500"
              >
              <svg
              xmlns="http://www.w3.org/2000/svg"
              class="h-4 w-4"
              viewBox="0 0 20 20"
              fill="currentColor"
              >
              <path
              fill-rule="evenodd"
              d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
              clip-rule="evenodd"
              />
            </svg>
          </button>
        </div>
</div>
        </div>
      </div>
    </div>
</template>

<script setup>
import { ref, watch } from "vue";
import { useResumeStore } from "@/stores/resume";


const props = defineProps({
  data: {
    type: Object,
    required: false,
  },
});

const resumeStore = useResumeStore();
const localData = ref({
  ...{
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
  ...(props.data || {} ),
  })

const fileInput = ref(null);
const previewUrl = ref(null); // 사진 미리보기 URL
const emit = defineEmits(["update:data"]);


// 사진 UUID를 기반으로 URL 생성
const getPhotoUrl = (photoUuid) => `http://localhost:8080/api/v1/resume/view/profile_images/${photoUuid}`;
// personalInfo 사진 : resume/view/profile_images/{uuid}
// educations 성적증명서 : resume/view/educations_files/{uuid}
// workExperiences 경력증명서 : resume/view/work_files/{uuid}
// portfolios 포트폴리오 : resume/view/portfolio_files/{uuid}

const errors = ref({
  email: "",
  gender: "",
  homePhone: "",
  mobilePhone: "",
  degree: "",
  birthDate: "",
});

const updateData = () => {
  emit("update:data", localData.value);
};

watch (() => localStorage.getItem("email"), (newEmail) => {
  localData.value.email = newEmail
})

// 이메일 유효성 검사
watch(
  () => localData.value.email,
  (newEmail) => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!newEmail) {
      errors.value.email = "이메일은 필수입니다.";
    } else if (!emailRegex.test(newEmail)) {
      errors.value.email = "이메일 형식이 올바르지 않습니다.";
    } else {
      errors.value.email = "";
    }
  }
);

// 성별 유효성 검사
watch(
  () => localData.value.gender,
  (newGender) => {
    const validGenders = ["남", "여", "미지정"];
    if (!validGenders.includes(newGender)) {
      errors.value.gender = "성별은 '남', '여', '미지정' 중 하나여야 합니다.";
    } else {
      errors.value.gender = "";
    }
  }
);

// 전화번호 유효성 검사 및 포맷팅
const formatMobilePhone = () => {
  let phone = localData.value.mobilePhone.replace(/\D/g, "");
  if (phone.length >= 10) {
    phone = phone.replace(/(\d{3})(\d{4})(\d{4})/, "$1-$2-$3");
    if (!/^\d{2,4}-\d{3,4}-\d{4}$/.test(phone)) {
      errors.value.mobilePhone = "mobilePhone 형식이 올바르지 않습니다.";
    } else {
      errors.value.mobilePhone = "";
    }
  }
  localData.value.mobilePhone = phone;
  updateData();
};

const formatHomePhone = () => {
  let phone = localData.value.homePhone.replace(/\D/g, "");
  if (phone.length >= 9) {
    phone = phone.replace(/(\d{2,4})(\d{3,4})(\d{4})/, "$1-$2-$3");
    if (!/^\d{2,4}-\d{3,4}-\d{4}$/.test(phone)) {
      errors.value.homePhone = "homePhone 형식이 올바르지 않습니다.";
    } else {
      errors.value.homePhone = "";
    }
  }
  localData.value.homePhone = phone;
  updateData();
};

// 학위 유효성 검사
watch(
  () => localData.value.degree,
  (newDegree) => {
    const validDegrees = ["미지정", "중등교육이수", "학사", "석사", "박사"];
    if (!newDegree) {
      errors.value.degree = "학위는 필수입니다.";
    } else if (!validDegrees.includes(newDegree)) {
      errors.value.degree =
        "학위는 '미지정', '중등교육이수', '학사', '석사', '박사' 중 하나여야 합니다.";
    } else {
      errors.value.degree = "";
    }
  }
);

// 생년월일 유효성 검사
watch(
  () => localData.value.birthDate,
  (newBirthDate) => {
    const today = new Date();
    const selectedDate = new Date(newBirthDate);

    if (selectedDate > today) {
      errors.value.birthDate = "미래의 날짜는 선택할 수 없습니다.";
    } else {
      errors.value.birthDate = "";
    }
    updateData();
  }
);

const triggerFileInput = () => {
  fileInput.value.click();
};


const handleFileUpload = (event) => {
  const uploadedFile = event.target.files[0];
  if (uploadedFile) {
    previewUrl.value = URL.createObjectURL(uploadedFile);
    console.log("previewUrl ", previewUrl.value);
    console.log("uploadedFile ", uploadedFile);
    resumeStore.personalFile = uploadedFile
  }
};

const removePhoto = () => {
  localData.value.profileImgName = ""
  localData.value.profileImgPath = ""
  resumeStore.personalFile = null
  previewUrl.value = ""
  updateData();
};

const openAddressSearch = () => {
  new window.daum.Postcode({
    oncomplete: (data) => {
      localData.value.address = data.address;
      localData.value.addressDetail = "";
      localData.value.postalCode = data.zonecode;
      updateData();
    },
  }).open();
};

watch(
  () => props.data,
  (newData) => {
    localData.value = { ...localData.value, ...newData };
  },
  { deep: true, immediate: true }
);

</script>
