<template>
  <div>
    <div class="search">
      <div class="searchs">
        <select class="form" v-model="searchForm.key">
            <option value="title">제목</option>
            <option value="writer">글쓴이</option>
            <option value="content">내용</option>
        </select>
        <input style="height: 24px;" type="text" v-model="searchForm.word"/>
        <button @click="search">검색</button>
    </div>
      <button @click="regist()" style="width: 90px; height: 33px;">📝 글쓰기</button>
    </div>
    <table>
      <tr style="background-color: rgba(102, 102, 102, 0.075);">
        <th style="width: 70px;">번호</th>
        <th style="width: 700px;">제목</th>
        <th style="width: 150px;">작성자</th>
        <th style="cursor: pointer; width: 150px;" @click="orderDate()">{{ textDate }}</th>
        <th style="cursor: pointer; width: 70px;" @click="orderView()">{{ textView }}</th>
      </tr>
      <tr class="detail" v-for="(freeBoard, index) in store.freeBoardList" :key="freeBoard.id" @click="detailFreeBoard(freeBoard.id)" style="cursor: pointer;" v-show="Math.ceil((index+1)/10) == pageNum">
        <td style="background-color: rgba(102, 102, 102, 0.075);">{{  index+1  }}</td>
        <td>{{ freeBoard.title }}</td>
        <td>{{ freeBoard.writer }}</td>
        <td>{{ freeBoard.regDate }}</td>
        <td>{{ freeBoard.viewCnt }}</td>
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

</template>

<script setup>
import {useFreeBoardStore} from '@/stores/freeBoard';
import {onMounted, ref, computed} from 'vue';
import {RouterLink, useRouter} from 'vue-router';

const router = useRouter()
const store = useFreeBoardStore()
onMounted(() => {
  store.getFreeBoardList()
})

// 페이지 배열
const array = computed(() => {
  return Array.from({length:maxPageNum.value}, (v,i)=>i+1)
});

// 페이지 정보
const pageNum = ref(1)
const maxPageNum = computed(() => {
  return Math.ceil(store.freeBoardList.length/10)
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

// 상세보기 페이지로
const detailFreeBoard = function(boardId) {
  router.push({name: 'freeBoardDetail', params:{id: boardId}})
}

// 글 둥록
const regist = function() {
  router.push({name: 'freeBoardCreate'})
}

// 정렬 조건 변경
const viewDir = ref(0)
const textView = ref('조회수')
const dateDir = ref(0)
const textDate = ref('작성일')

const orderView = function() {
  viewDir.value = (viewDir.value+1)%3
  dateDir.value = 0

  if(viewDir.value==0) {
    searchForm.value.orderBy = 'id'
    searchForm.value.orderDir = 'desc'
  }
  else if(viewDir.value==1) {
    searchForm.value.orderBy = 'view_cnt'
    searchForm.value.orderDir = 'desc'
  }
  else if(viewDir.value==2) {
    searchForm.value.orderBy = 'view_cnt'
    searchForm.value.orderDir = 'asc'
  }
  search()
  reset()
}

const orderDate = function() {
  dateDir.value = (dateDir.value+1)%3
  viewDir.value = 0
  
  if(dateDir.value==0) {
    searchForm.value.orderBy = 'id'
    searchForm.value.orderDir = 'desc'
  }
  else if(dateDir.value==1) {
    searchForm.value.orderBy = 'id'
    searchForm.value.orderDir = 'desc'
  }
  else if(dateDir.value==2) {
    searchForm.value.orderBy = 'id'
    searchForm.value.orderDir = 'asc'
  }
  search()
  reset()
}

// 검색조건 폼
const searchForm = ref({
  key: 'title',
  word: '',
  orderBy: 'id',
  orderDir: 'desc'
})

// 검색버튼
const search = function(){
  store.searchBoard(searchForm.value)
}

// 정렬조건 초기화
const reset = function() {
  if(viewDir.value==0) textView.value = '조회수'
  else if(viewDir.value==1) textView.value = '조회수▼'
  else if(viewDir.value==2) textView.value = '조회수▲'
  if(dateDir.value==0) textDate.value = '작성일'
  else if(dateDir.value==1) textDate.value = '작성일▼'
  else if(dateDir.value==2) textDate.value = '작성일▲'
}

</script>

<style scoped>
@import '@/assets/Board.css';

</style>