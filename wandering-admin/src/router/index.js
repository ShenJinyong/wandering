import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

import Layout from '@/layout'

export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: '首页',
      component: () => import('@/views/dashboard/index'),
      meta: { title: '首页', icon: 'dashboard' }
    }]
  },

  {
    path: '/blog',
    component: Layout,
    meta: { title: '博客管理', icon: 'table' },
    children: [
      {
        path: '/blog/index',
        component: () => import('@/views/blog/index'),
        meta: { title: '文章管理', icon: 'table' }
      },
      {
        path: '/blog/editor',
        component: () => import('@/views/blog/editor'),
        meta: { title: '编写博客', icon: 'form' }
      },
      {
        path: '/blog/type',
        component: () => import('@/views/blog/type'),
        meta: { title: '博客类型', icon: 'nested' }
      },
      {
        path: '/blog/tag',
        component: () => import('@/views/blog/tag'),
        meta: { title: '博客标签', icon: 'nested' }
      }
    ]
  },

  {
    path: '/user',
    component: Layout,
    children: [{
      path: 'user',
      component: () => import('@/views/user/index'),
      meta: { title: '用户管理', icon: 'user' }
    }]
  },

  {
    path: '/friend',
    component: Layout,
    children: [{
      path: 'friend',
      component: () => import('@/views/friend/index'),
      meta: { title: '友链管理', icon: 'eye-open' }
    }]
  },

  {
    path: 'external-link',
    component: Layout,
    children: [
      {
        path: 'https://github.com/ShenJinyong',
        meta: { title: 'External Link', icon: 'link' }
      }
    ]
  },

  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher
}

export default router
