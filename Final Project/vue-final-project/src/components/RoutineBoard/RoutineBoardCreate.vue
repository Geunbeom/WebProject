<template>
    <div class="detail">
        <span>제목</span>
        <input type="text" v-model="routineBoard.title">
    </div>
    <div class="create-form1">
        <div class="create-muscle">
            <Muscle v-if="!select"/>
            <MuscleSel v-else :index="1"/>
        </div>
        <div class="create-form2">
            <h3>루틴</h3>
            <div style="border: 1px solid rgba(0, 0, 0, 0.233); width: 250px; margin: 20px auto;">
                <p><span style="font-weight: 1000;">운동 부위</span>
                    <input disabled v-if="!select" type="text" v-model="muscleStore.part" style="width: 200px; margin: 5px 0px;">
                    <input v-else type="text" v-model="routine.part" style="width: 200px; margin: 5px 0px;">
                    <p style="font-size: 12px; width: 100px; margin-top:2px; margin-left: 60%; padding-top: 0px;">직접 입력 : <input type="checkbox" v-model="select" style="margin-top: 0px; height: 100%;"></p>
                </p>
                <p><span style="font-weight: 1000;">운동 종목</span><input type="text" v-model="routine.detail" style="width: 200px; margin: 5px 0px;"></p>
                <p><span style="font-weight: 1000;">세트 반복</span><input type="number" v-model="routine.sets" style="width: 200px; margin: 5px 0px;"></p>
                <p><span style="font-weight: 1000;">세트당 횟수</span><input type="number" v-model="routine.count" style="width: 200px; margin: 5px 0px;"></p>
            </div>
        </div>
    </div>
    <p class="content">상세<input type="text" v-model="routineBoard.content"><span style="margin-left:90%; font-size: 12px;">&nbsp;&nbsp;{{routineBoard.content.length}}/1000</span></p>
    
    <div class="buttons">
        <button @click="store.createBoard(routineBoard, routine, select)" class="bt-regist">등록</button>
        <button @click="router.push({name:'routineBoardList'})" class="bt-cancle">취소</button>
    </div>
</template>
  
<script setup>
import Muscle from '@/components/User/Muscle.vue';
import MuscleSel from '@/components/User/MuscleSelected.vue';
import { useRoutineBoardStore } from '@/stores/routineBoard';
import {useMuscleStore} from '@/stores/Muscle';
import {useUserStore} from '@/stores/User';
import { useRouter } from 'vue-router';
import { ref } from 'vue'

const userStore = useUserStore();
const router = useRouter();
const store = useRoutineBoardStore();
const muscleStore = useMuscleStore();
const select = ref(false);

const routineBoard = ref({
    writer: userStore.loginUser.nickName,
    content: ''
})

const routine = ref({})

</script>

<style scoped>
@import '@/assets/Create.css';
</style>