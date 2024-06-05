<template>
    <div class="detail">
        <span>제목</span>
        <input type="text" v-model="freeBoard.title">
    </div>
    <br>
    <p class="content" style="margin-top: 50px;">내용<input type="text" v-model="freeBoard.content"><span style="margin-left:90%; font-size: 12px;">&nbsp;&nbsp;{{freeBoard.content.length}}/1000</span></p>
    <div class="buttons">
        <button @click="store.createBoard(freeBoard)" class="bt-regist">등록</button>
        <button @click="router.push({name:'freeBoardList'})" class="bt-cancle">취소</button>
    </div>
</template>
  
<script setup>
import { useFreeBoardStore } from '@/stores/freeBoard'
import {useUserStore} from '@/stores/User'
import { useRouter } from 'vue-router';
import { ref } from 'vue'

const userStore = useUserStore()
const router = useRouter()
const store = useFreeBoardStore()
const freeBoard = ref({
    writer: userStore.loginUser.nickName,
    content: ''
})


</script>

<style scoped>
@import '@/assets/Create.css';
</style>