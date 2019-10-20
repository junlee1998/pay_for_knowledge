<template>
  <div>
    <h1>son</h1>
    <son :color=color></son>
    <son @getSonColor="getSonColor1"></son>
    <hr>
    <h1>father</h1>
    color:{{color}}<br>
    <button @click="changeColor">toBlack</button>
    <button>getSonColor1</button>
  </div>
</template>
<script>
  import son from "./son"

  export default {
    name: "father",
    components: {son},
    data() {
      return {
        color: 'red'
      }
    },
    methods: {
      changeColor() {
        this.color = "black"
      },
      getSonColor1(val) {
        console.log("faCol:" + val)
        this.color = val
      }

    }
  }
</script>

<style scoped>

</style>
