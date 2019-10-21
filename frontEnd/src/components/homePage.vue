<template>
  <div>
    <div id="flash">
      <h1>幻灯片</h1>
    </div>
    <div class="wrapper">
      <div class="channel">
        <channel></channel>
      </div>
      <div class="recommend">推荐问题</div>
      <div class="other-info">
        <div id="user-info">
          <h1>userinfo</h1>
          <userinfo></userinfo>
        </div>
        <div id="big-wig">
          <h1>大神</h1>
        </div>
      </div>
    </div>

  </div>
</template>
<script>
  import channel from "./channel";
  import userinfo from "./userinfo";

  export default {
    name: 'home-page',
    components: {channel,userinfo}

  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

  .wrapper {
    width: 80%;
    margin: 10px auto;
    display: flex;
  }

  .channel {
    width: 200px;
    border: 2px solid green;

    min-width: 200px;
    min-height: 200px;
  }

  .recommend {
    width: 80%;
    min-width: 500px;
    border: 2px solid green;
    margin: 0 10px;
  }

  .other-info {
    width: 200px;
    min-width: 200px;

    display: flex;
    flex-direction: column;
  }

  #user-info {
    width: 100%;
    /*height: 150px;*/
    border: 2px solid green;
    overflow: hidden;
  }

  #big-wig {
    width: 100%;

    margin-top: 10px;
    border: 2px solid green;

  }

  #flash {
    width: 80%;
    min-width: 700px;
    height: 300px;
    border: 2px solid black;
    margin: auto;
  }

</style>
