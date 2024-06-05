import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const LIKE_ROUTINE_REST_API = 'http://localhost:8080/api-like'

export const useLikeStore = defineStore('like', () => {

  // 추천 갯수 가져오기!
  const likeList = ref([]);
  const countLike = computed(() => {
    return likeList.value.length;
  })
  const getLikeList = function(boardId) {
    axios.get(`${LIKE_ROUTINE_REST_API}/board/${boardId}`)
    .then((res) => {
      likeList.value = res.data;
    })
  }

  // 추천 했는지 확인하기!
  const check = ref();
  const getCheck = function(boardId) {
    axios.get(`${LIKE_ROUTINE_REST_API}/check`, {params: {id: 0, userId: JSON.parse(sessionStorage.getItem('loginUser'))['id'], boardId: boardId}})
    .then((res) => {
      check.value = res.data;
    })
  }

  // 좋아요 누르기
  const addLike = function(boardId) {
    if (sessionStorage.getItem('loginUser')) {
      axios.post(`${LIKE_ROUTINE_REST_API}/like`, {userId: JSON.parse(sessionStorage.getItem('loginUser'))['id'], boardId: boardId})
      .then(() => {
        getLikeList(boardId);
        getCheck(boardId);
      })
    }else alert('로그인 후 추천이 가능합니다.')
  }

  // 좋아요 안누르기
  const unLike = function(boardId) {
    if (sessionStorage.getItem('loginUser')) {
      axios.delete(`${LIKE_ROUTINE_REST_API}/unLike`, {params: {id: 0, userId: JSON.parse(sessionStorage.getItem('loginUser'))['id'], boardId: boardId}})
      .then(() => {
        getLikeList(boardId);
        getCheck(boardId);
      })
    }else alert('로그인 후 추천이 가능합니다.')
  }

  // 유저가 리스트 불러오기
  const myBoard = ref([]);
  const getMyBoard = function() {
    axios.get(`${LIKE_ROUTINE_REST_API}/user/${JSON.parse(sessionStorage.getItem('loginUser'))['id']}`)
    .then((res) => {
      myBoard.value = res.data;
    })
  }


  return {
    countLike,
    getLikeList,
    check,
    getCheck,
    addLike,
    unLike,
    getMyBoard,
    myBoard
  }
})