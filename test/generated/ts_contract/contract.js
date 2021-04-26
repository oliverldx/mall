import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/contract/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/contract/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/contract/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/contract/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/contract/add',
        method:'post',
        data:data
    })
}

