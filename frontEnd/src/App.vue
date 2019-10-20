<template>
  <div id="app">
    <div id="container">
      <div id="header">
        <template v-for="routerInfo in routes_data">
          <router-link :to=routerInfo.path class="router-link">
            <p class="link-text">{{routerInfo.info}}</p>
          </router-link>
        </template>
        <a href="" style="display: inline;float: right;margin-right: 20px" class="link-text" v-if="username"
           @click="logout">{{username}}</a>
      </div>
      <div id="content">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
  import login from './components/login';
  import axios from '../static/js/http';
  import {mapState} from 'vuex'
  import store from './store/store'
  import {mapMutations} from 'vuex'


  export default {
    name: 'App',
    components: {login},
    store,
    axios,
    data() {
      return {
        routes_data: {}
      }
    },
    computed: mapState(['routes', "routes_auth", "username"]),
    methods: {
      logout() {
        localStorage.username = ''
      },
      ...mapMutations(["update_auth"]),
    },
    mounted() {
      this.update_auth();
      this.routes_data = this.username ? this.routes_auth : this.routes
    }
  }
</script>
<style>

</style>
