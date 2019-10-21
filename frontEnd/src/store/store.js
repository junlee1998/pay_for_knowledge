import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    routes: [
      {path: "/", info: "主页"},
      {path: "/login", info: "登录"},
      {path: "/register", info: "注册"},
      {path: "/son", info: "son"},
      {path: "/father", info: "father"},
      {path: "/userinfo", info: "个人信息"}
    ],
    routes_auth: [
      {path: "/", info: "主页"},
      {path: "/son", info: "son"},
      {path: "/father", info: "father"},
      {path: "/userinfo", info: "个人信息"}
    ],
    username: ''

  },
  mutations: {
    update_auth(state) {
      state.username = localStorage.username;
    },
    logout(state) {
      localStorage.username = '';
      state.username = "";
    }
  }
})
