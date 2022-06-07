import request from '@/utils/request'

// 查询项目列表
export function listItem(query) {
  return request({
    url: '/study/item/list',
    method: 'get',
    params: query
  })
}

// 查询项目详细
export function getItem(itemId) {
  return request({
    url: '/study/item/' + itemId,
    method: 'get'
  })
}

// 新增项目
export function addItem(data) {
  return request({
    url: '/study/item',
    method: 'post',
    data: data
  })
}

// 修改项目
export function updateItem(data) {
  return request({
    url: '/study/item',
    method: 'put',
    data: data
  })
}

// 删除项目
export function delItem(itemId) {
  return request({
    url: '/study/item/' + itemId,
    method: 'delete'
  })
}
