import axios from 'axios'
import store from '../../src/store/store'

// axios 配置
axios.defaults.timeout = 5000;


// http request 拦截器
axios.interceptors.request.use(
  config => {
    return config;  //添加这一行
  },
  err => {
    return Promise.reject(err)
  },
);

// http response 拦截器
axios.interceptors.response.use(
  response => {
    return response
  },
  error => {
    if (error.response) {
      switch (error.response.status) {
        case 401:
          // 401 清除信息并跳转到登录页面
          alert("账号或者密码错误");
      }
    }
    return Promise.reject(error.response.data)
  },
);

export default axios
