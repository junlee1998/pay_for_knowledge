import Vue from 'vue'
import App from './App'
import Router from 'vue-router'
import axios from '../static/js/http';
import login from './components/login'
import register from "./components/register";
import homePage from "./components/homePage";
Vue.use(Router);

Vue.prototype.axios = axios;
const routes1= [
  {
    path:"/",
    component:homePage
  },
  {
    path: '/login',
    component: login
  },
  {
    path: '/register',
    component: register
  }
];

let router1 = new Router({
  // mode: 'history',
  // base:"pay-for-knowledge",
routes:routes1
});


Vue.config.productionTip = false;



new Vue({
  el: '#app',
  components: { App ,login,register},
  template: '<App/>',
  router: router1
});
