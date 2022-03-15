const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  // 处理eslint校验规则
  lintOnSave: false
})
