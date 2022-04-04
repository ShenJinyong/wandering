import request from '@/utils/request'

export function createBlog(blogForm) {
  return request({
    url: '/wandering/blog/blogPo/create',
    method: 'post',
    data: blogForm
  })
}
