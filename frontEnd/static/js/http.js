import axios from 'axios'


// axios 配置
axios.defaults.timeout = 5000

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
