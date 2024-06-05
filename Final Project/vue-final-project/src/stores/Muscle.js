import { ref, computed } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';
import router from '@/router';

export const useMuscleStore = defineStore('muscle', () => {

  const partNum = ref(1);
  const part = computed(() => {
    if(partNum.value == 2) {
      return '어깨';
    }else if(partNum.value == 3) {
      return '팔'
    }else if(partNum.value == 4) {
      return '전완근'
    }else if(partNum.value == 5) {
      return '가슴'
    }else if(partNum.value == 6) {
      return '등'
    }else if(partNum.value == 7) {
      return '복근'
    }else if(partNum.value == 8) {
      return '하체'
    }else {
      return null
    }
  })


  return {
    partNum,
    part
  }
})