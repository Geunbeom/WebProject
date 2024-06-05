import {useMuscleStore} from '@/stores/Muscle';
import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const RoutineBoard_REST_API = 'http://localhost:8080/routineboard'
const Routine_REST_API = 'http://localhost:8080/routine'

export const useRoutineBoardStore = defineStore('routineBoard', () => {

  const store = useMuscleStore();

  // 루틴 게시판 목록
  const routineBoardList = ref([])
  const getRoutineBoardList = function(){
    axios.get(RoutineBoard_REST_API)
    .then((res) => {
      routineBoardList.value = res.data
    })
  }

  // 루틴 게시판 한 개 불러오기
  const routineBoard = ref({})
  const routineDetail = ref({});
  const getRoutineBoard = function(id){
    let tmp = 0
    axios.get(`${RoutineBoard_REST_API}/${id}`)
    .then((res) => {
      routineBoard.value = res.data
      tmp = res.data.routineId
    })
    .then(() => {
      axios.get(`${Routine_REST_API}/${tmp}`)
      .then((res) => {
        routineDetail.value = res.data
      })
    })
  }

  // 루틴 게시판 등록
  const routine = ref({})
  const createBoard = function(board, routine, select){
    if(!board.title || !board.content) {
      return alert('항목을 모두 채워주세요')
    }
    axios.get(Routine_REST_API)
    .then((res) => {
      routineList.value = res.data;
      if(!select) {
        routine.part = store.part;
      }
    })
    .then(() => {
      axios.post(Routine_REST_API, routine)
        .then(() => {
          board.routineId = routineCount.value+1
        })
        .then(() => {
          axios.post(RoutineBoard_REST_API, board)
          .then(() => {
            router.push({name: 'routineBoardList'})
          })
        })
        .catch(() => {
          alert('항목을 모두 채워주세요')
        })
      })
    }

  // 루틴 게시판 삭제
  const deleteBoard = function(id){
    axios.delete(`${RoutineBoard_REST_API}/${id}`)
    .then(() => {
      router.push({name: 'routineBoardList'})
    })
  }

  // 루틴 게시판 수정
  const updateBoard = function(){
    axios.put(RoutineBoard_REST_API, routineBoard.value)
    .then(() => {
      router.push(`${routineBoard.value.id}`)
    })
  }

  // 전체 루틴 개수 출력
  const routineList = ref([]);
  const routineCount = computed(() => {
    return routineList.value.length
  })

  // 루틴 검색 및 정렬
  const searchBoard = function(searchCondition) {
    axios.get(`${RoutineBoard_REST_API}/search`, {params: searchCondition})
    .then((res) => {
      routineBoardList.value = res.data
    })
  }

  return {
    routineBoardList,
    getRoutineBoardList,
    routineBoard,
    getRoutineBoard,
    createBoard,
    deleteBoard,
    updateBoard,
    routineCount,
    routineDetail,
    searchBoard,
  }
})
