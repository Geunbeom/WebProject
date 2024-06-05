<template>
    <div>
        <h2 style="margin-bottom: 12px;">경험치</h2>
        <div style="display: flex; justify-content: space-between; margin-bottom: 2px; width: 350px;">
            <img v-if="infoStore.currUserInfo.rate == 0" src="@/assets/imgRank/0b.png" alt="" width="30px">
            <img v-if="infoStore.currUserInfo.rate == 0 || infoStore.currUserInfo.rate == 1" src="@/assets/imgRank/0s.png" alt="" width="30px">
            <img v-if="infoStore.currUserInfo.rate == 1 || infoStore.currUserInfo.rate == 2" src="@/assets/imgRank/0g.png" alt="" width="30px">
            <img v-if="infoStore.currUserInfo.rate == 2 || infoStore.currUserInfo.rate == 3" src="@/assets/imgRank/0p.png" alt="" width="30px">
            <img v-if="infoStore.currUserInfo.rate == 4" src="@/assets/imgRank/0p.png" alt="" width="30px">
            <img v-if="infoStore.currUserInfo.rate == 3 || infoStore.currUserInfo.rate == 4" src="@/assets/imgRank/0d.png" alt="" width="30px">
        </div>
        <div class="max-exp"> &nbsp;
            <div v-if="infoStore.currUserInfo.exp >= 12000" class="curr-exp" style="width: 100%; background-color: rgb(30, 229, 236); color: white;">
                &nbsp;MAX
            </div>
            <div v-else class="curr-exp" :style="{width: `${curEXP}%`, backgroundColor: color, color: 'white'}">
                &nbsp;{{ curEXP }}%
            </div>
        </div>
        <div v-if="infoStore.currUserInfo.rate !== 4" style="display: flex; justify-content: space-between; margin-bottom: 2px; width: 350px; font-size: 12px;">
            <span>{{ arr[infoStore.currUserInfo.rate] }} exp</span>
            <span>{{ arr[infoStore.currUserInfo.rate+1] }} exp</span>
        </div>
        <div>
            <p v-if="infoStore.currUserInfo.exp >= 12000">최고 등급입니다.</p>
            <p v-else>다음 등급까지 남은 경험치: {{ remainEXP }}exp</p>
            <p>누적 경험치: {{ infoStore.currUserInfo.exp }}exp</p>
        </div>
    </div>


    <div  @mousemove="find($event)">
        <h2 style="margin-top: 36px; margin-bottom: 16px;">최근 10일 출석 정보</h2>
        <div class="grass">
            <div v-for="(attend, index) in store.attend" :key="index" @click="now(index)" @mouseover="where(index)" @mouseout="point = false" style="cursor:pointer;">
                <div v-if="attend.check" :style="{'margin-left': '3px', width: '20px', height: '20px', backgroundColor: color, border:'2px solid black', borderRadius: '4px'}"></div>
                <div v-else :style="{'margin-left': '3px', width: '20px', height: '20px', backgroundColor: 'rgb(246, 246, 246)', border:'2px solid black', borderRadius: '4px'}"></div>
            </div>
        </div>
        <br>
        <div v-if="store.attend[num]">
            날짜: {{ store.attend[num].date }}
            <div v-if="store.attend[num].check == 0">
                <p>이 날은 출석을 하지 않았습니다.</p>
            </div>
            <div v-else class="routine-body">
                <div class="routine-muscle">
                    <MuscleSel :index="partNum"/>
                </div>
                <div class="routine">
                    <p>이 날의 루틴</p>
                    <p>운동 부위: {{ store.attend[num].part }}</p>
                    <p>운동 종목: {{ store.attend[num].detail }}</p>
                    <p>세트: {{ store.attend[num].sets }}</p>
                    <p>횟수: {{ store.attend[num].count }}</p>
                </div>
            </div>
        </div>
    </div>
    <button @click="attendBT()" style="width: 70px; height: 30px;">출석하기</button>
    <Attend v-if="store.check"/>
    <div class="routine-body1" :style="position" v-if="point">
        <p>&nbsp; 날짜: {{ store.attend[nums].date }} |</p>
        <p>&nbsp; 운동 부위: {{ store.attend[nums].part }} |</p>
        <p>&nbsp; 운동 종목: {{ store.attend[nums].detail }} |</p>
        <p>&nbsp; 세트: {{ store.attend[nums].sets }} |</p>
        <p>&nbsp; 횟수: {{ store.attend[nums].count }}</p>
    </div>
