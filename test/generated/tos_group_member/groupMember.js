import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/groupMember/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/groupMember/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/groupMember/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/groupMember/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/groupMember/add',
        method:'post',
        data:data
    })
}

