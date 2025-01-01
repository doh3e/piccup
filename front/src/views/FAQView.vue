<template>
  <div class="min-h-screen bg-[#F8F8F8]">
    <!-- FAQ Section -->
    <section class="max-w-4xl mx-auto p-6">
      <h1 class="text-3xl font-bold text-[#006B40] mb-8">자주 묻는 질문</h1>

      <!-- FAQ Categories -->
      <div class="grid grid-cols-1 md:grid-cols-3 gap-4 mb-8">
        <button
          v-for="category in categories"
          :key="category.id"
          @click="selectedCategory = category.id"
          class="p-4 rounded-lg text-left transition"
          :class="
            selectedCategory === category.id
              ? 'bg-[#E6FF94] text-[#006B40]'
              : 'bg-white hover:bg-gray-50 shadow'
          "
        >
          <h3 class="font-medium mb-1">{{ category.name }}</h3>
          <p class="text-sm text-gray-600">{{ category.description }}</p>
        </button>
      </div>

      <!-- FAQ List -->
      <div class="space-y-4">
        <div
          v-for="faq in filteredFaqs"
          :key="faq.id"
          class="bg-white rounded-lg shadow"
        >
          <button
            @click="toggleFaq(faq.id)"
            class="w-full px-6 py-4 flex items-center justify-between"
          >
            <span class="font-medium text-[#1F1F1F]">{{ faq.question }}</span>
            <ChevronDownIcon
              class="h-5 w-5 transition-transform"
              :class="{ 'transform rotate-180': openFaq === faq.id }"
            />
          </button>
          <div
            v-show="openFaq === faq.id"
            class="px-6 py-4 border-t border-gray-100"
          >
            <p class="text-gray-600">{{ faq.answer }}</p>
          </div>
        </div>
      </div>

      <!-- Help Desk Link -->
      <div class="mt-8 text-center">
        <p class="text-gray-600 mb-4">원하시는 답변을 찾지 못하셨나요?</p>
        <button
          @click="openHelpDesk"
          class="px-6 py-2 bg-[#006B40] text-white rounded-lg hover:bg-opacity-90 transition"
        >
          1:1 문의하기
        </button>
      </div>
    </section>

    <!-- Help Desk Modal -->
    <div
      v-if="showHelpDesk"
      class="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50"
    >
      <div
        class="bg-white rounded-lg max-w-2xl w-full max-h-[90vh] overflow-y-auto p-6"
      >
        <div class="flex justify-between items-center mb-6">
          <h2 class="text-2xl font-bold text-[#1F1F1F]">문의하기</h2>
          <button
            @click="showHelpDesk = false"
            class="text-gray-400 hover:text-gray-600"
          >
            <XIcon class="h-6 w-6" />
          </button>
        </div>

        <form @submit.prevent="submitInquiry" class="space-y-6">
          <!-- Inquiry Type -->
          <div>
            <label class="block text-sm font-medium text-[#1F1F1F] mb-1">
              문의 유형 <span class="text-red-500">*</span>
            </label>
            <select
              v-model="inquiry.type"
              class="w-full rounded-lg border-gray-200 focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50 shadow"
            >
              <option value="" disabled>문의 유형을 선택하세요</option>
              <option value="account">계정 관련</option>
              <option value="resume">이력서 관련</option>
              <option value="technical">기술적 문의</option>
              <option value="other">기타 문의</option>
            </select>
          </div>

          <!-- Inquiry Content -->
          <div>
            <label class="block text-sm font-medium text-[#1F1F1F] mb-1">
              문의 내용 <span class="text-red-500">*</span>
            </label>
            <textarea
              v-model="inquiry.content"
              rows="5"
              class="w-full rounded-lg border-gray-200 focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50 shadow"
              placeholder="문의하실 내용을 입력해주세요"
            ></textarea>
          </div>

          <!-- Email -->
          <div>
            <label class="block text-sm font-medium text-[#1F1F1F] mb-1">
              이메일 <span class="text-red-500">*</span>
            </label>
            <input
              v-model="inquiry.email"
              type="email"
              class="w-full rounded-lg border-gray-200 focus:border-[#006B40] focus:ring focus:ring-[#8CD196] focus:ring-opacity-50 shadow"
            />
          </div>

          <!-- File Upload -->
          <div>
            <label class="block text-sm font-medium text-[#1F1F1F] mb-1">
              파일첨부 <span class="text-gray-500 text-sm">(0MB/20MB)</span>
            </label>
            <div
              class="w-full p-4 border-2 border-dashed border-gray-200 rounded-lg hover:border-[#006B40] transition cursor-pointer"
              @click="$refs.fileInput.click()"
            >
              <input
                ref="fileInput"
                type="file"
                class="hidden"
                @change="handleFileUpload"
              />
              <p class="text-center text-gray-500">파일 업로드</p>
            </div>
          </div>

          <!-- Terms Agreement -->
          <div class="flex items-start space-x-2">
            <input
              v-model="inquiry.agreementChecked"
              type="checkbox"
              id="agreement"
              class="mt-1"
            />
            <label for="agreement" class="text-sm text-gray-600">
              문의 답변을 위해 아이디, 이메일 수집에 동의합니다. 수집된 정보는
              5년간 보관됩니다.
            </label>
          </div>

          <!-- Submit Button -->
          <button
            type="submit"
            class="w-full py-3 bg-[#006B40] text-white rounded-lg hover:bg-opacity-90 transition disabled:opacity-50"
            :disabled="!isFormValid"
          >
            보내기
          </button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import { ref, computed } from "vue";
