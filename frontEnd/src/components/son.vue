<template>
  <div>
    name:{{sonColor}}<br>
    <button @click="changeName">toGreen</button>
  </div>
</template>

<script>

  export default {
    name: "son",
    data() {
      return {
        sonColor: this.color
      }
    },
    props: ['color'],
    methods: {
      changeName() {
        console.log(this.sonColor);
        this.sonColor= "green";
        console.log(this.sonColor)
      }
    },
    mounted() {
      console.log(this.color)
    },
    watch: {
      color(val) {
        this.sonColor = val;//新增result的watch，监听变更并同步到myResult上
      },
      sonColor(val) {
        // this.$emit('get-son-color',val)
        console.log("val:"+val)
        this.$emit("getSonColor",val)
      }
    }
  }
</script>

<style scoped>

</style>
