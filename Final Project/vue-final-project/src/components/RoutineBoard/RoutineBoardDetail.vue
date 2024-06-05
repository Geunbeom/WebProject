<template>
    <div class="detail">
        <td style="width: 65%;"><span style="font-weight: 1000; font-size: 18px;">제목 |</span> {{ store.routineBoard.title }}</td>
        <td style="width: 12%;"><span style="font-weight: 1000; font-size: 18px;">작성자 |</span> {{ store.routineBoard.writer }}</td>
        <td style="width: 15%;"><span style="font-weight: 1000; font-size: 18px;">작성일 |</span> {{ store.routineBoard.regDate }}</td>
        <td style="width: 8%;"><span style="font-weight: 1000; font-size: 18px;">조회수 |</span> {{ store.routineBoard.viewCnt }}</td>
    </div>
    <div class="detail-tool1">
        <div class="detail-muscle">
            <MuscleSel :index="partNum"/>
        </div>
        <div class="detail-tool2">
            <h3 style="font-weight: 1000;">Routine</h3>
            <div style="border: 1px solid rgba(0, 0, 0, 0.253); width: 200px; margin: 20px auto;">
                <p><span style="font-weight: 1000;">운동 부위</span> : {{ store.routineDetail.part }}</p>
                <p><span style="font-weight: 1000;">운동 종목</span> : {{ store.routineDetail.detail }}</p>
                <p><span style="font-weight: 1000;">세트 반복</span> : {{ store.routineDetail.sets }}</p>
                <p><span style="font-weight: 1000;">세트당 횟수</span> : {{ store.routineDetail.count }}</p>
            </div>
            <button @click="myRoutineStore.saveMyRoutine(store.routineDetail.id)" v-if="check">루틴 저장하기</button>
            <button v-else disabled>루틴 저장하기</button>
        </div>
    </div>
    <p class="content">{{ store.routineBoard.content }}</p>
    <div style="display: flex; justify-content: center; font-size: 20px;">
        <div style="width:30px; cursor:pointer;">
            <p v-if="!likeStore.check" @click="likeStore.addLike(route.params.id)">🤍</p>
            <p v-else @click="likeStore.unLike(route.params.id)">💗</p>
        </div>
        <p>추천 수 : {{ likeStore.countLike }}</p>
    </div>
    <div v-if="store.routineBoard.writer === userStore.loginUser.nickName" class="update">
        <button class="bt-list" @click="router.push({name: 'routineBoardList'})">목록</button>
        <button @click="router.push({name: 'routineBoardUpdate'})" class="bt-up">수정</button>
        <button @click="store.deleteBoard(route.params.id)" class="bt-del">삭제</button>
    </div>
    <div v-else class="no-update">
        <button class="bt-list" @click="router.push({name: 'routineBoardList'})">목록</button>
    </div>

    <RoutineBoardReplyList class="reply"/>
</template>
  
<script setup>
import MuscleSel from '@/components/User/MuscleSelected.vue';
import {useRoutineBoardStore} from '@/stores/routineBoard';
import {useUserStore} from '@/stores/User';
import {useLikeStore} from '@/stores/Routine';
import {useMyRoutineStore} from '@/stores/MyRoutine';
import { onMounted, computed } from 'vue';
import {useRoute, useRouter} from 'vue-router';
import RoutineBoardReplyList from './RoutineBoardReplyList.vue';

const route = useRoute();
const router = useRouter();
const userStore = useUserStore();
const store = useRoutineBoardStore();
const likeStore = useLikeStore();
const myRoutineStore = useMyRoutineStore();
const check = computed(() => {
    if (sessionStorage.getItem('loginUser'))
        return true;
    return false;
})

onMounted(() => {
    store.getRoutineBoard(route.params.id);
    likeStore.getLikeList(route.params.id);
    if(sessionStorage.getItem('loginUser')) {
        likeStore.getCheck(route.params.id);
    }
})

const partNum = computed(() => {
    if(store.routineDetail.part === "어깨") {
        return 2;
    }else if (store.routineDetail.part === "팔") {
        return 3;
    }else if (store.routineDetail.part === "전완근") {
        return 4;
    }else if (store.routineDetail.part === "가슴") {
        return 5;
    }else if (store.routineDetail.part === "등") {
        return 6;
    }else if (store.routineDetail.part === "복근") {
        return 7;
    }else if (store.routineDetail.part === "하체") {
        return 8;
    }else {
        return 1;
    }
})


</script>
<style scoped>
@import '@/assets/Detail.css';
</style>