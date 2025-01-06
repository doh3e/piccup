<template>
  <div class="min-h-screen bg-gray-50 px-4 sm:px-6 lg:px-8">
    <div>
      <h1
        class="text-3xl font-bold text-center text-primary mb-8 text-[#006B40]"
      >
        자기소개서 작성
      </h1>
      <div class="flex space-x-8">
        <!-- Resume Tab View -->
        <div class="w-1/3">
          <div v-if="resumeData.length > 0">
            <ResumeTabView />
          </div>
          <div v-else class="bg-white p-6 rounded-lg shadow-md text-center">
            <p class="text-lg mb-4">
              아직 이력서를 작성하지 않으셨어요! 이력서를 작성하러 가볼까요?
            </p>
            <router-link
              to="/resume"
              class="inline-block bg-primary text-[#006B40] px-6 py-2 rounded-md hover:bg-opacity-90 transition duration-300 border border-gray-300" 
            >
              이력서 작성하기
            </router-link>
          </div>
        </div>

        <!-- Cover Letter Tabs -->
        <div class="w-2/3">
          <div class="bg-white p-6 rounded-lg shadow-md">
            <input
              v-model="coverLetterTitle"
              class="w-full text-2xl font-bold mb-4 p-2 border-b-2 border-gray-200 focus:border-primary focus:outline-none"
              placeholder="자기소개서 제목을 입력하세요"
            />

            <ul class="flex space-x-2 border-b mb-4 overflow-x-auto">
              <li v-for="section in coverLetterSections" :key="section.id">
                <button
                  @click="currentSection = section.id"
                  :class="[
                    'px-4 py-2 focus:outline-none whitespace-nowrap',
                    currentSection === section.id
                      ? 'border-b-2 border-primary text-primary'
                      : 'text-gray-500',
                  ]"
                >
                  {{ section.title }}
                </button>
              </li>
            </ul>

            <!-- Cover Letter Form -->
            <form @submit.prevent="saveCoverLetter" class="space-y-8">
              <CoverLetterSection
                v-for="section in coverLetterSections"
                :key="section.id"
                v-show="currentSection === section.id"
                :title="section.title"
                :content="coverLetterData[section.id]"
                @update:content="updateSection(section.id, $event)"
                @save="saveSection(section.id)"
              />

              <div class="flex justify-end">
                <button
                  type="submit"
                  class="bg-primary text-[#006B40] px-8 py-3 rounded-md hover:bg-opacity-90 transition duration-300 border border-gray-300"
                >
                  전체 저장
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import ResumeTabView from "@/components/CoverLetter/ResumeTabView.vue";
import CoverLetterSection from "@/components/CoverLetter/CoverLetterSection.vue";

const router = useRouter();
const resumeData = ref([]);
const coverLetterData = ref({});
const currentSection = ref("motivation");
const coverLetterTitle = ref("");

const coverLetterSections = [
  { id: "motivation", title: "지원동기" },
  { id: "aspirations", title: "입사후 포부" },
  { id: "background", title: "성장배경" },
  { id: "personality", title: "성격 및 장단점" },
  { id: "crisisManagement", title: "위기극복사례" },
  { id: "initiative", title: "주도적으로 업무를 수행한 사례" },
  { id: "additional", title: "기타 하고싶은 말" },
];

onMounted(async () => {
  const isLoggedIn = checkUserAuthentication();
  if (!isLoggedIn) {
    router.push("/auth");
    return;
  }

  await fetchResumeData();
  await fetchCoverLetterData();
});

const checkUserAuthentication = () => {
  const token = localStorage.getItem("authToken");
  return !!token;
};

const fetchResumeData = async () => {
  try {
    const response = await fetch("/api/resume");
    if (!response.ok) throw new Error("Failed to fetch resume data");
    const data = await response.json();
    resumeData.value = [
      {
        id: 1,
        title: data.personalInfo.name + "의 이력서",
        data: data,
      },
    ];
  } catch (error) {
    console.error("Failed to fetch resume data:", error);
    resumeData.value = [];
  }
};

const fetchCoverLetterData = async () => {
  try {
    const response = await fetch("/api/coverletter");
    const data = await response.json();
    coverLetterData.value = data.sections;
    coverLetterTitle.value = data.title || "";
  } catch (error) {
    console.error("Failed to fetch cover letter data:", error);
    coverLetterData.value = {};
    coverLetterTitle.value = "";
  }
};

const updateSection = (sectionId, content) => {
  coverLetterData.value[sectionId] = content;
};

const saveSection = async (sectionId) => {
  try {
    const response = await fetch(`/api/v1/coverletter/${sectionId}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ content: coverLetterData.value[sectionId] }),
    });
    if (!response.ok) throw new Error("Failed to save section");
    alert("섹션이 저장되었습니다.");
  } catch (error) {
    console.error(`Failed to save section ${sectionId}:`, error);
    alert("섹션 저장에 실패했습니다. 다시 시도해주세요.");
  }
};

const saveCoverLetter = async () => {
  try {
    const response = await fetch("/api/coverletter", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        title: coverLetterTitle.value,
        sections: coverLetterData.value,
      }),
    });
    if (!response.ok) throw new Error("Failed to save cover letter");
    alert("자기소개서가 성공적으로 저장되었습니다.");
  } catch (error) {
    console.error("Failed to save cover letter:", error);
    alert("자기소개서 저장에 실패했습니다. 다시 시도해주세요.");
  }
};
</script>

<style scoped>
/* 필요한 경우 추가 스타일 */
.overflow-x-auto {
  scrollbar-width: thin;
  scrollbar-color: rgba(156, 163, 175, 0.5) transparent;
}

.overflow-x-auto::-webkit-scrollbar {
  height: 6px;
}

.overflow-x-auto::-webkit-scrollbar-track {
  background: transparent;
}

.overflow-x-auto::-webkit-scrollbar-thumb {
  background-color: rgba(156, 163, 175, 0.5);
  border-radius: 20px;
}
</style>
