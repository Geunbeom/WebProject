import { ref, computed } from 'vue';
import { defineStore } from 'pinia';
import router from '@/router';
import axios from 'axios';

const USER_REST_API = 'http://localhost:8080/api-user';

export const useUserStore = defineStore('user', () => {

  // 로그인 검사.
  const checkLogin = computed(() => {
    if (sessionStorage.getItem('loginUser')) {
      return false;
    }
    return true;
  });

  // 로그인 정보를 세션에 저장.
  const loginUser = computed(() => {
    let user = JSON.parse(sessionStorage.getItem('loginUser'));
    if (user !== null)
    return {
      id: user['id'],
      name: user['name'],
      nickName: user['nickName'],
    }
    else
    return {
      id: '',
      name: '',
      nickName: ''
    }
  });

  // 로그인
  const doLogin = function(user) {
    axios.post(`${USER_REST_API}/login`, user)
    .then(() => {
      axios.get(`${USER_REST_API}/user/${user.id}`)
      .then((res) => {
        sessionStorage.setItem('loginUser', JSON.stringify({id: res.data['id'], name: res.data['name'], nickName: res.data['nickName']}));
        alert(`${res.data['name']}님 반갑습니다.`);
        router.go(router.currentRoute);
      })
    })
    .catch(() => {
      alert('아이디 또는 비밀번호가 일치하지 않습니다.');
    })
  }

  // 세션 삭제 (로그아웃)
  const doLogout = function() {
    sessionStorage.removeItem('loginUser');
    currUserInfo.value = ref({});
    router.push({name: 'home'});
    router.go(0);
  }

  // 유저 등록
  const registUser = function(user) {
    axios.post(`${USER_REST_API}/regist`, user)
    .then(() => {
      axios.post('http://localhost:8080/api-userInfo/regist', {id: user.id})
      .then(() => {
        alert('회원 등록에 성공했습니다.');
        router.push({name:'home'});
      })
    })
    .catch((res) => {
      if (res.response['status'] === 500) {
        alert('빈 항목을 채워주세요');
      }else {
        alert(res.response['data']);
      }
    })
  }

  // 유저 정보
  const currUserInfo = ref({});
  const getUser = function() {
    axios.get(`${USER_REST_API}/user/${loginUser.value['id']}`)
    .then((res) => {
      if (currUserInfo.value !== res.data) {
        currUserInfo.value = res.data;
      }
    })
  }

  // 유저 정보 수정
  const doUpdate = function() {
    axios.put(`${USER_REST_API}/update`, currUserInfo.value)
    .then(() => {
      alert('수정 완료되었습니다.');
      sessionStorage.setItem('loginUser', JSON.stringify({id: currUserInfo.value['id'], name: currUserInfo.value['name'], nickName: currUserInfo.value['nickName']}));
      router.go(router.currentRoute);
    })
    .catch((res) => alert(res.response['data']))
  }

  return {
    loginUser,
    doLogin,
    checkLogin,
    registUser,
    doLogout,
    getUser,
    currUserInfo,
    doUpdate
  }
})
