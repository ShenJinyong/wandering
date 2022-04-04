import request from '@/utils/request'

export function selectAllBlog() {
  return request({
    url: '/wandering/blog/blogPo/selectAll',
    method: 'get'
  })
}
