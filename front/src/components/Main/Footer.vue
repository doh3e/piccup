<template>
  <footer class="bg-gray-900 text-white py-12">
    <div class="container mx-auto px-4 sm:px-6 lg:px-8">
      <div class="grid grid-cols-1 md:grid-cols-4 gap-8">
        <div>
          <img src="/icons/piccup-logo-white.png" alt="PICCUP" class="h-8 w-auto mb-4" />
          <p class="text-sm text-gray-400">&copy; 2023 PICCUP. All rights reserved.</p>
        </div>
        <div>
          <h4 class="text-lg font-bold mb-4">서비스</h4>
          <ul class="space-y-2">
            <li><router-link to="/resume" class="text-gray-400 hover:text-white transition-colors">이력서</router-link></li>
            <li><a href="#" class="text-gray-400 hover:text-white transition-colors">자기소개서 작성</a></li>
            <li><a href="#" class="text-gray-400 hover:text-white transition-colors">기업 리뷰</a></li>
            <li><a href="#" class="text-gray-400 hover:text-white transition-colors">커리어 성장</a></li>
          </ul>
        </div>
        <div>
          <h4 class="text-lg font-bold mb-4">도움이 필요하세요?</h4>
          <ul class="space-y-2">
            <li><router-link to="/FAQ" class="text-gray-400 hover:text-white transition-colors">고객센터</router-link></li>
          </ul>
        </div>
        <div>
          <h4 class="text-lg font-bold mb-4">소셜 미디어</h4>
          <div class="flex space-x-4">
            <a href="#" class="text-gray-400 hover:text-white transition-colors">
              <img src="/icons/facebook.png" alt="Facebook" class="h-6 w-6" />
            </a>
            <a href="#" class="text-gray-400 hover:text-white transition-colors">
              <img src="/icons/twitter.png" alt="Twitter" class="h-6 w-6" />
            </a>
            <a href="#" class="text-gray-400 hover:text-white transition-colors">
              <img src="/icons/instagram.png" alt="Instagram" class="h-6 w-6" />
            </a>
            <a href="#" class="text-gray-400 hover:text-white transition-colors">
              <img src="/icons/linkedin.png" alt="LinkedIn" class="h-6 w-6" />
            </a>
          </div>
        </div>
      </div>
    </div>
  </footer>
</template>

<script setup>
// setup script will remain unchanged in this quick edit
</script>

<style>
/* existing style will remain unchanged in this quick edit*/
</style>
