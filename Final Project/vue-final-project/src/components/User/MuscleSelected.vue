<template>
    <div class="muscle">
        <img src="@/assets/img/muscle.png" class="muscle1">
        <div style="position: absolute; top: 0;" v-if="index !== 1">
            <img src="@/assets/img/muscle2.png" :class="`muscle${index}-1`" style="opacity: 1; cursor:auto;">    
            <img src="@/assets/img/muscle2.png" :class="`muscle${index}-2`" style="opacity: 1; cursor:auto;">
        </div>
    </div>
</template>

<script setup>
import {ref} from 'vue';

defineProps({
    index: Number
})



</script>

<style scoped>
@import '@/assets/Muscle.css';
</style>