import request from '@/utils/request'

export function selectAllBlogTag() {
  return request({
    url: '/wandering/blog/blogTagPo/selectAll',
    method: 'get'
  })
}

export function createBlogTag(data) {
  return request({
    url: '/wandering/blog/blogTagPo/create',
    method: 'post',
    data: this.data
  })
}
