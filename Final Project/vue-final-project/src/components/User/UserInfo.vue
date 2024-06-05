<template>
    <div class="container">
        <div class="menu">
            <RouterLink :to="{name: 'myAttend'}" exact-active-class="active">📅 출석현황</RouterLink>
            <RouterLink :to="{name: 'myInfo'}" active-class="active">📃 회원정보</RouterLink>
            <RouterLink :to="{name: 'myBoard'}" active-class="active">💗 좋아요한 글</RouterLink>
            <RouterLink :to="{name: 'myRoutine'}" active-class="active">📂 저장한 루틴</RouterLink>
        </div>
        <div class="main">
            <RouterView/>
        </div>
    </div>
</template>

<script setup>
import '@/assets/UserInfo.css'
</script>