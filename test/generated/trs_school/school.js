import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/school/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/school/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/school/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/school/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/school/add',
        method:'post',
        data:data
    })
}

