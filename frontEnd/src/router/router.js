import Vue from 'vue'
import Router from 'vue-router'
import login from "../components/login";
import homePage from "../components/homePage";
import register from "../components/register";
import father from "../components/father";
import son from "../components/son";
import store from "../store/store";
import userinfo from "../components/userinfo";



Vue.use(Router);

const routes = [
  {
    path: "/",
    component: homePage
  },
  {
    path: '/login',
    component: login,
    meta: {
      afterLogin: true
    }
  },
  {
    path: '/register',
    component: register,
    meta: {
      afterLogin: true
    }
  },
  {
    path: '/father',
    component: father,
    meta: {
      requireAuth: true
    }
  },
  {
    path: '/son',
    component: son
  },
  {
    path: '/userinfo',
    component: userinfo
  }
];

let router = new Router({
  routes: routes
});

router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.requireAuth)) {
    //判断是否需要先登录 才能访问的页面
    if (store.state.username) {//登陆后的标志
      next();
    }
    else {
      next({
        path: '/login',
        query: {redirect: to.fullPath}
      })
    }
  } else if ((to.matched.some(record => record.meta.afterLogin))) {
    //判断是否登录后就不能访问了
    if (store.state.username) {
      //登陆后的标志,如果已经登陆了.再访问Login时,自动导航到首页
      next({
        path: '/',
        query: {redirect: to.fullPath}
      });
    }else{
      //否则进入目标页面
      next();
    }
  }else {
    next()
  }
});

export default router;
