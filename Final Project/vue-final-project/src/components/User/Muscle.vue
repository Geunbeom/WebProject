<template>
    <div class="muscle">
        <img src="@/assets/img/muscle.png" class="muscle1">
        <div style="position: absolute; top: 0;" v-for="index in arr" :key="index">
            <img src="@/assets/img/muscle2.png" :class="[`muscle${index}-1`, {'muscle-hover' : check==index}, {'muscle-click' : set==index}]" @mouseover="check = index" @mouseout="check = -1" @click="send(index)">    
            <img src="@/assets/img/muscle2.png" :class="[`muscle${index}-2`, {'muscle-hover' : check==index}, {'muscle-click' : set==index}]" @mouseover="check = index" @mouseout="check = -1" @click="send(index)">
        </div>
    </div>
</template>

<script setup>
import {ref} from 'vue';
import { useMuscleStore } from '@/stores/Muscle';
const store = useMuscleStore();
const check = ref(-1);
const arr = ref([2, 3, 4, 5, 6, 7, 8])
const set = ref(-1);

const send = function(index) {
    if (set.value == index) {
        set.value = -1;
        store.partNum = -1;
    }else {
        set.value = index;
        store.partNum = index;
    }
}


</script>

<style scoped>
@import '@/assets/Muscle.css';
</style>