import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/promotionPoster/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/promotionPoster/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/promotionPoster/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/promotionPoster/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/promotionPoster/add',
        method:'post',
        data:data
    })
}

