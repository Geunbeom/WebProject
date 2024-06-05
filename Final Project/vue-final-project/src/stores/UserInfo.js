import { ref, computed } from 'vue';
import { defineStore } from 'pinia';
import router from '@/router';
import axios from 'axios';

const USER_INFO_REST_API = 'http://localhost:8080/api-userInfo';

export const useUserInfoStore = defineStore('userInfo', () => {

  // 유저 정보
  const currUserInfo = ref({
    id:'',
    mileage: 0,
    exp: 0,
    rate: 0,
    highscore: 0
  });

  // 유저 가져오기
  const getInfo = function() {
    axios.get(`${USER_INFO_REST_API}/${JSON.parse(sessionStorage.getItem('loginUser'))['id']}`)
    .then ((res) => {
      if(currUserInfo.value.id!='' && res.data.rate > currUserInfo.value.rate){
        alert("축하합니다! 회원등급이 올랐습니다.")
      }
      currUserInfo.value = res.data;
    })
  }

  // 랭크
  const rankList = ref([]);
  const getRank = function() {
    axios.get(`${USER_INFO_REST_API}/rank`)
    .then((res) => {
      rankList.value = res.data;
    })
  }

  // 운동하기
  const game1 = function(prob, reward) {
    if(currUserInfo.value.mileage < 100) {
      alert("마일리지가 부족합니다")
      router.go(0)
    }
    else{
      axios.put(`${USER_INFO_REST_API}/mileage`, {
        id: JSON.parse(sessionStorage.getItem('loginUser'))['id'],
        mileage: -100
      })
      .then(() => {
        if(Math.random() < prob){
          axios.put(`${USER_INFO_REST_API}/exp`, {
            id: JSON.parse(sessionStorage.getItem('loginUser'))['id'],
            exp: reward
          })
          .then(() =>{
            setTimeout(function() {
              alert(`운동 성공!! 경험치 ${reward}을 획득했습니다.`)
              getInfo()
              router.go(0)
            }, 2400)
          })
          .then(() => {
          })
        }
        else{
          setTimeout(function() {
            alert("운동 실패!! 경험치를 획득하지 못했습니다.")
            router.go(0)
          }, 2400)
        }
      })
    }
  }
  
  // 프로틴먹기
  const game2 = function(price, reward) {
    if(currUserInfo.value.mileage < price) {
      alert("마일리지가 부족합니다")
      router.go(0)
    }
    else{
      axios.put(`${USER_INFO_REST_API}/mileage`, {
        id: JSON.parse(sessionStorage.getItem('loginUser'))['id'],
        mileage: -price
      })
      .then(() => {
        axios.put(`${USER_INFO_REST_API}/exp`, {
          id: JSON.parse(sessionStorage.getItem('loginUser'))['id'],
          exp: reward
        })
        .then(() =>{
          alert(`프로틴을 먹고 기분이 좋아졌습니다! 경험치 ${reward}을 획득했습니다.`)
          getInfo()
        })
      })
    }
  }

  // 마일리지 획득
  const addMileage = function(price){
    axios.put(`${USER_INFO_REST_API}/mileage`, {
      id: JSON.parse(sessionStorage.getItem('loginUser'))['id'],
      mileage: price
    })
    .then(() => {
      getInfo()
    })
  }

  // 하이스코어 갱신
  const newHighscore = function(score){
    axios.put(`${USER_INFO_REST_API}/highscore`, {
      id: JSON.parse(sessionStorage.getItem('loginUser'))['id'],
      highscore: score
    })
    .then(() => {
      getInfo()
    })
  }

  // 미니게임 랭킹 가져오기
  const scoreRankList = ref([]);
  const getScoreRank = function() {
    axios.get(`${USER_INFO_REST_API}/highscore/rank`)
    .then((res) => {
      scoreRankList.value = res.data;
    })
  }

  return {
    currUserInfo,
    getInfo,
    rankList,
    getRank,
    game1,
    game2,
    addMileage,
    newHighscore,
    scoreRankList,
    getScoreRank,

  }
})
