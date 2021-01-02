import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/group_distribution/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/group_distribution/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/group_distribution/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/group_distribution/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/group_distribution/add',
        method:'post',
        data:data
    })
}

