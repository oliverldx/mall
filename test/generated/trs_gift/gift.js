import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/gift/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/gift/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/gift/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/gift/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/gift/add',
        method:'post',
        data:data
    })
}

