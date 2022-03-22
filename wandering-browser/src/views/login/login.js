// 入口文件
import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import Login from './login.vue'

const app = createApp(Login)

app.use(ElementPlus,{ size: 'small', zIndex: 3000 })
app.mount('#app')