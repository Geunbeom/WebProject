<template>
  <h2>내 루틴</h2>
  <div v-if="store.myRoutineList.length != 0">
      <table style="margin: 50px auto; text-align: center;">
          <tr style="background-color: rgba(102, 102, 102, 0.075);">
              <th style="width: 100px;">번호</th>
              <th style="width: 100px;">운동 부위</th>
              <th style="width: 100px;">운동 종목</th>
              <th style="width: 100px;">세트 횟수</th>
              <th style="width: 100px;">셋트 당 횟수</th>
          </tr>
          <tr v-for="(routine, index) in store.myRoutineList" :key="routine.id" v-show="Math.ceil((index+1)/10) == pageNum">
              <td style="background-color: rgba(102, 102, 102, 0.075);">{{  index+1  }}</td>
              <td>{{ routine.part }}</td>
              <td>{{ routine.detail }}</td>
              <td>{{ routine.sets }}</td>
              <td>{{ routine.count }}</td>
              <button class="bt-up" @click="store.loadRoutine(routine)" style="margin-left: 5px;">출석</button>
              <button class="bt-del" @click="store.deleteRoutine(routine.id)">삭제</button>
          </tr>
      </table>
      <div class="page">
        <button @click="downDoublePage()">&lt;&lt;</button>
        <button @click="downPage()" style="margin-right: 3px;">&lt;</button>
        <span v-for="num in array" :class="{bold : num === pageNum}" @click="pageNum = num" style="cursor: pointer; margin: 5px;" v-show="Math.ceil(num/10) === Math.ceil(pageNum/10)">{{ num }}</span>
        <button @click="upPage()" style="margin-left: 3px;">&gt;</button>
        <button @click="upDoublePage()">&gt;&gt;</button>
      </div>
    </div>
    <div v-else>
      <p style="color:rgba(0, 0, 0, 0.452); font-size: 18px;">아직  저장된 루틴이 없습니다</p>
    </div>
    <button class="bt-regist" @click="store.check = true">루틴 등록하기</button>
    <MyRoutineRegist v-if="store.check"/>
</template>

<script setup>
import MyRoutineRegist from './MyRoutineRegist.vue';
import {useMyRoutineStore} from '@/stores/MyRoutine';
import {ref, computed, onMounted} from 'vue';

onMounted(() => {
  store.getMyRoutineList()
  store.getAttend()
})

const store = useMyRoutineStore();


// 페이지 배열
const array = computed(() => {
return Array.from({length:maxPageNum.value}, (v,i)=>i+1)
});

// 페이지 정보
const pageNum = ref(1)
const maxPageNum = computed(() => {
return Math.ceil(store.myRoutineList.length/10)
});

// 한 칸 전으로
const downPage = function() {
if(pageNum.value > 1) {
  pageNum.value--;
}
}

// 10 칸 전으로
const downDoublePage = function() {
if(pageNum.value > 10) {
  pageNum.value = Math.floor(pageNum.value/10)*10;
}else {
  pageNum.value = 1;
}
}

// 한 칸 앞으로
const upPage = function() {
if(pageNum.value < maxPageNum.value) {
  pageNum.value++;
}
}

// 10 칸 앞으로
const upDoublePage = function() {
if(pageNum.value < Math.floor(maxPageNum.value/10)*10+1) {
  pageNum.value = Math.ceil(pageNum.value/10)*10+1;
}else {
  pageNum.value = maxPageNum.value;
}
}
</script>

<style scoped>
@import '@/assets/MyBoard.css';
</style>