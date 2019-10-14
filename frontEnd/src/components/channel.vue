<template>
  <div>
    <div id="channel-list">
      <template v-for="info in listInfo">
        <div id="nav">
          <ul>
            <li>
              <a href="#">{{info.kindOfChannel}}</a>
              <ul>
                <li v-for="item in info.aa"><a href="#">{{item}}</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </template>
    </div>
  </div>
</template>
<script>
  export default {
    name: 'channel',
    data() {
      return {
        listInfo: [
          {kindOfChannel: "软件类", aa: ["C语言", "C++", "JAVA", "JavaScript", "Python", "HTML&CSS"]},
          {kindOfChannel: "硬件类", aa: ["模拟电子线路", "数字逻辑电路", "电路基础", "微处理器原理"]},
        ]
      }
    }


  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  #channel-list {
    margin-left: 10px;
    margin-top: 10px;
  }

  a {
    text-decoration: none;
  }

  a:hover {
    color: #5bc0de;
  }

  li {
    list-style: none;
  }

  /*一级菜单细节 */
  ul li {
    font-weight: bolder;
  }

  /*二级菜单总体*/
  ul li ul {
    display: none;
  }

  /*二级菜单类目*/
  ul li ul li {
    margin-left: 10px;
    margin-top: 10px;
    font-weight: normal;
  }
  ul li ul li:last-child {
    margin-bottom: 20px;

  }

  ul li:hover ul {
    display: block;
  }


</style>
