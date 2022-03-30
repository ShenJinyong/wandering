import request from '@/utils/new-request'

export function selectAllBlogType() {
  return request({
    url: '/blog/blogTypePo/selectAll',
    method: 'get',
    data
  })
}

export function selectAllBlogType(data) {
    return request({
      url: '/blog/blogTypePo/create',
      method: 'post',
      data: this.data
    })
  }
