<template>
    <h2>회원정보 페이지</h2>
    <div>
        <p>ID : {{ store.currUserInfo.id }}</p>
        <p v-if="isUpdate">Email : {{ store.currUserInfo.email }}</p>
        <p v-else>
            Email :
            <input type="text" v-model="store.currUserInfo.email">
        </p>
        <p v-if="isUpdate">Name : {{ store.currUserInfo.name }}</p>
        <p v-else>
            Name :
            <input type="text" v-model="store.currUserInfo.name">
        </p>
        <p v-if="isUpdate">NickName : {{ store.currUserInfo.nickName }}</p>
        <p v-else>
            NickName :
            <input type="text" v-model="store.currUserInfo.nickName">
        </p>
        <p>BornDate : {{ store.currUserInfo.bornDate }}</p>
        <button v-if="isUpdate" @click="isUpdate = !isUpdate" class="bt-up" style="width: 45px; height: 30px;">수정</button>
        <div v-else>
            <button @click="update()" style="width: 45px; height: 30px;">저장</button>
            <button @click="cancle()" style="width: 45px; height: 30px;">취소</button>
        </div>
    </div>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import {useUserStore} from '@/stores/User'
import {useRouter} from 'vue-router'

const store = useUserStore()
const router = useRouter()
const isUpdate = ref(true)


onMounted(() => {
    store.getUser();
})
const update = function() {
    store.doUpdate();
}

const cancle = function() {
    isUpdate.value = !isUpdate.value;
    router.go(router.currentRoute)
}

</script>

<style scoped>
@import '@/assets/MyBoard.css';
input {
    border: 1px solid rgba(0, 0, 0, 0.171);
    height: 14px;
    border-radius: 3px;
}
</style>