<template>
  <div class="container">
    <div id="comp-content">
      <form action="" method="post" @submit.prevent="axios_request">
        <template v-for="item in node">
          <div :id="item.divID">
            <input :type=item.type class="form-item" :name=item.name :id="item.name"
                   :placeholder="item.placeholderText"
                   :pattern=item.pattern
                   required>
          </div>
        </template>
        <button type="submit" class="btn" id="submit">提交</button>
        <button type="reset" class="btn">复位</button>
        <div>
          <router-link to="/register">还没有账号?立即注册</router-link>
        </div>
      </form>
    </div>
  </div>
</template>
<script>
  import axios from '../../static/js/http'

  export default {
    name: 'login',
    data: function () {
      return {
        node: [
          {
            divID: 'username-div',
            labelText: '用户名:',
            name: 'username',
            placeholderText: 'username',
            type: 'text',
            pattern: "^[0-9a-zA-Z]{6,15}$"
          },
          {
            divID: 'password-div',
            labelText: '密码:',
            name: 'password',
            placeholderText: 'password',
            type: 'password',
            pattern: "^[0-9a-zA-Z]{6,}$",
          }
        ],
        post_data: {
          username: {},
          password: {}
        }
      }
    },
    axios,
    methods: {
      axios_request() {
        //开始前获取表单输入的用户名和密码
        for (let i in this.post_data) {
          this.post_data[i] = document.getElementById(i).value;
        }
        //封装params
        var params = new URLSearchParams();
        params.append('username', this.post_data.username);
        params.append('password', this.post_data.password);
        //配置并发起axios请求
        axios({
          method: "post",
          url: "/api/pay_for_knowledge_war_exploded/login",
          params
        })
        //执行到这一步时,账号和密码的验证已经通过了
          .then((response) => {
            localStorage.setItem("username",params.get("username"));
            location.href = "http://localhost:8080/";
          })
          //解析服务器返回的response,并且做出相应的处理
          .catch(error => {
            console.log("error:" + error)
          })
      }
    }
  }
</script>

<style scoped>
  #comp-content {
    width: 30%;
    margin: 20px auto;
  }
</style>
