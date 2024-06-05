<script setup>
import { RouterLink, RouterView } from 'vue-router'
import HeaderComponent from '@/components/common/HeaderComponent.vue'
</script>

<template>
  <HeaderComponent />
  <RouterView />
</template>

<style>
@import url('https://cdn.jsdelivr.net/gh/moonspam/NanumSquare@2.0/nanumsquare.css');
* {
  color: #333333;
  font-family: 'NanumSquare', sans-serif;
  font-weight: 700;
  text-decoration: none;
}

body {
    overflow-y: scroll;
}

</style>
