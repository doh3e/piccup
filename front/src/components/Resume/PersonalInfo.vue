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
            이름
            <span class="text-red-500 ml-0.5">*</span>
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
            생년월일
            <span class="text-red-500 ml-0.5">*</span>
          </label>
          <input
            v-model="localData.birthDate"
            type="date"
            class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            @input="updateData"
          />
        </div>

        <!-- Gender -->
        <div>
          <label class="flex items-center text-sm font-medium text-gray-700">
            성별
            <span class="text-red-500 ml-0.5">*</span>
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
        </div>

        <!-- Email -->
        <div>
          <label class="flex items-center text-sm font-medium text-gray-700">
            이메일
            <span class="text-red-500 ml-0.5">*</span>
          </label>
          <input
            v-model="localData.email"
            type="email"
            class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            @input="updateData"
          />
        </div>

        <!-- Phone -->
        <div>
          <label class="flex items-center text-sm font-medium text-gray-700">
            전화번호
            <span class="text-red-500 ml-0.5">*</span>
          </label>
          <input
            v-model="localData.mobilePhone"
            type="tel"
            placeholder="010-0000-0000"
            class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50"
            @input="formatPhoneNumber"
          />
        </div>

        <!-- Address -->
        <div>
          <label class="flex items-center text-sm font-medium text-gray-700">
            주소
          </label>
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
        </div>
        <div>
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
        <div class="w-40 h-40 relative">
          <div
            v-if="!localData.photo"
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
            <span class="mt-2 text-sm text-gray-500">사진추가</span>
          </div>
          <img
            v-else
            :src="localData.photo"
            class="w-full h-full object-cover rounded-lg"
            alt="Profile photo"
          />
          <input
            ref="fileInput"
            type="file"
            accept="image/*"
            class="hidden"
            @change="handleFileUpload"
          />
          <button
            v-if="localData.photo"
            @click="removePhoto"
            class="absolute top-0 right-0 -mt-2 -mr-2 bg-red-500 text-white rounded-full p-1 hover:bg-red-600 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-red-500"
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

  <!-- Naver Map Modal -->
  <div
    v-if="showAddressModal"
    class="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50"
  >
    <div class="bg-white p-4 rounded-lg w-full max-w-2xl">
      <div class="flex justify-between items-center mb-4">
        <h3 class="text-lg font-medium">주소 검색</h3>
        <button
          @click="closeAddressModal"
          class="text-gray-500 hover:text-gray-700"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            class="h-6 w-6"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M6 18L18 6M6 6l12 12"
            />
          </svg>
        </button>
      </div>
      <div id="map" class="w-full h-96 mb-4"></div>
      <div class="flex justify-end">
        <button
          @click="closeAddressModal"
          class="px-4 py-2 bg-[#006B40] text-white rounded hover:bg-opacity-90 transition"
        >
          확인
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, watch } from "vue";

const props = defineProps({
  data: {
    type: Object,
    required: true,
  },
});

const emit = defineEmits(["update:data"]);

const localData = ref({...props.data });

const fileInput = ref(null);
const showAddressModal = ref(false);

const updateData = () => {
  emit("update:data", localData.value);
};

const formatPhoneNumber = () => {
  let phone = localData.value.phone.replace(/\D/g, "");
  if (phone.length >= 10) {
    phone = phone.replace(/(\d{3})(\d{4})(\d{4})/, "$1-$2-$3");
  }
  localData.value.phone = phone;
  updateData();
};

const triggerFileInput = () => {
  fileInput.value.click();
};

const handleFileUpload = (event) => {
  const file = event.target.files[0];
  if (file) {
    const reader = new FileReader();
    reader.onload = (e) => {
      localData.value.photo = e.target.result;
      updateData();
    };
    reader.readAsDataURL(file);
  }
};

const removePhoto = () => {
  localData.value.photo = "";
  updateData();
};

const openAddressModal = () => {
  showAddressModal.value = true;
  // Initialize Naver Maps in the next tick to ensure the DOM is ready
  setTimeout(() => {
    initializeNaverMap();
  }, 0);
};

const closeAddressModal = () => {
  showAddressModal.value = false;
};

const initializeNaverMap = () => {
  // Initialize Naver Maps here
  // You'll need to add your Naver Maps API key and implementation
  if (window.naver && window.naver.maps) {
    const mapOptions = {
      center: new window.naver.maps.LatLng(37.5665, 126.978),
      zoom: 13,
      zoomControl: true,
      zoomControlOptions: {
        position: window.naver.maps.Position.TOP_RIGHT,
      },
    };
    const map = new window.naver.maps.Map("map", mapOptions);

    // Add click event to map
    window.naver.maps.Event.addListener(map, "click", function (e) {
      const latlng = e.coord;

      // Reverse geocoding to get address
      window.naver.maps.Service.reverseGeocode(
        {
          location: new window.naver.maps.LatLng(latlng.lat(), latlng.lng()),
        },
        function (status, response) {
          if (status === window.naver.maps.Service.Status.OK) {
            const result = response.result;
            const items = result.items;
            localData.value.address = items[0].address;
            updateData();
          }
        }
      );
    });
  }
};

const openAddressSearch = () => {
  new window.daum.Postcode({
    oncomplete: (data) => {
      localData.value.address = data.address;
      localData.value.detailAddress = '';
      updateData();
    }
  }).open();
};

watch(
  () => props.data,
  (newData) => {
    localData.value = { ...localData.value, ...newData,};
  },
  { deep: true, immediate: true }
);
</script>

<style scoped>
/* Add any additional styling here */
</style>
