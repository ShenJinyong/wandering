const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  // 处理eslint校验规则
  lintOnSave: false,
  pages: {
    index: {
      // 配置入口js文件
      entry: "./src/views/index/index.js",
      // 主页面
      template: "./src/views/index.html",
      // 打包后的html文件的名称
      filename: "index.html",
      // 打包后的.html中的<title>标签的文本内容
      title: "流浪所"
    },
    login: {
      entry: "./src/views/login/login.js",
      template: "./src/views/login/login.html",
      filename: "login.html",
      title: "流浪所"
    }
  }
})
