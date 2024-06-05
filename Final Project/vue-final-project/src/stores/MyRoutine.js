import {useMuscleStore} from '@/stores/Muscle';
import { ref, computed } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';
import router from '@/router';

const MY_ROUTINE_REST_API = 'http://localhost:8080/api-myRoutine';
const USER_INFO_REST_API = 'http://localhost:8080/api-userInfo';

export const useMyRoutineStore = defineStore('myRoutine', () => {
    
    const store = useMuscleStore();

    // 루틴 저장하기
    const saveMyRoutine = function(routineId) {
        axios.post(`${MY_ROUTINE_REST_API}/myRoutine`, {userId: JSON.parse(sessionStorage.getItem('loginUser'))['id'], routineId: routineId})
        .then(() => {
            alert('저장 되었습니다.')
        })
        .catch(() => {
            alert('이미 저장된 루트입니다.')
        })
    }

    // 나의 루틴 불러오기
    const myRoutineList = ref([]);
    const getMyRoutineList = function() {
        axios.get(`${MY_ROUTINE_REST_API}/myRoutineList`, {params: {userId: JSON.parse(sessionStorage.getItem('loginUser'))['id']}})
        .then((res) => {
            myRoutineList.value = res.data;
        })
    }

    // 루틴 삭제하기
    const deleteRoutine = function(routineId) {
        axios.delete(`${MY_ROUTINE_REST_API}/myRoutine`, {params: {userId: JSON.parse(sessionStorage.getItem('loginUser'))['id'], routineId: routineId}})
        .then(() => {
            getMyRoutineList();
        })
    }
    
    
    
    // 출석 정보
    const attend = ref([])
    for(let d = 0 ; d < 10 ; d++){
        attend.value[d] = {
            date: '',
            check: 0
        }
    }

    // 풀심기
    const getToday = ref(false);
    const attendDetail = ref({})
    const getAttend = function() {
        axios.get(`${MY_ROUTINE_REST_API}/attendlist`, {params: {userId: JSON.parse(sessionStorage.getItem('loginUser'))['id']}})
        .then((res) => {
            let date = new Date()
            date.setDate(date.getDate() - 10)
            loop:
            for(let d = 0 ; d < 10 ; d++){
                date.setDate(date.getDate() + 1)
                let dateStr = `${date.getFullYear()}-${('0' + (date.getMonth() + 1)).slice(-2)}-${('0' + date.getDate()).slice(-2)}`
                for(let i = 0 ; i < res.data.length ; i++){
                    if(dateStr == res.data[i].regDate){
                        axios.get(`${MY_ROUTINE_REST_API}/attend/date`, {params: {userId: JSON.parse(sessionStorage.getItem('loginUser'))['id'], regDate: dateStr}})
                        .then((res) => {
                            attendDetail.value = res.data
                            attend.value[d] = {
                                date: dateStr,
                                check: 1,
                                part: res.data.part,
                                detail: res.data.detail,
                                sets: res.data.sets,
                                count: res.data.count
    
                            }
                        })
                        .then(() => {
                            if (attend.value[9].check === 1) {
                                getToday.value = true;
                            }
                        })
                        continue loop
                    }
                }
                attend.value[d] = {
                    date: dateStr,
                    check: 0
                }
            }
        })
    }

    // 출석하기
    const check = ref(false);
    const myRoutine = ref({
        sets: 0,
        count: 0
    });

    // 출석하기
    const doAttend = function(select) {
      axios.get('http://localhost:8080/routine')
      .then((res) => {
        routineList.value = res.data;
        if(!select) {
            myRoutine.value.part = store.part;
        }
        if(partNum2) {
            myRoutine.value.part = store.part;
        }
      })
      .then(() => {
        axios.post('http://localhost:8080/routine', myRoutine.value)
        .then(() => {
            axios.post(`${MY_ROUTINE_REST_API}/attend`, {userId: JSON.parse(sessionStorage.getItem('loginUser'))['id'], routineId: routineCount.value+1})
            .then(() => {
                alert('출석 완료!')
                axios.put(`${USER_INFO_REST_API}/mileage`, {id: JSON.parse(sessionStorage.getItem('loginUser'))['id'], mileage: 700})
                .then(() => {
                    router.go(0)
                })
            })
        })
        .catch(() => {
          alert('항목을 모두 입력해주세요');
        })
      })
    }
    
    // 루틴 등록하기
    const doRegist = function(select) {
        axios.get('http://localhost:8080/routine')
        .then((res) => {
          routineList.value = res.data;
          if(!select) {
            myRoutine.value.part = store.part;
          }
        })
        .then(() => {
          axios.post('http://localhost:8080/routine', myRoutine.value)
          .then(() => {
              saveMyRoutine(routineCount.value+1);
              router.go(0);
          })
          .catch(() => {
            alert('항목을 모두 입력해주세요');
          })
        })
      }

    // 루틴 불러오기
    const loadRoutine = function(routine) {
        if(!getToday.value) {
            myRoutine.value = routine;
            check.value = true;
            store.partNum = partNum2.value;
            router.push({name:"myAttend"})
        }else {
            alert('이미 오늘 출석을 했습니다.')
        }
    }

    const partNum2 = computed(() => {
        if(myRoutine.value.part === "어깨") {
            return 2;
        }else if (myRoutine.value.part === "팔") {
            return 3;
        }else if (myRoutine.value.part === "전완근") {
            return 4;
        }else if (myRoutine.value.part === "가슴") {
            return 5;
        }else if (myRoutine.value.part === "등") {
            return 6;
        }else if (myRoutine.value.part === "복근") {
            return 7;
        }else if (myRoutine.value.part === "하체") {
            return 8;
        }else {
            return 0;
        }
    })


    // 전체 루틴 개수 출력
    const routineList = ref([]);
    const routineCount = computed(() => {
        return routineList.value.length
    })



    return {
        saveMyRoutine,
        getMyRoutineList,
        myRoutineList,
        deleteRoutine,
        attend,
        getAttend,
        attendDetail,
        doAttend,
        getToday,
        myRoutine,
        loadRoutine,
        check,
        doRegist
      }
})