import { SearchIcon, ChevronDownIcon, XIcon } from "lucide-vue-next";

export default {
  components: {
    SearchIcon,
    ChevronDownIcon,
    XIcon,
  },
  setup() {
    const searchQuery = ref("");
    const selectedCategory = ref("general");
    const openFaq = ref(null);
    const showHelpDesk = ref(false);

    const categories = [
      {
        id: "general",
        name: "일반",
        description: "계정, 로그인, 기본 이용방법",
      },
      {
        id: "resume",
        name: "이력서",
        description: "이력서 작성, 양식, 관리",
      },
      {
        id: "technical",
        name: "기술지원",
        description: "오류 해결, 기술적 문의",
      },
    ];

    const faqs = [
      {
        id: 1,
        category: "general",
        question: "회원가입은 어떻게 하나요?",
        answer:
          '홈페이지 우측 상단의 "회원가입" 버튼을 클릭하여 필요한 정보를 입력하시면 됩니다.',
      },
      {
        id: 2,
        category: "resume",
        question: "이력서는 몇 개까지 작성할 수 있나요?",
        answer:
          "이력서는 무제한으로 작성 가능합니다. 각각의 이력서는 독립적으로 관리됩니다.",
      },
      // Add more FAQs as needed
    ];

    const inquiry = ref({
      type: "",
      content: "",
      email: "",
      file: null,
      agreementChecked: false,
    });

    const filteredFaqs = computed(() => {
      return faqs.filter((faq) => {
        const matchesSearch =
          faq.question
            .toLowerCase()
            .includes(searchQuery.value.toLowerCase()) ||
          faq.answer.toLowerCase().includes(searchQuery.value.toLowerCase());
        const matchesCategory =
          selectedCategory.value === "all" ||
          faq.category === selectedCategory.value;
        return matchesSearch && matchesCategory;
      });
    });

    const isFormValid = computed(() => {
      return (
        inquiry.value.type &&
        inquiry.value.content &&
        inquiry.value.email &&
        inquiry.value.agreementChecked
      );
    });

    const toggleFaq = (id) => {
      openFaq.value = openFaq.value === id ? null : id;
    };

    const openHelpDesk = () => {
      showHelpDesk.value = true;
    };

    const handleFileUpload = (event) => {
      const file = event.target.files[0];
      if (file) {
        inquiry.value.file = file;
      }
    };

    const submitInquiry = () => {
      if (isFormValid.value) {
        // Handle form submission
        console.log("Submitting inquiry:", inquiry.value);
        showHelpDesk.value = false;
        // Reset form
        inquiry.value = {
          type: "",
          content: "",
          email: "",
          file: null,
          agreementChecked: false,
        };
      }
    };

    return {
      searchQuery,
      selectedCategory,
      categories,
      filteredFaqs,
      openFaq,
      showHelpDesk,
      inquiry,
      isFormValid,
      toggleFaq,
      openHelpDesk,
      handleFileUpload,
      submitInquiry,
    };
  },
};
</script>

<style>
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.3s;
}

.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}
</style>
