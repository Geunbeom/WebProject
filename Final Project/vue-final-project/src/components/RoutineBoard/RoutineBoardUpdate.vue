<template>
    <div class="detail">
        <span>제목</span>
        <input type="text" v-model="store.routineBoard.title">
    </div>
    <div style="border: 1px solid rgba(0, 0, 0, 0.233); padding: 20px; width: 300px; text-align: center; margin: 50px auto;">
        <h3>루틴</h3>
        <div style="border: 1px solid rgba(0, 0, 0, 0.233); width: 250px; margin: 20px auto;">
            <p><span style="font-weight: 1000;">운동 부위</span><input type="text" v-model="store.routineDetail.part" style="width: 200px; margin: 5px 0px;" disabled></p>
            <p><span style="font-weight: 1000;">운동 종목</span><input type="text" v-model="store.routineDetail.detail" style="width: 200px; margin: 5px 0px;" disabled></p>
            <p><span style="font-weight: 1000;">세트 반복</span><input type="number" v-model="store.routineDetail.sets" style="width: 200px; margin: 5px 0px;" disabled></p>
            <p><span style="font-weight: 1000;">세트당 횟수</span><input type="number" v-model="store.routineDetail.count" style="width: 200px; margin: 5px 0px;" disabled></p>
        </div>
    </div>
    <p class="content">상세<input type="text" v-model="store.routineBoard.content"></p>
    <div class="buttons">
        <button @click="store.updateBoard()" class="bt-regist">등록</button>
        <button @click="router.push(`${store.routineBoard.id}`)" class="bt-cancle">취소</button>
    </div>
</template>
  
<script setup>
import {useRoutineBoardStore} from '@/stores/routineBoard'
import {useUserStore} from '@/stores/User'
import {useRouter} from 'vue-router';

const router = useRouter();
const store = useRoutineBoardStore();
const userStore = useUserStore();

</script>

<style scoped>
@import '@/assets/Create.css';
</style>