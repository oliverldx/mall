import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/group_sale/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/group_sale/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/group_sale/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/group_sale/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/group_sale/add',
        method:'post',
        data:data
    })
}

