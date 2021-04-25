import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/order/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/order/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/order/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/order/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/order/add',
        method:'post',
        data:data
    })
}

