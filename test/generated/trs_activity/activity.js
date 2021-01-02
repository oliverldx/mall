import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/activity/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/activity/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/activity/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/activity/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/activity/add',
        method:'post',
        data:data
    })
}

