<template>
  <div
    class="min-h-screen bg-gray-50 flex flex-col justify-center py-12 sm:px-6 lg:px-8"
  >
    <!-- 로고 및 제목 섹션 -->
    <div class="sm:mx-auto sm:w-full sm:max-w-md">
      <img
        class="mx-auto h-12 w-auto"
        src="/icons/piccup-logo-white.png"
        alt="PICCUP"
      />
      <h2 class="mt-6 text-center text-3xl font-extrabold text-primary">
        {{ isSignUp ? "회원가입" : "로그인" }}
      </h2>
      <p class="mt-2 text-center text-sm text-secondary">
        {{ isSignUp ? "이미 계정이 있으신가요?" : "아직 계정이 없으신가요?" }}
        <a
          href="#"
          class="font-medium text-primary hover:text-secondary"
          @click.prevent="toggleAuthMode"
        >
          {{ isSignUp ? "로그인" : "회원가입" }}
        </a>
      </p>
    </div>

    <!-- 폼 섹션 -->
    <div class="mt-8 sm:mx-auto sm:w-full sm:max-w-md">
      <div class="bg-white py-8 px-4 shadow sm:rounded-lg sm:px-10">
        <form class="space-y-6" @submit.prevent="handleSubmit">
          <!-- 이메일 입력 필드 -->
          <div>
            <label for="email" class="block text-sm font-medium text-gray-700"
              >이메일 주소</label
            >
            <div class="mt-1">
              <input
                id="email"
                name="email"
                type="email"
                autocomplete="email"
                required
                v-model="email"
                @blur="validateEmail"
                class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-primary focus:border-primary sm:text-sm"
              />
            </div>
            <p v-if="emailError" class="mt-2 text-sm text-red-600" v-html="emailError"></p>
          </div>

          <!-- 비밀번호 입력 필드 -->
          <div>
            <label
              for="password"
              class="block text-sm font-medium text-gray-700"
              >비밀번호</label
            >
            <div class="mt-1 relative">
              <input
                :id="isSignUp ? 'password' : 'current-password'"
                :name="isSignUp ? 'password' : 'current-password'"
                :type="showPassword ? 'text' : 'password'"
                :autocomplete="isSignUp ? 'new-password' : 'current-password'"
                required
                v-model="password"
                @blur="validatePassword"
                class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-primary focus:border-primary sm:text-sm"
              />
              <!-- 비밀번호 표시/숨김 토글 버튼 -->
              <button
                type="button"
                @click="togglePasswordVisibility('password')"
                class="absolute inset-y-0 right-0 pr-3 flex items-center"
              >
                <svg
                  class="h-5 w-5 text-gray-400"
                  fill="none"
                  viewBox="0 0 24 24"
                  stroke="currentColor"
                >
                  <path
                    v-if="showPassword"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M15 12a3 3 0 11-6 0 3 3 0 016 0z"
                  />
                  <path
                    v-if="showPassword"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z"
                  />
                  <path
                    v-else
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M13.875 18.825A10.05 10.05 0 0112 19c-4.478 0-8.268-2.943-9.543-7a9.97 9.97 0 011.563-3.029m5.858.908a3 3 0 114.243 4.243M9.878 9.878l4.242 4.242M9.88 9.88l-3.29-3.29m7.532 7.532l3.29 3.29M3 3l3.59 3.59m0 0A9.953 9.953 0 0112 5c4.478 0 8.268 2.943 9.543 7a10.025 10.025 0 01-4.132 5.411m0 0L21 21"
                  />
                </svg>
              </button>
            </div>
            <p
              v-if="passwordError"
              class="mt-2 text-sm text-red-600"
              v-html="passwordError"
            ></p>
          </div>

          <!-- 비밀번호 확인 필드 (회원가입 시에만 표시) -->
          <div v-if="isSignUp">
            <label
              for="confirmPassword"
              class="block text-sm font-medium text-gray-700"
              >비밀번호 확인</label
            >
            <div class="mt-1 relative">
              <input
                id="confirmPassword"
                name="confirmPassword"
                :type="showConfirmPassword ? 'text' : 'password'"
                required
                v-model="confirmPassword"
                class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-primary focus:border-primary sm:text-sm"
              />
              <!-- 비밀번호 확인 표시/숨김 토글 버튼 -->
              <button
                type="button"
                @click="togglePasswordVisibility('confirmPassword')"
                class="absolute inset-y-0 right-0 pr-3 flex items-center"
              >
                <svg
                  class="h-5 w-5 text-gray-400"
                  fill="none"
                  viewBox="0 0 24 24"
                  stroke="currentColor"
                >
                  <path
                    v-if="showConfirmPassword"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M15 12a3 3 0 11-6 0 3 3 0 016 0z"
                  />
                  <path
                    v-if="showConfirmPassword"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z"
                  />
                  <path
                    v-else
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M13.875 18.825A10.05 10.05 0 0112 19c-4.478 0-8.268-2.943-9.543-7a9.97 9.97 0 011.563-3.029m5.858.908a3 3 0 114.243 4.243M9.878 9.878l4.242 4.242M9.88 9.88l-3.29-3.29m7.532 7.532l3.29 3.29M3 3l3.59 3.59m0 0A9.953 9.953 0 0112 5c4.478 0 8.268 2.943 9.543 7a10.025 10.025 0 01-4.132 5.411m0 0L21 21"
                  />
                </svg>
              </button>
            </div>
            <!-- 비밀번호 일치 여부 메시지 -->
            <p v-if="!passwordMatch" class="mt-2 text-sm text-red-600">
              비밀번호가 일치하지 않습니다.
            </p>
          </div>

          <!-- 로그인 상태 유지 및 비밀번호 찾기 (로그인 시에만 표시) -->
          <div v-if="!isSignUp" class="flex items-center justify-between">
            <div class="flex items-center">
              <input
                id="remember-me"
                name="remember-me"
                type="checkbox"
                v-model="rememberMe"
                class="h-4 w-4 text-primary focus:ring-primary border-gray-300 rounded"
              />
              <label for="remember-me" class="ml-2 block text-sm text-gray-900"
                >로그인 상태 유지</label
              >
            </div>
            <div class="text-sm">
              <a href="#" class="font-medium text-primary hover:text-secondary"
                >비밀번호를 잊으셨나요?</a
              >
            </div>
          </div>

          <!-- 제출 버튼 -->
          <div>
            <button
              type="submit"
              class="w-full inline-flex justify-center py-2 px-4 border border-gray-300 rounded-md shadow-sm bg-white text-sm font-medium text-[#4ade80] hover:bg-gray-50"
            >
              {{ isSignUp ? "회원가입" : "로그인" }}
            </button>
          </div>
        </form>

        <!-- 소셜 로그인 옵션 -->
        <div class="mt-6">
          <!-- ... (소셜 로그인 버튼) ... -->
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, watch } from "vue";
import { useAuthStore } from "@/stores/auth";
import { useRouter, useRoute } from "vue-router";

