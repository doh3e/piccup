<template>

  <div class="min-h-screen flex flex-col bg-gray-50">
    <Header />
    <main class="flex-grow mt-12">
      <router-view></router-view>
    </main>
  </div>
</template>

<script setup>
import { RouterView } from 'vue-router'
import Header from '@/components/Main/Header.vue'
</script>

<style>

@layer base {
  :root {
    --bg-color: #F8F8F8;
    --text-color: #1F1F1F;
    --primary: #006B40;
    --primary-foreground: #FFFFFF;
    --secondary: #8CD196;
    --secondary-foreground: #1F1F1F;
    --accent: #E6FF94;
    --accent-foreground: #1F1F1F;
    --highlight: #FFDCDC;
  }
}

@layer components {
  .btn-auth {
    @apply w-full flex justify-center py-3 px-6 rounded-md shadow-lg text-base font-bold;
    background-color: var(--primary);
    color: var(--primary-foreground);
    transition: all 0.3s ease;
  }

  .btn-auth:hover {
    background-color: var(--secondary);
    color: var(--secondary-foreground);
    transform: translateY(-2px);
    box-shadow: 0 4px 6px -1px rgba(0, 107, 64, 0.2), 0 2px 4px -1px rgba(0, 107, 64, 0.1);
  }
}

.dot-pattern {
  position: relative;
  overflow: hidden;
}

.dot-pattern::before {
  content: '';
  position: absolute;
  width: 200%;
  height: 200%;
  top: -50%;
  left: -50%;
  background-image: radial-gradient(circle, #4ade80 2px, transparent 2px);
  background-size: 30px 30px;
  opacity: 0.1;
  z-index: 0;
}

.dot-pattern > * {
  position: relative;
  z-index: 1;
}
</style>

