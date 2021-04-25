import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/orderCourse/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/orderCourse/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/orderCourse/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/orderCourse/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/orderCourse/add',
        method:'post',
        data:data
    })
}

