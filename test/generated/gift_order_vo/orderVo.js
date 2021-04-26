import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/orderVo/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/orderVo/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/orderVo/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/orderVo/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/orderVo/add',
        method:'post',
        data:data
    })
}

