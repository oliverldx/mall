import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/customerService/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/customerService/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/customerService/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/customerService/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/customerService/add',
        method:'post',
        data:data
    })
}

export function getByActivityId(id) {
    return request({
        url:'/customerService/getByActivityId/'+id,
        method:'get'
    })
}

