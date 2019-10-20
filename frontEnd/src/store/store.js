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
      {path: "/father", info: "father"}
    ],
    routes_auth: [
      {path: "/", info: "主页"},
      {path: "/son", info: "son"},
      {path: "/father", info: "father"}
    ],
    username: ''

  },
  mutations: {
    update_auth(state) {
      state.username = localStorage.username;
    }

  }
})
