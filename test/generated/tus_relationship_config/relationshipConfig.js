import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/relationshipConfig/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/relationshipConfig/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/relationshipConfig/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/relationshipConfig/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/relationshipConfig/add',
        method:'post',
        data:data
    })
}

