<template>
    <h1 style="margin-left: 19%; margin-top: 70px; margin-bottom: 30px;">회원가입</h1>
    <div class="regist">
        <table>
            <tr>
                <th>Id</th>
                <td><input type="text" v-model="registUser.id" /></td>
            </tr>
            <tr>
                <th>Password</th>
                <td><input type="password" v-model="registUser.password"/></td>
            </tr>
            <tr>
                <th>Email</th>
                <td><input type="eamil" v-model="registUser.email"/></td>
            </tr>
            <tr>
                <th>Name</th>
                <td><input type="text" v-model="registUser.name"/></td>
            </tr>
            <tr>
                <th>NickName</th>
                <td><input type="text" v-model="registUser.nickName"/></td>
            </tr>
            <tr>
                <th>BornDate</th>
                <td><input type="date" v-model="registUser.bornDate"/></td>
            </tr>
        </table>
        <button @click="store.registUser(registUser)">등록</button>
    </div>
</template>

<script setup>
import {ref} from 'vue';
import {useUserStore} from '@/stores/User';

const store = useUserStore()
const registUser = ref({})

</script>

<style scoped>
@import '@/assets/UserRegist.css';
</style>