import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/courseActivity/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/courseActivity/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/courseActivity/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/courseActivity/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/courseActivity/add',
        method:'post',
        data:data
    })
}


export function fetchCourseList(params) {
    return request({
        url:'/courseActivity/courseList',
        method:'get',
        params:params
    })
}

export function createCourseList(params) {
    return request({
        url:'/courseActivity/addCourseList',
        method:'post',
        params:params
    })
}
