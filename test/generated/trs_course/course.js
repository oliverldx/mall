import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/course/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/course/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/course/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/course/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/course/add',
        method:'post',
        data:data
    })
}

