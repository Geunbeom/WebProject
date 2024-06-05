<template>
    <div class="detail">
        <td style="width: 65%;"><span style="font-weight: 1000; font-size: 18px;">제목 |</span> {{ store.freeBoard.title }}</td>
        <td style="width: 12%;"><span style="font-weight: 1000; font-size: 18px;">작성자 |</span> {{ store.freeBoard.writer }}</td>
        <td style="width: 15%;"><span style="font-weight: 1000; font-size: 18px;">작성일 |</span> {{ store.freeBoard.regDate }}</td>
        <td style="width: 8%;"><span style="font-weight: 1000; font-size: 18px;">조회수 |</span> {{ store.freeBoard.viewCnt }}</td>
    </div>
    <p class="content">{{ store.freeBoard.content }}</p>
    <div v-if="store.freeBoard.writer === userStore.loginUser.nickName" class="update">
        <button class="bt-list" @click="router.push({name: 'freeBoardList'})">목록</button>
        <button @click="router.push({name: 'freeBoardUpdate'})" class="bt-up">수정</button>
        <button @click="store.deleteBoard(route.params.id)" class="bt-del">삭제</button>
    </div>
    <div v-else class="no-update">
        <button class="bt-list" @click="router.push({name: 'freeBoardList'})">목록</button>
    </div>

    <FreeBoardReplyList class="reply"/>
</template>
  
<script setup>
import {useFreeBoardStore} from '@/stores/freeBoard'
import {useUserStore} from '@/stores/User'
import { onMounted } from 'vue'
import {useRoute, useRouter} from 'vue-router'
import FreeBoardReplyList from './FreeBoardReplyList.vue';

const route = useRoute()
const router = useRouter()
const userStore = useUserStore()

const store = useFreeBoardStore()
onMounted(() => {
    store.getFreeBoard(route.params.id)
})

</script>

<style scoped>
@import '@/assets/Detail.css';

</style>