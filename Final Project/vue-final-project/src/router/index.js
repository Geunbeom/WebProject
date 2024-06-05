import { createRouter, createWebHistory } from 'vue-router'

import HomeView from '@/views/HomeView.vue'

// user
import UserView from '@/views/UserView.vue'
import UserRegist from '@/views/UserRegistView.vue'
import UserInfo from '@/components/User/UserInfo.vue'

// 자유게시판
import FreeBoardView from '@/views/FreeBoardView.vue'
import FreeBoardList from '@/components/FreeBoard/FreeBoardList.vue'
import FreeBoardDetail from '@/components/FreeBoard/FreeBoardDetail.vue'
import FreeBoardCreate from '@/components/FreeBoard/FreeBoardCreate.vue'
import FreeBoardUpdate from '@/components/FreeBoard/FreeBoardUpdate.vue'

// 루틴게시판
import RoutineBoardView from '@/views/RoutineBoardView.vue'
import RoutineBoardList from '@/components/RoutineBoard/RoutineBoardList.vue'
import RoutineBoardDetail from '@/components/RoutineBoard/RoutineBoardDetail.vue'
import RoutineBoardCreate from '@/components/RoutineBoard/RoutineBoardCreate.vue'
import RoutineBoardUpdate from '@/components/RoutineBoard/RoutineBoardUpdate.vue'

// 게임
import GameView from '@/views/GameView.vue'
import GameMain from '@/components/game/GameMain.vue'
import MiniGame from '@/components/game/MiniGame.vue'
import GameShop from '@/components/game/GameShop.vue'

// 내 정보
import MyInfo from '@/components/User/MyInfo.vue'
import MyAttend from '@/components/User/MyAttend.vue'
import MyBoard from '@/components/User/MyBoard.vue'
import MyRoutine from '@/components/User/MyRoutine.vue'
import Attend from '@/components/User/Attend.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/freeboard',
      name: 'freeBoard',
      component: FreeBoardView,
      children: [
        {
          path: '',
          name: 'freeBoardList',
          component: FreeBoardList,
        },
        {
          path: ':id',
          name: 'freeBoardDetail',
          component: FreeBoardDetail,
        },
        {
          path: 'create',
          name: 'freeBoardCreate',
          component: FreeBoardCreate,
          beforeEnter: (to, from) => {
            if(!sessionStorage.getItem('loginUser')) {
              alert('로그인 후 이용해주세요.')
              return from;
            }
          }
        },
        {
          path: 'update',
          name: 'freeBoardUpdate',
          component: FreeBoardUpdate,
        }
      ]
    },
    {
      path: '/routineboard',
      name: 'routineBoard',
      component: RoutineBoardView,
      children: [
        {
          path: '',
          name: 'routineBoardList',
          component: RoutineBoardList,
        },
        {
          path: ':id',
          name: 'routineBoardDetail',
          component: RoutineBoardDetail,
        },
        {
          path: 'create',
          name: 'routineBoardCreate',
          component: RoutineBoardCreate,
          beforeEnter: (to, from) => {
            if(!sessionStorage.getItem('loginUser')) {
              alert('로그인 후 이용해주세요.')
              return from;
            }
          }
        },
        {
          path: 'update',
          name: 'routineBoardUpdate',
          component: RoutineBoardUpdate,
        }
      ]
    },
    {
      path: '/game',
      name: 'game',
      component: GameView,
      beforeEnter: (to, from) => {
        if(!sessionStorage.getItem('loginUser')) {
          alert('로그인 후 이용해주세요.')
          return from;
        }
      },
      children: [
        {
          path: '',
          name: 'gameMain',
          component: GameMain,
        },
        {
          path: 'miniGame',
          name: 'miniGame',
          component: MiniGame,
        },
        {
          path: 'gameShop',
          name: 'gameShop',
          component: GameShop,
        }
      ]
    },
    {
      path: '/regist',
      name: 'userRegist',
      component: UserRegist,
      beforeEnter: (to, from) => {
        if(sessionStorage.getItem('loginUser')) {
          alert('로그아웃 후 이용해주세요.')
          return from;
        }
      }
    },
    {
      path: '/user',
      name: 'user',
      component: UserView,
      children: [
        {
          path: 'userInfo',
          name: 'userInfo',
          component: UserInfo,
          beforeEnter: (to, from) => {
            if(!sessionStorage.getItem('loginUser')) {
              alert('로그인 후 이용해주세요.')
              return from;
            }
          },
          children: [
            {
              path: 'info',
              name: 'myInfo',
              component: MyInfo
            },
            {
              path: '',
              name: 'myAttend',
              component: MyAttend,
              children: [
                {
                  path: 'attend',
                  name: 'doAttend',
                  component: Attend
                }
              ]
            },
            {
              path: 'like',
              name: 'myBoard',
              component: MyBoard
            },
            {
              path: 'routine',
              name: 'myRoutine',
              component: MyRoutine
            }
          ]
        },
      ]
    }
  ]
})

export default router