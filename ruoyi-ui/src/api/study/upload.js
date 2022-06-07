import request from '@/utils/request'



// 查询信息列表
export function listUpload(query) {
  return request({
    url: '/study/upload/list',
    method: 'get',
    params: query
  })
}

// 查询信息详细
export function getUpload(uploadId) {
  return request({
    url: '/study/upload/' + uploadId,
    method: 'get'
  })
}

// 新增信息
export function addUpload(data) {
  return request({
    url: '/study/upload',
    method: 'post',
    data: data
  })
}

// 修改信息
export function updateUpload(data) {
  return request({
    url: '/study/upload',
    method: 'put',
    data: data
  })
}

// 删除信息
export function delUpload(uploadId) {
  return request({
    url: '/study/upload/' + uploadId,
    method: 'delete'
  })
}

