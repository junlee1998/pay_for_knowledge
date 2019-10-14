import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    routes: [
      {path: "/", info: "主页"},
      {path: "/login", info: "登录"},
      {path: "/register", info: "注册"}
    ],
    routes_auth: [
      {path: "/", info: "主页"}
    ],
    username: ''

  },
  mutations: {
    update_auth(state) {
      state.username = localStorage.username;
    }

  }
})
