
<template>
    <div class="outside">
        <div class="screen">
            <img src="@/assets/img/4.png" alt="" style="position: absolute; top: 20px; left: 30px;" @click="router.push({name: 'gameShop'})">
            <div class="info">
                현재 마일리지: {{ store.currUserInfo.mileage }} <br>
                현재 경험치: {{ store.currUserInfo.exp }} <br><br>
            </div>

            
            <div class="exp" v-if="!selected1 && !selected2 && !work1">
                <div style="display: flex; justify-content: space-between; margin-bottom: 2px; width: 350px;">
                    <img v-if="store.currUserInfo.rate == 0" src="@/assets/imgRank/0b.png" alt="" width="30px">
                    <img v-if="store.currUserInfo.rate == 0 || store.currUserInfo.rate == 1" src="@/assets/imgRank/0s.png" alt="" width="30px">
                    <img v-if="store.currUserInfo.rate == 1 || store.currUserInfo.rate == 2" src="@/assets/imgRank/0g.png" alt="" width="30px">
                    <img v-if="store.currUserInfo.rate == 2 || store.currUserInfo.rate == 3" src="@/assets/imgRank/0p.png" alt="" width="30px">
                    <img v-if="store.currUserInfo.rate == 4" src="@/assets/imgRank/0p.png" alt="" width="30px">
                    <img v-if="store.currUserInfo.rate == 3 || store.currUserInfo.rate == 4" src="@/assets/imgRank/0d.png" alt="" width="30px">
                </div>
                <div class="max-exp"> &nbsp;
                    <div v-if="store.currUserInfo.exp >= 12000" class="curr-exp" style="width: 100%; background-color: rgb(30, 229, 236); color: white;">
                        &nbsp;MAX
                    </div>
                    <div v-else class="curr-exp" :style="{width: `${curEXP}%`, backgroundColor: color, color: 'white'}">
                        &nbsp;{{ curEXP }}%
                    </div>
                </div>
            </div>
            <div class="man">
                <img src="@/assets/img/10.png" alt="" v-if="!selected1 && !selected2 && !work1">
                <img src="@/assets/img/11.gif" alt="" v-if="!selected1 && !selected2 && work1">
            </div>

            <div class="bt-1" v-if="selected1">
                <div>
                    <img src="@/assets/img/1easy.png" alt="" @click="game1(0.8, 100)">
                    <div>
                        <p>가격: 100ⓜ</p>
                        <p>성공확률: 80% | 획득 exp: 100</p>
                    </div>
                </div>
                <div>
                    <img src="@/assets/img/1normal.png" alt="" @click="game1(0.5, 200)">
                    <div>
                        <p>가격: 100ⓜ</p>
                        <p>성공확률: 50% | 획득 exp: 200</p>
                    </div>
                </div>
                <div>
                    <img src="@/assets/img/1hard.png" alt="" @click="game1(0.2, 500)">
                    <div>
                        <p>가격: 100ⓜ</p>
                        <p>성공확률: 20% | 획득 exp: 500</p>
                    </div>
                </div>
                <div>
                    <img src="@/assets/img/1hell.png" alt="" @click="game1(0.01, 10000)">
                    <div>
                        <p>가격: 100ⓜ</p>
                        <p>성공확률: 1% | 획득 exp: 10000</p>
                    </div>
                </div>
            </div>
            <div class="bt-2" v-if="selected2">
                <div>
                    <img src="@/assets/img/2a.png" alt="" @click="game2(500, 300)">
                    <div>
                        <p>가격: 500ⓜ</p>
                        <p>획득 exp: 300</p>
                    </div>
                </div>
                <div>
                    <img src="@/assets/img/2b.png" alt="" @click="game2(2000, 1500)">
                    <div>
                        <p>가격: 2000ⓜ</p>
                        <p>획득 exp: 1500</p>
                    </div>
                </div>
                <div>
                    <img src="@/assets/img/2c.png" alt="" @click="game2(10000, 8000)">
                    <div>
                        <p>가격: 10000ⓜ</p>
                        <p>획득 exp: 8000</p>
                    </div>
                </div>
            </div>
            <div class="bt-bar">
                <img src="@/assets/img/1.png" alt="" @click="select1(!selected1)">
                <img src="@/assets/img/2.png" alt="" @click="select2(!selected2)">
                <img src="@/assets/img/3.png" alt="" @click="router.push({name: 'miniGame'})">
            </div>
        </div>
    </div>
</template>

<script setup>
import { useUserInfoStore } from '@/stores/UserInfo'
import {ref, computed} from 'vue'
import { useRouter } from 'vue-router';

const store = useUserInfoStore()
const router = useRouter()

const selected1 = ref(false)
const selected2 = ref(false)
const work1 = ref(false)

const select1 = function(n){
    selected2.value = false;
    selected1.value = n;
}
const select2 = function(n){
    selected1.value = false;
    selected2.value = n;
}

const game1 = function(prob, reward){
    store.game1(prob, reward);
    selected1.value = false;
    work1.value = true;
}

const game2 = function(prob, reward){
    store.game2(prob, reward);
    selected2.value = false;
}

// 경험치
const curEXP = computed(() => {
    if(store.currUserInfo.rate == 0) {
        return store.currUserInfo.exp/10;
    }else if(store.currUserInfo.rate == 1) {
        return (store.currUserInfo.exp-1000)/20;
    }else if(store.currUserInfo.rate == 2) {
        return (store.currUserInfo.exp-3000)/40;
    }else if(store.currUserInfo.rate == 3) {
        return (store.currUserInfo.exp-7000)/50;
    }else {
        return 0;
    }
})

const color = computed(() => {
    if(store.currUserInfo.rate === 0) {
        return 'rgb(172, 103, 13)';
    }else if(store.currUserInfo.rate === 1) {
        return 'rgb(160, 160, 160)';
    }else if(store.currUserInfo.rate === 2) {
        return 'rgb(236, 199, 30)';
    }else if(store.currUserInfo.rate === 3) {
        return 'rgb(30, 236, 174)';
    }else if(store.currUserInfo.rate === 4) {
        return 'rgb(30, 229, 236)';
    }
    else return'rgb(0,0,0)';
})

</script>

<style scoped>
@import '@/assets/Game.css';

</style>