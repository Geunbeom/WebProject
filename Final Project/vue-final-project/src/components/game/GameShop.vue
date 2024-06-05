<template>
    <div class="outside">
        <div class="screen">
            <div class="info">
                현재 마일리지: {{ store.currUserInfo.mileage }} <br>
                현재 경험치: {{ store.currUserInfo.exp }} <br><br>
            </div>
            <img src="@/assets/img/40.png" alt="" style="position: absolute; top: 20px; left: 30px;" @click="router.push({name: 'gameMain'})">
            <div style="position: absolute; top: 123px; left: 52px; width: 216px; height: 300px;" @click="payStore.requestPayment(8000, 10000)">
                <img style="position: absolute; z-index: 1; top: 0px; left: 0px;" src="@/assets/img/42.png" alt="">
                <div style="position: absolute; top: 180px; width: 100%; text-align: center;"> 8000 마일리지 충전</div>
                <div style="position: absolute; top: 235px; width: 100%; text-align: center; font-size: 20px"> 10,000\</div>
            </div>
            <div style="position: absolute; top: 123px; left: 372px; width: 216px; height: 300px;" @click="payStore.requestPayment(50000, 50000)">
                <img style="position: absolute; z-index: 1; top: 0px; left: 0px;" src="@/assets/img/43.png" alt="">
                <div style="position: absolute; top: 180px; width: 100%; text-align: center;"> 50000 마일리지 충전</div>
                <div style="position: absolute; top: 235px; width: 100%; text-align: center; font-size: 20px"> 50,000\</div>
            </div>
            <div style="position: absolute; top: 123px; left: 692px; width: 216px; height: 300px;" @click="payStore.requestPayment(120000, 100000)">
                <img style="position: absolute; z-index: 1; top: 0px; left: 0px;" src="@/assets/img/44.png" alt="">
                <div style="position: absolute; top: 180px; width: 100%; text-align: center;"> 120000 마일리지 충전</div>
                <div style="position: absolute; top: 235px; width: 100%; text-align: center; font-size: 20px"> 100,000\</div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { useRouter } from "vue-router";
import { useUserInfoStore } from '@/stores/UserInfo'
import {usePayStore} from '@/stores/Payments'

const router = useRouter()
const store = useUserInfoStore()
const payStore = usePayStore()
</script>

<style scoped>
@import '@/assets/Game.css';

</style>