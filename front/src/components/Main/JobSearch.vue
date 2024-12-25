<template>
  <section class="py-16 bg-white">
    <div class="container mx-auto px-4 sm:px-6 lg:px-8">
      <h2 class="text-3xl font-bold mb-8 text-center text-primary">채용정보 찾기</h2>
      <div class="max-w-3xl mx-auto">
        <div class="flex flex-wrap gap-4">
          <input type="text" placeholder="직무, 회사, 키워드" class="flex-grow p-3 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-primary">
          <input type="text" placeholder="지역" class="w-full sm:w-1/3 p-3 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-primary">
          <button class="w-full sm:w-auto btn btn-primary">검색</button>
        </div>
      </div>
    </div>
  </section>
</template>

<style scoped>
.btn-primary {
  background-color: var(--primary-color);
  color: white;
  padding: 0.75rem 1.5rem;
  font-size: 1rem;
  border-radius: 0.375rem;
  font-weight: bold;
  transition: all 0.2s;
}

.btn-primary:hover {
  background-color: var(--secondary-color);
}
</style>

