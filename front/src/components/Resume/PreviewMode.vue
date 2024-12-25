<template>
    <div class="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50">
      <div class="bg-white p-8 rounded-lg max-w-4xl w-full max-h-[90vh] overflow-y-auto">
        <h2 class="text-3xl font-bold text-[#006B40] mb-6">Resume Preview</h2>
        <div class="space-y-6">
          <section>
            <h3 class="text-2xl font-bold text-[#1F1F1F] mb-2">Personal Information</h3>
            <p><strong>Name:</strong> {{ resumeData.personalInfo.name }}</p>
            <p><strong>Email:</strong> {{ resumeData.personalInfo.email }}</p>
            <p><strong>Phone:</strong> {{ resumeData.personalInfo.phone }}</p>
          </section>
          <section>
            <h3 class="text-2xl font-bold text-[#1F1F1F] mb-2">Desired Job</h3>
            <p>{{ resumeData.desiredJob }}</p>
          </section>
          <section>
            <h3 class="text-2xl font-bold text-[#1F1F1F] mb-2">Skills</h3>
            <ul class="list-disc list-inside">
              <li v-for="skill in resumeData.skills" :key="skill">{{ skill }}</li>
            </ul>
          </section>
          <!-- Add more sections as needed -->
        </div>
        <button
          @click="$emit('close')"
          class="mt-6 px-4 py-2 bg-[#006B40] text-white rounded hover:bg-opacity-90 transition"
        >
          Close Preview
        </button>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      resumeData: Object
    },
    emits: ['close']
  }
  </script>