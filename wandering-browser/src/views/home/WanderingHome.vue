<template>
<el-container>
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
      <el-col :span="4"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="2"><div class="grid-content bg-purple"></div></el-col>
    </el-row>
  </el-header>
  <el-container>
    <el-aside width="200px">

    </el-aside>
    <el-main>

    </el-main>
    <el-aside width="300px">

    </el-aside>
  </el-container>
  <el-footer>

  </el-footer>
</el-container>
</template>

<script>
export default {
  name: 'WanderingHome'
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  /* 导航栏样式 */
  .el-header {
    height: 52px;
  } 

  /* 页脚样式 */
  .el-footer {
    background-color: #B3C0D1;
    height: 52px;
    
  }
  
  /* 侧边栏样式 */
  .el-aside {
    background-color: #D3DCE6;
    height: 1000px;
  }
  
  /* 主题样式 */
  .el-main {
    background-color: #E9EEF3;
    height: 1000px;
  }
  
  /* 导航栏 */
  .el-row {
    height: 52px;
    border-radius: 4px;
  }

  /* 流浪所文字 */
  .wandering-name {
    text-align: center;
    line-height: 52px;
  }

  /* 首页 */
  .wandering-home {
    text-align: left;
    line-height: 52px;
  }

  .wandering-home .el-link{
    margin-left: 40px;  
  }

  .bg-purple {
    background: #d3dce6;
    height: 52px;
  }



</style>