import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'//list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'//delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'//update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'//'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'//add',
        method:'post',
        data:data
    })
}

