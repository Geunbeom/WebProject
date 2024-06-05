<template>
    <div class="outside">
        <div class="screen">
            <h2 style="position: absolute; top: 0px; left: 30px">Highscore: {{ Math.max(Math.floor(count/2), highscore, store.currUserInfo.highscore) }}</h2>
            <h2 v-if="onGame" style="position: absolute; top: 45px; left: 30px">Score: {{ Math.floor(count/2) }}</h2>
            <div class="info">
                현재 마일리지: {{ store.currUserInfo.mileage }} <br>
                현재 경험치: {{ store.currUserInfo.exp }} <br><br>
            </div>
            <div v-if="onGame">
                <h2 style="position: absolute; top: 0px; left: 408px">남은 시간: {{ time }}</h2>
                <img v-if="count%2 == 0" class="pushup" src="@/assets/img/22.png" alt="">
                <img v-else class="pushup" src="@/assets/img/23.png" alt="">
            </div>
            <div v-else>
                <img class="pushup" src="@/assets/img/21.gif" alt="">
                <h2 style="position: absolute; top: -10px; left: 370px; font-size: 30px;">Push Up Game</h2>
                <img style="position: absolute; top: 260px; left: 200px" src="@/assets/img/31.png" alt="" @click="onGame = true; gameStart(20)">
                <img style="position: absolute; top: 260px; right: 200px" src="@/assets/img/32.png" alt="" @click="howto()">
                <img style="position: absolute; top: 390px; left: 200px" src="@/assets/img/33.png" alt="" @click="ranks()">
                <img style="position: absolute; top: 390px; right: 200px" src="@/assets/img/34.png" alt="" @click="router.push({name: 'gameMain'})">
            </div>
            <div v-if="rankOn" style="position: absolute; top: 0px; left: 0px; width: 960px; height: 540px; background-color: rgba(0,0,0,0.1);">
            </div>
            <div v-if="rankOn" class="scoreRank">
                <h2>🏆 랭킹 🏆</h2>
                <br>
                <span style="position: absolute; left: 58px;">등수</span>
                <span>아이디</span>
                <span style="position: absolute; right: 65px;">점수</span>
                <br>
                <span></span>
                <br>
                <div v-for="(rank, index) in store.scoreRankList" :key="index">
                    <span style="position: absolute; left: 60px;">{{ index+1 }}등</span>
                    <span>{{ rank.id != 'none' ? rank.id : '-' }}</span>
                    <span style="position: absolute; right: 70px;">{{ rank.id != 'none' ? rank.highscore : '-' }}</span>
                </div>
                <br><br>
                <button @click="ranks()">확인</button>
                <br>
            </div>
            <button v-if="onGame" class="click" :style="{ bottom: y +'px', right: x +'px', width: 50-count/2 +'px', height: Math.max(50-count/2,12) +'px' }" @click="add()" @keydown.prevent>{{text}}</button>
        </div>
    </div>
</template>

<script setup>
import { useUserInfoStore } from '@/stores/UserInfo'
import {onMounted, onUnmounted, ref} from 'vue'
import { useRouter, onBeforeRouteLeave  } from 'vue-router';

const store = useUserInfoStore()
const router = useRouter()

const x = ref(900*Math.random())
const y = ref(300*Math.random())
const text = ref('Click')
const time = ref(0)
const onGame = ref(false)

const rankOn = ref(false)
const ranks = function(){
    rankOn.value = !rankOn.value
    store.getScoreRank()
}

const count = ref(0)
const add = function(){
    count.value++
    x.value = 900*Math.random()
    y.value = 300*Math.random()
    if(count.value>20) text.value = ''
}

const highscore = store.currUserInfo.highscore

const gameStart = function(num){
    time.value = num;
    if(!onGame.value){
        return;
    }
    if(num==-1){
        alert(`Game Over!\n${Math.floor(count.value/2)}점 달성! ${Math.floor(count.value/2)} 마일리지를 획득하였습니다.`)
        store.addMileage(Math.floor(count.value/2))
        if(Math.floor(count.value/2) > highscore){
            alert(`하이스코어 경신!`)
            store.newHighscore(Math.floor(count.value/2))
        }
        text.value = 'click';
        count.value = 0;
        onGame.value = false;
        store.getInfo();
        return;
    }
    else{
        setTimeout(function() {
            gameStart(num-1)
        }, 1000)
    }
}

const howto = function(){
    alert('20초 동안 화면 곳곳에 등장하는 초록색 버튼을 눌러 점수를 획득하세요! \n획득한 점수에 따라 소량의 마일리지를 지급합니다.')
}

// 게임 중간에 나갈 때 게임종료처리
onBeforeRouteLeave((to, from, next) => {
    onGame.value = false
    next()
})

onUnmounted(() => {
    onGame.value = false
})


</script>

<style scoped>
@import '@/assets/Game.css';

</style>