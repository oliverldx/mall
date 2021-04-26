import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/service/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/service/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/service/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/service/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/service/add',
        method:'post',
        data:data
    })
}

