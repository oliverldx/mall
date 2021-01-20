import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/groupSale/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/groupSale/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/groupSale/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/groupSale/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/groupSale/add',
        method:'post',
        data:data
    })
}

