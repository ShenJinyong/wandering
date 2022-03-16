<template>
  <Home/>
</template>

<script>
import Home from './views/home/WanderingHome.vue'

export default {
  name: 'App',
  components: {
    Home
  }
}
</script>

<style>
/* 清除html自带边距 */
body {
  margin: 0px;
  padding: 0px;
}
/* 默认字体 */
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
</style>
