<template>
  <header class="bg-white shadow-sm">
    <div class="container mx-auto px-4 py-3">
      <div class="flex justify-between items-center">
        <img
          src="/icons/piccup-logo-white.png"
          alt="PICCUP"
          class="h-8 w-auto cursor-pointer"
          @click="navigateHome"
        />

        <nav class="hidden md:flex space-x-6">
          <router-link
            v-for="item in navItems"
            :key="item"
            :to="getRouteForItem(item)"
            class="text-gray-700 hover:text-primary transition-colors text-lg font-medium"
          >
            {{ item }}
          </router-link>
        </nav>

        <div class="flex items-center space-x-4">
          <button
            v-if="!authStore.isLoggedIn"
            @click="navigateToAuth(true)"
            class="btn btn-primary"
          >
            회원가입
          </button>
          <button
            v-if="!authStore.isLoggedIn"
            @click="navigateToAuth(false)"
            class="btn btn-outline"
          >
            로그인
          </button>
          <button v-else @click="handleLogout" class="btn btn-outline">
            로그아웃
          </button>
        </div>
      </div>
    </div>
  </header>
</template>

<script setup>
import { onMounted } from "vue";
import { useRouter } from "vue-router";
import { useAuthStore } from "@/stores/auth";

const router = useRouter();
const authStore = useAuthStore();

const navItems = ["홈", "이력서", "자기소개서 작성", "자기소개서 목록"];

const navigateHome = () => {
  router.push("/");
};

const navigateToAuth = (isSignUp) => {
  router.push({ path: "/auth", query: { signup: isSignUp } });
};

const getRouteForItem = (item) => {
  switch (item) {
    case "이력서":
      return "/resume";
    case "홈":
      return "/";
    case "자기소개서 작성":
      return "/cover-letter";
    case "자기소개서 목록":
      return "/board";
    default:
      return "#" + item;
  }
};

const handleLogout = () => {
  authStore.logout();
  router.push("/");
};

onMounted(() => {
  authStore.checkAuth();
});
</script>

<style scoped>
.btn {
  padding: 0.5rem 1.25rem;
  border-radius: 0.375rem;
  font-weight: 600;
  transition: all 0.2s;
  font-size: 1rem;
}

.btn-outline {
  border: 2px solid #006b40;
  color: #006b40;
}

.btn-outline:hover {
  background-color: #006b40;
  color: white;
}

.btn-primary {
  background-color: #006b40;
  color: white;
}

.btn-primary:hover {
  background-color: #005030;
}
</style>
