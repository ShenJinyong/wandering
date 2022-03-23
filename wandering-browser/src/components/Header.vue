<template>
    <el-header>
    <el-row :gutter="20">
      <el-col :span="3" class="wandering-name">
          流浪所
      </el-col>
      <el-col :span="15" class="wandering-home">
        <el-link type="info">首页</el-link>
        <el-link type="primary">新闻</el-link>
        <el-link type="success">博问</el-link>
        <el-link type="warning">专区</el-link>
        <el-link type="danger">闪存</el-link>
        <el-link type="info">班级</el-link>
        <el-link type="info" href="https://github.com/ShenJinyong/wandering" target="_blank">友链</el-link>
      </el-col>
      <el-col :span="4" class="wandering-search">
        <el-input v-model="input" placeholder="代码改变世界"></el-input>
      </el-col>
      <el-col :span="2" class="wandering-login">
        <el-link type="primary">注册</el-link>
        <el-link type="success">登录</el-link>
      </el-col>
    </el-row>
  </el-header>
</template>

<script>
export default {
  name: 'WanderingHome',
  data() {
    return {
      input: ''
    }
  }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>