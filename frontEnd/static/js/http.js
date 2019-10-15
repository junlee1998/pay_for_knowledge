/**
 * Created by superman on 17/2/16.
 * http配置
 */

import axios from 'axios'
// import store from './store/store'
// import * as types from './store/types'

// axios 配置
axios.defaults.timeout = 5000
// axios.defaults.baseURL = 'https://api.github.com'

// http request 拦截器
axios.interceptors.request.use(
  config => {
    return config;  //添加这一行
  },
  err => {
    return Promise.reject(err)
  },
);

export default axios
