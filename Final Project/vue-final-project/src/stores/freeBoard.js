import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const FreeBoard_REST_API = 'http://localhost:8080/freeboard'

export const useFreeBoardStore = defineStore('freeBoard', () => {

  // 자유 게시판 목록
  const freeBoardList = ref([])
  const getFreeBoardList = function(){
    axios.get(FreeBoard_REST_API)
    .then((res) => {
      freeBoardList.value = res.data
    })
  }

  // 자유 게시판 한 개 불러오기
  const freeBoard = ref({})
  const getFreeBoard = function(id){
    axios.get(`${FreeBoard_REST_API}/${id}`)
    .then((res) => {
      freeBoard.value = res.data
    })
  }

  // 자유 게시판 등록
  const createBoard = function(board){
    axios.post(FreeBoard_REST_API, board)
    .then(() => {
      router.push({name: 'freeBoardList'})
    })
    .catch(() => {
      alert('항목을 모두 채워주세요')
    })
  }

  // 자유 게시판 삭제
  const deleteBoard = function(id){
    axios.delete(`${FreeBoard_REST_API}/${id}`)
    .then(() => {
      router.push({name: 'freeBoardList'})
    })
  }

  // 자유 게시판 수정
  const updateBoard = function(){
    axios.put(FreeBoard_REST_API, freeBoard.value)
    .then(() => {
      router.push(`${freeBoard.value.id}`)
    })
  }

  // 루틴 검색 및 정렬
  const searchBoard = function(searchCondition) {
    axios.get(`${FreeBoard_REST_API}/search`, {params: searchCondition})
    .then((res) => {
      freeBoardList.value = res.data
    })
  }

  return {
    freeBoardList,
    getFreeBoardList,
    freeBoard,
    getFreeBoard,
    createBoard,
    deleteBoard,
    updateBoard,
    searchBoard
  }
})
