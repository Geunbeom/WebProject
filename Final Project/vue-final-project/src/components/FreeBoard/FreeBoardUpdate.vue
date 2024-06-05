<template>
    <div class="detail">
        <span>제목</span>
        <input type="text" v-model="store.freeBoard.title">
    </div>
    <br>
    <p class="content" style="margin-top: 50px;">내용<input type="text" v-model="store.freeBoard.content"></p>
    <div class="buttons">
        <button @click="store.updateBoard()" class="bt-regist">등록</button>
        <button @click="router.push(`${store.freeBoard.id}`)" class="bt-cancle">취소</button>
    </div>
</template>

  
<script setup>
import {useFreeBoardStore} from '@/stores/freeBoard'
import {useUserStore} from '@/stores/User'
import {useRouter} from 'vue-router';

const router = useRouter();
const store = useFreeBoardStore();
const userStore = useUserStore();

</script>

<style scoped>
@import '@/assets/Create.css';
</style>