</template>

<script setup>
import MuscleSel from '@/components/User/MuscleSelected.vue';
import Attend from '@/components/User/Attend.vue';
import {useMyRoutineStore} from '@/stores/MyRoutine';
import {useUserInfoStore} from '@/stores/UserInfo';
import {onMounted, ref, computed} from 'vue';
import {useRouter} from 'vue-router';

const router = useRouter();
const num = ref(9);

const infoStore = useUserInfoStore();
const store = useMyRoutineStore();

onMounted(() => {
    store.getAttend();
})

const now = function(n){
    num.value = n
}

const attendBT = function() {
    if(!todayAttend.value) {
        store.check = !store.check
    }else {
        alert('이미 출석을 했습니다.')
    }
}


const todayAttend = computed(() => {
    return store.getToday;
})

const arr = ref([0, 1000, 3000, 7000, 12000])

// 경험치
const curEXP = computed(() => {
    if(infoStore.currUserInfo.rate == 0) {
        return infoStore.currUserInfo.exp/10;
    }else if(infoStore.currUserInfo.rate == 1) {
        return (infoStore.currUserInfo.exp-1000)/20;
    }else if(infoStore.currUserInfo.rate == 2) {
        return (infoStore.currUserInfo.exp-3000)/40;
    }else if(infoStore.currUserInfo.rate == 3) {
        return (infoStore.currUserInfo.exp-7000)/50;
    }else {
        return 0;
    }
})

// 남은 경험치
const remainEXP = computed(() => {
    if(infoStore.currUserInfo.rate == 0) {
        return 1000-infoStore.currUserInfo.exp;
    }else if(infoStore.currUserInfo.rate == 1) {
        return 3000-infoStore.currUserInfo.exp;
    }else if(infoStore.currUserInfo.rate == 2) {
        return 7000-infoStore.currUserInfo.exp;
    }else if(infoStore.currUserInfo.rate == 3) {
        return 12000-infoStore.currUserInfo.exp;
    }else {
        return 0;
    }
})

// 풀 색
const color = computed(() => {
    if(infoStore.currUserInfo.rate === 0) {
        return 'rgb(172, 103, 13)';
    }else if(infoStore.currUserInfo.rate === 1) {
        return 'rgb(160, 160, 160)';
    }else if(infoStore.currUserInfo.rate === 2) {
        return 'rgb(236, 199, 30)';
    }else if(infoStore.currUserInfo.rate === 3) {
        return 'rgb(30, 236, 174)';
    }else if(infoStore.currUserInfo.rate === 4) {
        return 'rgb(30, 229, 236)';
    }
    else return'rgb(0,0,0)';
})

// 파트 넘버
const partNum = computed(() => {
    if(store.attend[num.value].part === "어깨") {
        return 2;
    }else if (store.attend[num.value].part === "팔") {
        return 3;
    }else if (store.attend[num.value].part === "전완근") {
        return 4;
    }else if (store.attend[num.value].part === "가슴") {
        return 5;
    }else if (store.attend[num.value].part === "등") {
        return 6;
    }else if (store.attend[num.value].part === "복근") {
        return 7;
    }else if (store.attend[num.value].part === "하체") {
        return 8;
    }else {
        return 1;
    }
})

const position = ref();
const nums = ref(9);
const point = ref(false);
const whereX = ref();
const whereY = ref();

// 좌표찾기
const find = function(e) {
    whereX.value = e.pageX;
    whereY.value = e.pageY;
    position.value = `top: ${e.pageY+25}px; left:${e.pageX+10}px;`
}
const where = function(index) {
    if (store.attend[index].check !== 0) {
        point.value = true;
        nums.value = index;
    }
}

</script>

<style scoped>
@import '@/assets/MyBoard.css';
</style>