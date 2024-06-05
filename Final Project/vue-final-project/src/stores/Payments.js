import { ref, computed } from 'vue';
import { defineStore } from 'pinia';
import * as PortOne from "@portone/browser-sdk/v2";
import axios from 'axios';
import router from '@/router';

const USER_INFO_REST_API = 'http://localhost:8080/api-userInfo';

export const usePayStore = defineStore('paymnet', () => {

  async function requestPayment(mileage, price) {
    const response = await PortOne.requestPayment({
      // Store ID 설정
      storeId: process.env.storeId,
      // 채널 키 설정
      channelKey: process.env.channelKey,
      paymentId: `payment-${crypto.randomUUID()}`,
      orderName: `헬린이 키우기 ${mileage} 마일리지`,
      totalAmount: price,
      currency: "CURRENCY_KRW",
      payMethod: "EASY_PAY",
    });
  
    if (response.code != null) {
      // 오류 발생
      return ;
    }else {
      axios.put(`${USER_INFO_REST_API}/mileage`, {id: JSON.parse(sessionStorage.getItem('loginUser'))['id'], mileage: mileage})
      .then(() => {
        router.go({name:'home'});
        return alert('성공')
      })
    }
  }



  return {
    requestPayment
  }
})