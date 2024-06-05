import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const RoutineBoardReply_REST_API = 'http://localhost:8080/routineboardreply'

export const useRoutineBoardReplyStore = defineStore('routineBoardReply', () => {

  // 댓글 목록
  const routineBoardReplyList = ref([])
  const getRoutineBoardReplyList = function(id){
    axios.get(`${RoutineBoardReply_REST_API}/${id}`)
    .then((res) => {
      routineBoardReplyList.value = res.data
    })
  }

  // 댓글 작성
  const createReply = function(id, reply){
    axios.post(`${RoutineBoardReply_REST_API}/${id}`, reply)
    .then(() => {
      router.go(0)
    })
    .catch(() => {
      alert('글을 입력해주세요')
    })
  }

  // 댓글 삭제
  const deleteReply = function(rid){
    axios.delete(`${RoutineBoardReply_REST_API}/reply/${rid}`)
    .then(() => {
      router.go(0)
    })
  }

  // 댓글 수정
  const updateReply = function(reply){
    axios.put(`${RoutineBoardReply_REST_API}/reply`, reply)
    .then(() => {
      router.go(0)
    })
  }

  return {
    routineBoardReplyList,
    getRoutineBoardReplyList,
    createReply,
    deleteReply,
    updateReply
  }
})
