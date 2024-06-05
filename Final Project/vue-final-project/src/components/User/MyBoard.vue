<template>
  <h2>좋아요 누른 글</h2>
  <div v-if="store.myBoard.length != 0">
      <table style="margin: 50px auto; text-align: center;">
          <tr style="background-color: rgba(102, 102, 102, 0.075);">
              <th style="width: 50px;">번호</th>
              <th style="width: 300px;">제목</th>
              <th style="width: 120px;">작성자</th>
              <th style="width: 120px;">작성일</th>
              <th style="width: 50px;">추천수</th>
              <th style="width: 50px;">조회수</th>
          </tr>
          <tr class="detail" v-for="(board, index) in store.myBoard" :key="board.id" @click="router.push({name:'routineBoardDetail', params:{id: board.id}})" v-show="Math.ceil((index+1)/10) == pageNum">
              <td style="background-color: rgba(102, 102, 102, 0.075);">{{  index+1  }}</td>
              <td>{{ board.title }}</td>
              <td>{{ board.writer }}</td>
              <td>{{ board.regDate }}</td>
              <td>{{ board.like }}</td>
              <td>{{ board.viewCnt }}</td>
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
      <p style="color:rgba(0, 0, 0, 0.452); font-size: 18px;">아직 좋아요 누른 글이 없습니다</p>
  </div>
</template>

<script setup>
import { useLikeStore } from '@/stores/Routine';
import {onMounted, ref, computed} from 'vue'
import {useRouter} from 'vue-router'

const router = useRouter();
const store = useLikeStore();

onMounted(() => {
  store.getMyBoard();
})


// 페이지 배열
const array = computed(() => {
return Array.from({length:maxPageNum.value}, (v,i)=>i+1)
});

// 페이지 정보
const pageNum = ref(1)
const maxPageNum = computed(() => {
return Math.ceil(store.myBoard.length/10)
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