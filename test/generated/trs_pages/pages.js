import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/pages/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/pages/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/pages/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/pages/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/pages/add',
        method:'post',
        data:data
    })
}

