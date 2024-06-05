<template>
  <div style="margin-top: 70px;">
    <h3 style="font-size: 24px; margin-left: 5%">댓글</h3>
      <table class="reply-table">
        <tr>
          <th style="font-weight: 1000; width: 170px; padding: 10px 0px; text-align: start; border-bottom: 1px solid rgba(0, 0, 0, 0.13);">작성자</th>
          <th style="font-weight: 1000; width: 1000px; padding: 10px 0px; text-align: start; border-bottom: 1px solid rgba(0, 0, 0, 0.13);">내용</th>
          <th style="font-weight: 1000; width: 70px; padding: 10px 0px; text-align: start; border-bottom: 1px solid rgba(0, 0, 0, 0.13);">작성일</th>
          <th style="font-weight: 1000; width: 50px; text-align: start;"></th>
          <th style="font-weight: 1000; width: 50px; text-align: start;"></th>
        </tr>
        <tr v-for="(replys, index) in store.routineBoardReplyList" :key="replys.id" v-show="Math.ceil((index+1)/10) == pageNum" class="reply-detail">
          <td style="border-bottom: 1px solid rgba(0, 0, 0, 0.13); text-align: start;">{{ replys.writer }}</td>
          <td style="border-bottom: 1px solid rgba(0, 0, 0, 0.13); text-align: start;" v-if="index !== isUpdate">{{ replys.content }}</td>
          <td style="border-bottom: 1px solid rgba(0, 0, 0, 0.13); text-align: start;" v-else><input type="text" v-model="replys.content" style="width: 90%; height: 20px; font-size: 15px;"></td>
          <td style="border-bottom: 1px solid rgba(0, 0, 0, 0.13); text-align: start;">{{ replys.regDate }}</td>
          <td v-show="replys.writer === userStore.loginUser.nickName" v-if="index !== isUpdate" style="width: 40px;"><button class="re-bt-up" @click="isUpdate = index">수정</button></td>
          <td v-show="replys.writer === userStore.loginUser.nickName" v-else style="width: 40px;"><button class="re-bt-up" @click="store.updateReply(replys)">수정</button></td>
          <td v-show="replys.writer === userStore.loginUser.nickName" v-if="index !== isUpdate" style="width: 40px;"><button class="re-bt-del" @click="store.deleteReply(replys.replyId)">삭제</button></td>
          <td v-show="replys.writer === userStore.loginUser.nickName" v-else style="width: 40px;"><button class="re-bt-del" @click="cancle()">취소</button></td>
        </tr>
      </table>
      <p v-if="!store.routineBoardReplyList.length" style="color:rgba(0, 0, 0, 0.452); margin: 20px 40px; padding-bottom: 20px; border-bottom: 1px solid rgba(0, 0, 0, 0.13);">
        작성된 댓글이 없습니다.
      </p>
      <div class="page">
        <button @click="downDoublePage()">&lt;&lt;</button>
        <button @click="downPage()" style="margin-right: 3px;">&lt;</button>
        <span v-for="num in array" :class="{bold : num === pageNum}" @click="pageNum = num" style="cursor: pointer; margin: 5px;" v-show="Math.ceil(num/10) === Math.ceil(pageNum/10)">{{ num }}</span>
        <button @click="upPage()" style="margin-left: 3px;">&gt;</button>
        <button @click="upDoublePage()">&gt;&gt;</button>
      </div>
      <div id="createForm" v-show="userStore.loginUser.nickName">
        <th style="width: 1200px; padding: 0px 0px 0px 3%; text-align: start;">댓글 작성</th>
          <input type="text" v-model="reply.content" class="reply-content">
          <button @click="store.createReply(route.params.id, reply)">등록</button>
      </div>
    </div>
  
</template>

<script setup>
import {useRoutineBoardReplyStore} from '@/stores/routineBoardReply'
import {useUserStore} from '@/stores/User'
import {onMounted, ref, computed} from 'vue'
import {useRouter, useRoute} from 'vue-router'

const store = useRoutineBoardReplyStore()
const userStore = useUserStore()
const router = useRouter()
const route = useRoute()
const isUpdate = ref(-1);

// 페이지 배열
const array = computed(() => {
  return Array.from({length:maxPageNum.value}, (v,i)=>i+1)
});

// 페이지 정보
const pageNum = ref(1)
const maxPageNum = computed(() => {
  return Math.ceil(store.routineBoardReplyList.length/10)
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

const cancle = function() {
  isUpdate.value = !isUpdate.value;
  router.go(router.currentRoute);
}

onMounted(() => {
store.getRoutineBoardReplyList(route.params.id)
})

const reply = ref({
  writer: userStore.loginUser.nickName
})

</script>

<style scoped>
@import '@/assets/Detail.css';
</style>