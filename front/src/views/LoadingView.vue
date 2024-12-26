<template>
  <div class="fixed inset-0 z-50 flex flex-col items-center justify-center bg-primary" style="min-height: 100vh; min-width: 100vw;">
    <div class="tetris-container">
      <div v-for="(row, rowIndex) in tetrisGrid" :key="rowIndex" class="tetris-row">
        <div v-for="(cell, cellIndex) in row" :key="cellIndex" :class="['tetris-cell', { 'active': cell, 'disappearing': isDisappearing }]"></div>
      </div>
    </div>
    <div class="loading-text mt-8">
      <span v-for="(letter, index) in 'PICCUP'" 
            :key="index"
            :style="{ animationDelay: `${index * 300}ms` }"
            class="inline-block animate-fade-in text-4xl md:text-6xl font-black text-accent">
        {{ letter }}
      </span>
    </div>
    <p class="mt-4 text-secondary text-xl">
      당신의 역량을 PICCUP하는 중{{ dots }}
    </p>
  </div>
</template>

<script setup>
import { ref, onMounted, onUnmounted } from 'vue';

const tetrisGrid = ref(Array(20).fill().map(() => Array(10).fill(false)));
const currentPiece = ref({ x: 0, y: 0, shape: [[1], [1], [1], [1]] });
const interval = ref(null);
const isDisappearing = ref(false);
const dots = ref("");
const typingInterval = ref(null);

const animateDots = () => {
  let count = 0;
  typingInterval.value = setInterval(() => {
    dots.value = '.'.repeat(count);
    count = (count + 1) % 4;
  }, 500);
};

const findEmptyColumn = () => {
  return tetrisGrid.value[19].findIndex(cell => !cell);
};

const createPiece = () => {
  currentPiece.value = { 
    x: Math.floor(Math.random() * 10), 
    y: 0, 
    shape: [[1], [1], [1], [1]] 
  };
};

const updateGrid = () => {
  const newGrid = Array(20).fill().map(() => Array(10).fill(false));
  
  for (let y = 16; y < 20; y++) {
    for (let x = 0; x < 10; x++) {
      newGrid[y][x] = tetrisGrid.value[y][x];
    }
  }

  for (let y = 0; y < currentPiece.value.shape.length; y++) {
    const pieceY = Math.floor(currentPiece.value.y) + y;
    if (pieceY >= 0 && pieceY < 20) {
      newGrid[pieceY][currentPiece.value.x] = true;
    }
  }

  tetrisGrid.value = newGrid;
};

const movePiece = () => {
  const emptyColumn = findEmptyColumn();
  
  if (currentPiece.value.x !== emptyColumn && currentPiece.value.y % 1 === 0) {
    currentPiece.value.x += Math.sign(emptyColumn - currentPiece.value.x);
  }

  if (currentPiece.value.y < 16) {
    currentPiece.value.y++;
  } else {
    createPiece();
  }

  updateGrid();

  if (tetrisGrid.value[19].every(cell => cell)) {
    clearInterval(interval.value);
    disappearAnimation();
  }
};

const disappearAnimation = () => {
  isDisappearing.value = true;
  clearInterval(typingInterval.value);
  setTimeout(() => {
    tetrisGrid.value = Array(20).fill().map(() => Array(10).fill(false));
    isDisappearing.value = false;
  }, 1000);
};

onMounted(() => {
  tetrisGrid.value = Array(16).fill().map(() => Array(10).fill(false))
    .concat(Array(4).fill().map(() => Array(10).fill(true)));
  
  const emptyColumn = Math.floor(Math.random() * 10);
  for (let y = 16; y < 20; y++) {
    tetrisGrid.value[y][emptyColumn] = false;
  }

  createPiece();
  animateDots();
  interval.value = setInterval(movePiece, 150);
});

onUnmounted(() => {
  clearInterval(interval.value);
  clearInterval(typingInterval.value);
});
</script>


<style scoped>
.tetris-container {
  width: 200px;
  height: 400px;
  display: flex;
  flex-direction: column;
  border: 4px solid #8CD196;
}

.tetris-row {
  display: flex;
}

.tetris-cell {
  width: 20px;
  height: 20px;
  border: 1px solid #006B40;
  transition: background-color 0.5s;
}

.tetris-cell.active {
  background-color: #E6FF94;
}

.tetris-cell.disappearing {
  animation: disappear 1s;
}

@keyframes disappear {
  0% { opacity: 1; }
  100% { opacity: 0; }
}

.loading-text {
  color: #E6FF94;
}

.animate-fade-in {
  animation: fadeInOut 2s ease-in-out infinite;
}

@keyframes fadeInOut {
  0%, 100% { opacity: 0; transform: translateY(10px); }
  50% { opacity: 1; transform: translateY(0); }
}

.bg-primary {
  background-color: #F8F8F8;
}

.text-accent {
  color: #8CD196;
}

.text-secondary {
  color: #006B40;
}

.typing-text {
  white-space: pre;
}

.complete-text {
  animation: bounceIn 0.5s ease-out;
  color: #006B40;
  font-weight: bold;
}

@keyframes bounceIn {
  0% {
    transform: scale(0);
    opacity: 0;
  }
  50% {
    transform: scale(1.2);
  }
  100% {
    transform: scale(1);
    opacity: 1;
  }
}

.hidden {
  display: none;
}
</style>
