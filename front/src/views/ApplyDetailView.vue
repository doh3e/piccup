<template>
  <div class="min-h-screen bg-gray-50 px-4 sm:px-6 lg:px-8">
    <div class="max-w-4xl mx-auto">
      <h1
        class="text-3xl font-bold text-center text-primary mb-8 text-[#006B40]"
      >
        자기소개서 상세보기
      </h1>


      <!-- Loading and Error States -->
      <div v-if="isLoading" class="text-center py-8">
        <p class="text-gray-600">Loading applies...</p>
      </div>

      <div v-else-if="errorMessage" class="text-center py-8">
        <p class="text-red-500">{{ errorMessage }}</p>
      </div>

      <!-- Apply -->
      <div v-else-if="apply" class="space-y-6">
        {{ apply.companyName }}

      <!-- Coverletters -->
      <div v-if="apply.coverLetters.length > 0" class="space-y-6">
        <div
          v-for="coverLetter in apply.coverLetters"
          :key="coverLetter.id"
          class="bg-white p-6 rounded-lg shadow-md hover:shadow-lg transition-shadow duration-300"
        >
          <h2 class="text-xl font-bold text-primary mb-2">
            {{ coverLetter.coverTitle }}
          </h2>

          <p class="text-gray-600 mb-4">
            {{ coverLetter.coverContent }}
          </p>

        </div>
      </div>
      <div
        v-else-if="apply.coverLetters.length === 0"
        class="text-center text-gray-500 mt-8"
      >
        작성한 자기소개서가 없습니다. 새로운 자기소개서를 작성해보세요!
      </div>
      </div>
      <div v-else class="text-center text-gray-500 mt-8">
        404 Not Found
      </div>
    </div>
    
  </div>
</template>

<script setup>
import { ref, onMounted, computed } from "vue";
import { api, apiAuth } from "@/api";
import { useRoute } from "vue-router";

const route = useRoute();
const apply = ref(null);
const isLoading = ref(false);
const errorMessage = ref("");


onMounted(async () => {
  await fetchApply();
});

const fetchApply = async () => {
  try {
    isLoading.value = true;
    const response = await apiAuth.get(`/applys/${route.params.applyId}`);
    if (response.status != 200) throw new Error('Failed to fetch applies');

    const data = await response.data;
    apply.value = data;

  } catch (error) {
    console.error('Failed to fetch applies:', error);
    errorMessage.value = '404 Not Found';
  } finally {
    isLoading.value = false;
  }
};


</script>

<style scoped>
/* Add any additional scoped styles here */
</style>
