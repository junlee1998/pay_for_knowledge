<template>
  <div id="comp-content">
    <form action="/api/pay_for_knowledge_war_exploded/login" method="get">
      <template v-for="item in node">
        <div :id="item.divID">
          <input :type=item.type class="form-item" :name=item.name :id="item.name"
                 :placeholder="item.placeholderText"
                 :pattern=item.pattern
                 @focus="item.focusF?item.focusF():null"
                 required>
        </div>
      </template>
      <input type="radio" class="gender" name="gender" value="1" checked>男
      <input type="radio" class="gender" name="gender" value="0">女
      <div></div>
      <button type="submit" class="btn" id="submit">注册</button>
      <button type="reset" class="btn">复位</button>
      <router-link to="/login">已有帐号?立即登录</router-link>
    </form>
  </div>
</template>
<script>
  import store from '../store/store.js';
  import {mapState} from 'vuex'

  export default {
    name: 'register',
    data() {
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
            type: 'text',
            pattern: "^[0-9a-zA-Z]{6,}$",
            // focusF:this.twiceCheck.bind(null,this.password,this.password_reput)
            focusF: this.twiceCheck.bind(null, "password", "password_reput")
          },
          {
            divID: 'password_reput-div',
            labelText: '确认密码:',
            name: 'password_reput',
            placeholderText: 'password_reput',
            type: 'text',
          },
          {
            divID: 'tel-div',
            labelText: '手机:',
            name: 'tel',
            placeholderText: 'tel',
            type: 'text',
            pattern: "(\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$"
          },
          {
            divID: 'email-div',
            labelText: 'email:',
            name: 'email',
            placeholderText: 'email',
            type: 'email'
          },
          {
            divID: 'transaction_password-div',
            labelText: '交易密码:',
            name: 'transaction_password',
            placeholderText: 'transaction_password',
            type: 'text',
            pattern: "^[0-9a-zA-Z]{6,}$",
            focusF: this.twiceCheck.bind(null, "transaction_password", "transaction_password_reput")
          },
          {
            divID: 'transaction_password_reput-div',
            labelText: '确认交易密码:',
            name: 'transaction_password_reput',
            placeholderText: 'transaction_password_reput',
            type: 'text',
            pattern: "^[0-9a-zA-Z]{6,}$"
          },
        ],
        password: {},
        password_reput: {},
        transaction_password: {},
        transaction_password_reput: {}
      };
    },
    store,
    methods: {
      // checkTwice,
      // checkInput,
      twiceCheck
    },
    mounted() {
      this.password = document.getElementById("password");
      this.password_reput = document.getElementById("password_reput");
      this.transaction_password = document.getElementById("transaction_password");
      this.transaction_password_reput = document.getElementById("transaction_password_reput");
    }
  }
</script>
<style scoped>
  #comp-content {
    width: 30%;
    margin: 20px auto;
  }
</style>
