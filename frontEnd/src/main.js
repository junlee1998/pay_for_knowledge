import Vue from 'vue'
import App from './App'
import Router from 'vue-router'
import axios from '../static/js/http';
// import homePage from "./components/homePage";
// import login from "./components/login";
// import register from "./components/register";
// import father from "./components/father";
// import son from "./components/son";
// import store from "./store/store";
import router from "./router/router";

Vue.use(Router);
Vue.prototype.axios = axios;
Vue.config.productionTip = false;





new Vue({
  el: '#app',
  components: {App},
  template: '<App/>',
  router: router
});
