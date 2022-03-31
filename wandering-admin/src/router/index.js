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
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: 'Dashboard', icon: 'dashboard' }
    }]
  },

  {
    path: '/blog',
    component: Layout,
    meta: { title: '博客管理', icon: 'dashboard' },
    children: [
      {
        path: '/blog/index',
        component: () => import('@/views/blog/index'),
        meta: { title: '文章管理', icon: 'dashboard' }
      },
      {
        path: '/blog/editor',
        component: () => import('@/views/blog/editor'),
        meta: { title: '编写博客', icon: 'dashboard' }
      },
      {
        path: '/blog/type',
        component: () => import('@/views/blog/type'),
        meta: { title: '博客类型', icon: 'dashboard' }
      },
      {
        path: '/blog/tag',
        component: () => import('@/views/blog/tag'),
        meta: { title: '博客标签', icon: 'dashboard' }
      }
    ]
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
