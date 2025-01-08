<template>
  <div class="min-h-screen bg-gray-50 px-4 sm:px-6 lg:px-8">
    <div class="max-w-4xl mx-auto">
      <h1
        class="text-3xl font-bold text-center text-primary mb-8 text-[#006B40]"
      >
        내가 작성한 자기소개서
      </h1>

      <!-- Search, Filter, and Add Button -->
      <div class="mb-6 flex items-center justify-between">
        <div class="flex items-center space-x-4">
          <input
            v-model="searchQuery"
            type="text"
            placeholder="검색..."
            class="px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-primary"
            @input="handleSearch"
          />
          <select
            v-model="sortBy"
            class="px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-primary"
            @change="handleSort"
          >
            <option value="latest">최신순</option>
            <option value="oldest">오래된순</option>
          </select>
        </div>
        <router-link
          to="/apply"
          class="px-4 py-2 bg-[#006B40] text-white rounded-md hover:bg-opacity-90 transition duration-300"
        >
          자기소개서 작성
        </router-link>
      </div>

      <!-- Loading and Error States -->
      <div v-if="isLoading" class="text-center py-8">
        <p class="text-gray-600">Loading applies...</p>
      </div>

      <div v-else-if="errorMessage" class="text-center py-8">
        <p class="text-red-500">{{ errorMessage }}</p>
      </div>

      <!-- Apply List -->
      <div v-else-if="applies.length > 0" class="space-y-6">
        <div
          v-for="apply in applies"
          :key="apply.id"
          class="bg-white p-6 rounded-lg shadow-md hover:shadow-lg transition-shadow duration-300"
        >
          <h2 class="text-xl font-bold text-primary mb-2">
            {{ apply.companyName }}
          </h2>
          
          <p class="text-gray-600 mb-4">
            <!-- {{ truncateContent(apply.coverContent) }} -->
              <!-- {{ apply.status.currentStatus }} -->
          </p>
          <p v-if="apply.status && apply.status.progressing" class="text-gray-600 mb-4">
            진행중
          </p>
          <p v-else-if="apply.status" class="text-gray-600 mb-4">
            종료된 전형
          </p>
          <div class="flex justify-between items-center">
            <button
              @click="viewApply(apply.applyId)"
              class="text-primary hover:text-secondary transition-colors duration-300"
            >
              자세히 보기
            </button>
          </div>
        </div>
      </div>
      <div
        v-else-if="applies.length === 0"
        class="text-center text-gray-500 mt-8"
      >
        작성한 자기소개서가 없습니다. 새로운 자기소개서를 작성해보세요!
      </div>

      <!-- Pagination -->
      <div class="mt-8 flex justify-center">
        <button
          v-for="page in totalPages"
          :key="page"
          @click="changePage(page)"
          class="mx-1 px-3 py-1 rounded-md"
          :class="
            currentPage === page
              ? 'bg-primary text-white'
              : 'bg-gray-200 text-gray-700 hover:bg-gray-300'
          "
        >
          {{ page }}
        </button>
      </div>
    </div>

    <!-- Apply Detail Modal -->
    <!-- <div
      v-if="selectedApply"
      class="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50"
    >
      <div
        class="bg-white p-8 rounded-lg max-w-2xl w-full max-h-[90vh] overflow-y-auto"
      >
        <h2 class="text-2xl font-bold text-primary mb-4">
          {{ selectedApply.title }}
        </h2>
        <div
          v-for="section in applySections"
          :key="section.id"
          class="mb-6"
        >
          <h3 class="text-lg font-semibold text-secondary mb-2">
            {{ section.title }}
          </h3>
          <p class="text-gray-700 whitespace-pre-wrap">
            {{ selectedApply[section.id] }}
          </p>
        </div>
        <div class="mt-6 flex justify-end">
          <button
            @click="closeModal"
            class="bg-primary text-white px-4 py-2 rounded-md hover:bg-opacity-90 transition duration-300"
          >
            닫기
          </button>
        </div>
      </div>
    </div> -->
  </div>
</template>

<script setup>
import { ref, onMounted, computed } from "vue";
import { useRouter } from "vue-router";
import { api, apiAuth } from "@/api";

const router = useRouter();
const applies = ref([]);
const searchQuery = ref("");
const sortBy = ref("latest");
const currentPage = ref(1);
const itemsPerPage = 10;
const selectedApply = ref(null);
const isLoading = ref(false);
const errorMessage = ref("");

const applySections = [
  { id: "motivation", title: "지원동기" },
  { id: "aspirations", title: "입사후 포부" },
  { id: "background", title: "성장배경" },
  { id: "personality", title: "성격 및 장단점" },
  { id: "crisisManagement", title: "위기극복사례" },
  { id: "initiative", title: "주도적으로 업무를 수행한 사례" },
  { id: "additional", title: "기타 하고싶은 말" },
];

onMounted(async () => {
  await fetchApplies();
});

const fetchApplies = async () => {
  try {
    isLoading.value = true;
    const response = await apiAuth.get('/applys');
    console.log(response);
    if (response.status != 200) throw new Error('Failed to fetch applies');
    const data = await response.data;
    applies.value = data;
  } catch (error) {
    console.error('Failed to fetch applies:', error);
    errorMessage.value = '아직 이력서를 작성하지 않으셨어요! 이력서를 작성하러 가볼까요?';
  } finally {
    isLoading.value = false;
  }
};

const handleSearch = () => {
  applies.value = applies.value.filter(
    (apply) =>
      apply.title.toLowerCase().includes(searchQuery.value.toLowerCase()) ||
      apply.content.toLowerCase().includes(searchQuery.value.toLowerCase())
  );
};

const handleSort = () => {
  applies.value.sort((a, b) => {
    const dateA = new Date(a.createdAt);
    const dateB = new Date(b.createdAt);
    return sortBy.value === "latest" ? dateB - dateA : dateA - dateB;
  });
};

const changePage = (page) => {
  currentPage.value = page;
};

const viewApply = (id) => {
  // selectedApply.value = applies.value.find((cl) => cl.id === id);
  router.push({name: 'ApplyDetail', params: {applyId: id}})
};

const closeModal = () => {
  selectedApply.value = null;
};

const truncateContent = (content) => {
  return content.length > 100 ? content.substring(0, 100) + "..." : content;
};

const formatDate = (dateString) => {
  const options = { year: "numeric", month: "long", day: "numeric" };
  return new Date(dateString).toLocaleDateString("ko-KR", options);
};

const totalPages = computed(() => {
  return Math.ceil(applies.value.length / itemsPerPage);
});
</script>

<style scoped>
/* Add any additional scoped styles here */
</style>
