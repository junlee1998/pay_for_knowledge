<template>
  <div>
    <template v-for="(info,key) in $data">
      <h4>{{key}}:{{info}}</h4>
    </template>
  </div>
</template>

<script>
  import axios from '../../static/js/http'

  export default {
    name: "userinfo",
    data() {
      return {
        username: '',
        gender: '',
        tel: '',
        email: '',
        balance: ''
      }
    },
    axios,
    mounted() {
      var params = new URLSearchParams();
      params.append('username', localStorage.username);
      //配置并发起axios请求
      axios({
        method: "post",
        url: "/api/pay_for_knowledge_war_exploded/show",
        params
      })
      //解析服务器返回的response,并且做出相应的处理
        .then((response) => {
          for (let i in this.$data) {
            this.$data[i] = response.headers[i];
          }

        }).catch(error => {
        document.write(error)
      })
    }
  }
</script>

<style scoped>

</style>
