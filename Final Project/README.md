<div align="center">
<h2> FITNESS CHILD 프로젝트 🚩</h2>
</div>
</br>

## 📑 개요

- 프로젝트 명 : FITNESS CHILD
  
- 프로젝트 한 줄 소개 : 운동 루틴 커뮤니티 사이트
  
- 프로젝트 일시 : 2024.05.13 ~ 2024.05.24
  
  </br>
  

## 👥 멤버 소개

**1. 김성현(Java 비전공)**
- Front : Main, MiniGame, Attend, Rank
- Back : Board, Reply, Search, MiniGame

**2. 서근범(Java 비전공)**
- Front : Board, Routine, Login, Like(추천), Routine Avatar, Payments API
- Back : User, User-info, Routine, MiniGame, Attend, Like

**3. 공통 작업**
- 아이디어 회의
- ERD, Schema 설계
- 화면 설계
- UseCase
   
</br>

## 🚩 팀 공통 목표

- 명세서 작성, 아이디어 회의.
- 로그인, 로그아웃, 회원등록 구현
- 게시판, 댓글 CRUD 및 추천, 검색 구현
- 출석, 루틴 저장, 공유
- 미니게임, 결제 API 구현

</br>

## 🔍 기술 스택

- MySQL : DB Schema, ERD 작성
- Vue.js : 프론트 프레임워크 이용
- Spring Boot : REST API 개발
- CSS : 바닐라, inline 형식 (css 기술 향상을 위해)

</br>

