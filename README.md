# pay_for_knowledge

> A Vue.js project

## Build Setup

``` bash
# install dependencies
npm install

# serve with hot reload at localhost:8080
npm run dev

# build for production with minification
npm run build

# build for production and view the bundle analyzer report
npm run build --report
```

For a detailed explanation on how things work, check out the [guide](http://vuejs-templates.github.io/webpack/) and [docs for vue-loader](http://vuejs.github.io/vue-loader).

#小说法--使用经验总结
``` bash
#在App.vue中引用其他组件时
1.需要先import
2.然后再注册组件
3.最后才可以使用
4.而在App.vue中不需要import vue-router,只需要再最后的main.js中引入,并且使用Vue.use()注册组件即可
```
``` bash
同时启动tomcat和node服务器,不需要run dev build
#node端口
8080
#tomcat端口
8060
```
