<template>
    <div class="title">
        <img src="@/assets/imgMain/title.jpeg" width="130px" @click="router.push({name:'home'})">
    </div>
    <div style="margin-bottom: 35px;">
        <div class="head">
            <div class="header" v-if="store.checkLogin">
                <input type="text" placeholder="아이디" v-model="user.id"/>
                <input type="password" placeholder="비밀번호" v-model="user.password"/>
                <button @click="store.doLogin(user)">로그인</button>
                <button @click="router.push({name: 'userRegist'})">회원 등록</button>
            </div>
            <div class="header" v-else>
                <span v-if="rank=='Bronze'" style="margin-top: 2px;"><img src="@/assets/imgRank/0b.png" alt="" width="24px"></span>
                <span v-if="rank=='Silver'" style="margin-top: 2px;"><img src="@/assets/imgRank/0s.png" alt="" width="24px"></span>
                <span v-if="rank=='Gold'" style="margin-top: 2px;"><img src="@/assets/imgRank/0g.png" alt="" width="24px"></span>
                <span v-if="rank=='Platinum'" style="margin-top: 2px;"><img src="@/assets/imgRank/0p.png" alt="" width="24px"></span>
                <span v-if="rank=='Diamond'" style="margin-top: 2px;"><img src="@/assets/imgRank/0d.png" alt="" width="24px"></span>
                <p style="margin-left: 6px;">
                    {{ rank }} · {{ store.loginUser.name }}님 반갑습니다 · 현재 마일리지: {{ infoStore.currUserInfo.mileage }}
                </p>
                <button @click="store.doLogout()">로그아웃</button>
            </div>
        </div>
        <div class="head2">
            <RouterLink :to="{name: 'home'}" active-class="active"><h3 style="margin: 0px 50px">Home</h3></RouterLink>
            <RouterLink :to="{name: 'freeBoardList'}" active-class="active"><h3 style="margin: 0px 50px">자유게시판</h3></RouterLink>
            <RouterLink :to="{name: 'routineBoardList'}" active-class="active"><h3 style="margin: 0px 50px">루틴게시판</h3></RouterLink>
            <RouterLink :to="{name: 'gameMain'}" active-class="active"><h3 style="margin: 0px 50px">헬린이키우기</h3></RouterLink>
            <RouterLink :to="{name: 'myAttend'}" active-class="active"><h3 v-if="!store.checkLogin" style="margin: 0px 50px">마이페이지</h3></RouterLink>
        </div>
    </div>
</template>

<script setup>
    import {ref, onMounted, computed} from 'vue';
    import {useUserStore} from '@/stores/User';
    import {useUserInfoStore} from '@/stores/UserInfo';
    import {useRouter} from 'vue-router';

    const router = useRouter();
    const store = useUserStore();
    const infoStore = useUserInfoStore();
    const user = ref({});

    const rank = computed(() => {
        if (infoStore.currUserInfo.rate === 0) {
            return "Bronze";
        }
        else if (infoStore.currUserInfo.rate === 1) {
            return "Silver";
        }else if (infoStore.currUserInfo.rate === 2) {
            return "Gold";
        }else if (infoStore.currUserInfo.rate === 3) {
            return "Platinum";
        }else if (infoStore.currUserInfo.rate === 4) {
            return "Diamond";
        }else {
            return "None";
        }
    })

    onMounted(() => {
        if(sessionStorage.getItem('loginUser')) {
            infoStore.getInfo();
        }
    })

</script>

<style scoped>
@import '@/assets/Header.css';

</style>