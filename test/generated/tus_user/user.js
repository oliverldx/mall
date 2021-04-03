import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/user/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/user/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/user/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/user/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/user/add',
        method:'post',
        data:data
    })
}

