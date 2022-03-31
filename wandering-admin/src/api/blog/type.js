import request from '@/utils/request'

export function selectAllBlogType() {
  return request({
    url: '/wandering/blog/blogTypePo/selectAll',
    method: 'get'
  })
}

export function createBlogType(data) {
  return request({
    url: '/wandering/blog/blogTypePo/create',
    method: 'post',
    data: this.data
  })
}
