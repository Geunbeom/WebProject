import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const FreeBoardReply_REST_API = 'http://localhost:8080/freeboardreply'

export const useFreeBoardReplyStore = defineStore('freeBoardReply', () => {

  // 댓글 목록
  const freeBoardReplyList = ref([])
  const getFreeBoardReplyList = function(id){
    axios.get(`${FreeBoardReply_REST_API}/${id}`)
    .then((res) => {
      freeBoardReplyList.value = res.data
    })
  }

  // 댓글 작성
  const createReply = function(id, reply){
    axios.post(`${FreeBoardReply_REST_API}/${id}`, reply)
    .then(() => {
      router.go(0)
    })
    .catch(() => {
      alert('글을 입력해주세요')
    })
  }

  // 댓글 삭제
  const deleteReply = function(rid){
    axios.delete(`${FreeBoardReply_REST_API}/reply/${rid}`)
    .then(() => {
      router.go(0)
    })
  }

  // 댓글 수정
  const updateReply = function(reply){
    axios.put(`${FreeBoardReply_REST_API}/reply`, reply)
    .then(() => {
      router.go(0)
    })
  }

  return {
    freeBoardReplyList,
    getFreeBoardReplyList,
    createReply,
    deleteReply,
    updateReply
  }
})
