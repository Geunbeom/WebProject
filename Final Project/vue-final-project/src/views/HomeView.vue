<template>
    <div>
        <div class="main"><img src="@/assets/imgMain/main.gif" style="width:1900px;"></div>
        <div class="ranking">
            <p style="font-weight: 1000; text-align: center; margin-bottom: 20px;">🏆 회원 랭킹 🏆</p>
            <div class="currRank" v-for="(rank, index) in store.rankList" :key="index">
                <span>{{ index+1 }}</span>
                <span v-if="rank.nickName !== 'none'">
                    <span v-if="getRank(rank.rate)=='Bronze'" style="margin-top: 2px;"><img src="@/assets/imgRank/0b.png" alt="" width="24px"></span>
                    <span v-if="getRank(rank.rate)=='Silver'" style="margin-top: 2px;"><img src="@/assets/imgRank/0s.png" alt="" width="24px"></span>
                    <span v-if="getRank(rank.rate)=='Gold'" style="margin-top: 2px;"><img src="@/assets/imgRank/0g.png" alt="" width="24px"></span>
                    <span v-if="getRank(rank.rate)=='Platinum'" style="margin-top: 2px;"><img src="@/assets/imgRank/0p.png" alt="" width="24px"></span>
                    <span v-if="getRank(rank.rate)=='Diamond'" style="margin-top: 2px;"><img src="@/assets/imgRank/0d.png" alt="" width="24px"></span>
                    {{rank.nickName}} |
                    <span style="align-self: right;">
                        exp : {{ rank.exp }}
                    </span>
                </span>
                <span v-else>
                </span>
            </div>
            <p style="font-size: 12px; font-weight: 1000; color:rgba(0, 0, 0, 0.568); text-align: end; margin-right: 5px;">갱신 시간 : {{ dayjs() }}</p>
        </div>
        <div>
            
        </div>
    </div>
</template>

<script setup>
import dayjs from 'dayjs';
import {onMunted, ref, computed} from 'dayjs';
import { onMounted } from 'vue';
import { useUserInfoStore } from '@/stores/UserInfo';

const store = useUserInfoStore();
onMounted(() => {
    store.getRank();
})

const getRank = function(rate) {
    if (rate === 0) {
        return "Bronze";
    }
    else if (rate === 1) {
        return "Silver";
    }else if (rate === 2) {
        return "Gold";
    }else if (rate === 3) {
        return "Platinum";
    }else if (rate === 4) {
        return "Diamond";
    }else {
        return "None";
    }
}

</script>

<style scoped>
.main {
    position:relative;
    margin: 0px;
    left: 0px;
    z-index: 4;
}

.ranking {
    position: absolute;
    background-color: white;
    height: 700px;
    width: 270px;
    z-index: 5;
    top: 178px;
    right: 3%;
    padding: 10px;
}

.currRank {
    border-bottom: 1px solid rgba(0, 0, 0, 0.199);
    margin-bottom: 25px;
    padding-bottom: 10px;
    display: flex;
    align-items: center;
    color: rgba(0, 0, 0, 0.507);
}

.currRank *{
    margin-left: 5px;
}


</style>