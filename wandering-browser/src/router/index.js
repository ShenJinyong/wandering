import Vue from 'vue'
import VueRouter from 'vue-router'

import Index from '../views/Index.vue'

Vue.use(VueRouter)
const routes = [

    {
        path: '/',
        name: 'Index',
        component: Index
        // redirect: '/index',
        // children: [
        //     {
        //         path: '/index',
        //         name: 'Index',
        //         component: Index,
        //         meta: {
        //             title: '首页'
        //         }
        //     }
        // ]

    },


];


const createRouter = () => new Router({
    // mode: 'history', // require service support
    scrollBehavior: () => ({ y: 0 }),
    routes: constantRoutes
  })
  
const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
const newRouter = createRouter()
router.matcher = newRouter.matcher // reset router
}

export default router