## ✔ Spring
![Spring01](https://github.com/Geunbeom/WebProject/assets/160552393/581c5adc-5f18-4a5a-b898-eab74cf21ab9)
![Spring02](https://github.com/Geunbeom/WebProject/assets/160552393/9ee58f29-247b-4644-87a5-22a4954feadb)

</br>

## ✔ Schema
![Schema01](https://github.com/Geunbeom/WebProject/assets/160552393/1e633c92-e02d-4685-8837-54a842011952)

</br>

## ✔ Vue
![Vue01](https://github.com/Geunbeom/WebProject/assets/160552393/77a8d1af-069f-4128-b1a2-4f6b5d42f921)
![Vue02](https://github.com/Geunbeom/WebProject/assets/160552393/5fbfd427-2621-42f0-a5c6-086840b8443b)


</br>

## ✔ RESTful API
![RestAPI01](https://github.com/Geunbeom/WebProject/assets/160552393/eafe58eb-0e27-4d2f-8fa2-0a472eb20f7d)

</br>

## ✔ Detail

**1. Board Detail**
![detail](https://github.com/Geunbeom/WebProject/assets/160552393/e3fee263-878e-4156-bc4a-98d27bb0acb8)
  - 로그인 유저 게시글 추천 기능 (추천한 게시글만 모아 볼 수도 있다.)
  - 게시글 등록 시 루틴도 함께 등록
  - 아바타를 이용한 운동 부위 설정 가능
  - 루틴만 저장하여 저장한 루틴에서 확인 가능

</br>
</br>

**2. Attend**
![Attend](https://github.com/Geunbeom/WebProject/assets/160552393/86ece31a-eebb-4574-9ea4-3c388503181a)
  - 출석 날짜 Hover 시 불투명한 박스로 해당 일자에 등록한 루틴을 간략하게 표시 (마우스 옆에 표시)
  - 출석 날짜 클릭 시 해당 날짜에 등록한 루틴의 디테일
  - 오늘 일자부터 10일 전 까지 표시 (빈칸은 출석 안 한 일자)
  - 출석 시 마일리지 지급 (마일리지 : 미니게임에서 EXP 습득 가능)
  - 랭크 별로 출석, EXP bar 가 다른 색상으로 표기
  - 직접 루틴을 등록하며 출석하거나 저장한 루틴에서 출석하기 가능

</br>
</br>

**3. Mini game**
![Minigame01](https://github.com/Geunbeom/WebProject/assets/160552393/f0630c59-4ea4-4020-acb6-52012e73dd9e)
![MiniGame02](https://github.com/Geunbeom/Baekjoon/assets/160552393/5dbd8347-8434-4a5b-bd44-113cfebfdf15)
  - 마일리지를 소모하여 EXP 획득, 일정 경험치 누적 시 랭크 업 (랭크 이미지와 색상이 바뀐다)
  - 운동하기 : 확률형 시스템, 확률 별로 EXP 습득량이 다름
  - 프로틴먹기 : 100 % 확률로 EXP 획득 (운동하기 보다 적은 EXP)
  - 미니게임 : 제한 시간 동안 랜덤한 위치에서 생성되는 버튼 클릭 (에임 연습 게임과 비슷), HighScore
  - 상점 : 마일리지를 결제하여 구매할 수 있는 상점.

</br>
</br>

**4. Payments**
![Payments](https://github.com/Geunbeom/Baekjoon/assets/160552393/da7b42e0-6b05-419e-b6d1-6ae26e4b021c)
  - IAMPORT 기반 결제 API, Kakao 간편 결제, 실제 동작 가능(Test 결제이므로 실제 결제는 되지 않는다.)

</br>
</br>

## 📌 겪었던 어려움과 해결 과정

1. **겪었던 어려움**
  - 디자인 : 구현은 대부분 완성도 있게 하였으나 디자인 기술 부족으로 이목을 끌만한 이미지를 만들지 못하였다.
  - 역량 : 처음 진행하는 프로젝트이고, 팀원이 개발 역량에 부족한 상태로 시작했기에 초반 설계시 아이디어 회의, 화면의 구체화 등 어려움이 있었다.

2. **해결 과정**
  - 부족한 디자인에 힘쓰기 보다 개발 역량 향상을 목표하여 더 많고 디테일한 구현을 실현시켰다. (출석 Hover 시스템, MiniGame, 확률 시스템, 랭크, 아바타를 이용한 운동 부위 설정)
  - 비록 세련된 이미지는 아니지만, 오히려 B급 감성의 사이트가 만들어져 이목을 끌 수 있었다.
  - 생각하는 이미지를 그림으로 구체화 시키고, 개발 역량을 팀원에게 최대한 알려주며 시작하였다. 팀원이 시작은 느렸지만 적용력이 뛰어나 금방 어려운 구현도 해낼 수 있었다.

</br>


## 🏆 앞으로의 목표
  - 첫 프로젝트라 ERD 및 Schema 가 체계적이지 못하였다. 해당 부분을 다듬어 두 개로 나뉜 Board를 통합해볼 것이다. (Reply table 도 마찬가지)
  - 단 기간의 프로젝트로 미니게임이 부실하였지만, 캐릭터 커스텀을 추가해볼 예정이다.
  - Vue 기반 프론트 설계를 하였지만 현업에서 React도 많이 사용하는 것을 알게 되었다. React 공부를 마치면 해당 프로젝트를 React로도 바꾸어 설계할 예정이다.
  - 배포에 대한 학습 부족으로 코딩만 해두었다. AWS, Docker 등의 배포 학습을 하여 더욱 가다듬고 배포하는 연습을 해볼 예정이다.

</br>

## 💓 소감
  
- 처음 진행한 프로젝트이고, 2주일이라는 단 기간동안 진행하여 걱정이 많았지만, 잘 하는 팀원과 하게 되어 목표하는 구현을 모두 실현시켰다.
- CRUD와 로그인 관련된 내용만 배운 상태로 진행하였지만 응용력과 자기주도 학습을 통해 더 심화 과정을 구현시킬 수 있었다.
- 현업에서는 더 획기적이고 어려운 구현을 다루어야 할 수 있지만, 이번 프로젝트를 통해 충분히 다룰 수 있겠다는 자신감이 생겼다.