const authStore = useAuthStore();
const router = useRouter();
const route = useRoute();

// 상태 변수들
const users = ref([]);
const isSignUp = ref(false);
const email = ref("");
const password = ref("");
const confirmPassword = ref("");
const rememberMe = ref(false);
const emailError = ref("");
const passwordError = ref("");
const showPassword = ref(false);
const showConfirmPassword = ref(false);
const passwordMatch = ref(true);
const emailValid = ref(false);
const passwordValid = ref(false);
const confirmPasswordValid = ref(false);

// 컴포넌트 마운트 시 실행
onMounted(() => {
  // 로컬 스토리지에서 사용자 정보 불러오기
  const storedUsers = localStorage.getItem("users");
  if (storedUsers) {
    users.value = JSON.parse(storedUsers);
  }
  // URL 쿼리 파라미터로 회원가입/로그인 모드 설정
  isSignUp.value = route.query.signup === "true";
});

// URL 쿼리 변경 감지
watch(
  () => route.query.signup,
  (newValue) => {
    isSignUp.value = newValue === "true";
  }
);

// 새 사용자 추가 함수
const addUser = (newUser) => {
  users.value.push(newUser);
  // 로컬 스토리지에 사용자 정보 저장
  localStorage.setItem("users", JSON.stringify(users.value));
};

// 로그인/회원가입 모드 전환 함수
const toggleAuthMode = () => {
  isSignUp.value = !isSignUp.value;
  // 입력 필드 초기화
  email.value = "";
  password.value = "";
  confirmPassword.value = "";
  rememberMe.value = false;
  emailError.value = "";
  passwordError.value = "";
};

// 이메일 유효성 검사 함수
const validateEmail = () => {
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailRegex.test(email.value)) {
    emailError.value = "유효한 이메일 주소를 입력해주세요.";
    return false;
  }
  const isEmailTaken = users.value.some((user) => user.email === email.value);
  if (isEmailTaken) {
    emailError.value = "이미 사용 중인 이메일 주소입니다.";
    return false;
  }
  emailError.value =
    '<span class="text-green-600">사용 가능한 이메일입니다.</span>';
  return true;
};

// 비밀번호 유효성 검사 함수
const validatePassword = () => {
  if (password.value.length < 8) {
    passwordError.value = "비밀번호는 최소 8자 이상이어야 합니다.";
    return false;
  }
  passwordError.value =
    '<span class="text-green-600">사용할 수 있는 비밀번호입니다.</span>';
  return true;
};

// 비밀번호 일치 여부 실시간 확인
watch([password, confirmPassword], ([newPassword, newConfirmPassword]) => {
  if (isSignUp.value) {
    passwordMatch.value = newPassword === newConfirmPassword;
  }
});

// 폼 제출 처리 함수
const handleSubmit = async () => {
  if (isSignUp.value) {
    if (
      !validateEmail() ||
      !validatePassword() ||
      !confirmPasswordValid.value
    ) {
      return;
    }
    // 회원가입 로직
    const newUser = { email: email.value, password: password.value };
    addUser(newUser);
    alert("회원가입이 완료되었습니다.");
    toggleAuthMode();
  } else {
    // 로그인 로직
    const result = await authStore.login(email.value, password.value);
    if (result.success) {
      router.push("/");
    } else {
      alert(result.message);
    }
  }
};

// 비밀번호 표시/숨김 토글 함수
const togglePasswordVisibility = (field) => {
  if (field === "password") {
    showPassword.value = !showPassword.value;
  } else if (field === "confirmPassword") {
    showConfirmPassword.value = !showConfirmPassword.value;
  }
};
</script>

<style scoped>
.text-red-600 {
  color: #dc2626;
}
</style>
