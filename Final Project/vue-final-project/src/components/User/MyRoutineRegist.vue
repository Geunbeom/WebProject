<template>
    <div style="position: absolute; z-index: 1; top: 0px; left: 0px; width: 100%; height: 100%; background-color: rgba(0,0,0,0.1);" @click="store.check = false">
    </div>
    <div style="position: absolute; z-index: 2; top: 100px; left: 50%; transform: translateX(-50%); border: 1px solid rgba(0, 0, 0, 0.233); padding: 20px; width: 800px; height: 560px; text-align: center; margin: 50px auto; border-radius: 10px; background-color: white;">
        <div style="position: absolute; z-index: 3; top: 95px; left: 425px; border: 1px solid rgba(0, 0, 0, 0.233); padding: 20px; width: 300px; text-align: center;">
            <h3>루틴</h3>
            <div style="border: 1px solid rgba(0, 0, 0, 0.233); width: 250px; margin: 20px auto;">
                <p><span style="font-weight: 1000;">운동 부위</span>
                    <input disabled v-if="!select" type="text" v-model="muscleStore.part" style="width: 200px; margin: 5px 0px;">
                    <input v-else type="text" v-model="store.myRoutine.part" style="width: 200px; margin: 5px 0px;">
                    <p style="font-size: 12px; width: 100px; margin:0px; margin-left: 60%;">직접 입력 : <input type="checkbox" v-model="select"></p>
                </p>
                <p><span style="font-weight: 1000;">운동 종목</span><input type="text" v-model="store.myRoutine.detail" style="width: 200px; margin: 5px 0px;"></p>
                <p><span style="font-weight: 1000;">세트 반복</span><input type="number" v-model="store.myRoutine.sets" style="width: 200px; margin: 5px 0px;"></p>
                <p><span style="font-weight: 1000;">세트당 횟수</span><input type="number" v-model="store.myRoutine.count" style="width: 200px; margin: 5px 0px;"></p>
            </div>
            <button @click="store.doRegist(select)" style="width: 70px; height: 30px;">등록하기</button>
            <button @click="cancle()" style="width: 50px; height: 30px; margin-left: 10px;">취소</button>
        </div>
        <div style="position: absolute; z-index: 3; top: 130px; left: 10px;">
            <Muscle v-if="!select"/>
            <MuscleSel v-else :index="1"/>
        </div>
    </div>
</template>

<script setup>
import Muscle from '@/components/User/Muscle.vue';
import MuscleSel from '@/components/User/MuscleSelected.vue';
import {useMyRoutineStore} from '@/stores/MyRoutine';
import {useMuscleStore} from '@/stores/Muscle';
import { useRouter } from 'vue-router';
import {ref} from 'vue';

const store = useMyRoutineStore();
const muscleStore = useMuscleStore();
const select = ref(false);
const router = useRouter();
const cancle = function() {
    store.check = false
    router.go(0);
}
</script>

<style scoped>
@import '@/assets/MyBoard.css';
</style>