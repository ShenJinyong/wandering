// 入口文件
import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import Index from './index.vue'

const app = createApp(Index)

app.use(ElementPlus,{ size: 'small', zIndex: 3000 })
app.mount('#app')