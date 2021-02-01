import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/schoolActivity/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/schoolActivity/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/schoolActivity/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/schoolActivity/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/schoolActivity/add',
        method:'post',
        data:data
    })
}


export function fetchSchoolList(params) {
    return request({
        url:'/schoolActivity/schoolList',
        method:'get',
        params:params
    })
}

export function createSchoolList(params) {
    return request({
        url:'/schoolActivity/addSchoolList',
        method:'post',
        params:params
    })
}
