import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/capitalRecord/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/capitalRecord/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/capitalRecord/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/capitalRecord/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/capitalRecord/add',
        method:'post',
        data:data
    })
}

