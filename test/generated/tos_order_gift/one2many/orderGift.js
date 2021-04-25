import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/orderGift/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/orderGift/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/orderGift/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/orderGift/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/orderGift/add',
        method:'post',
        data:data
    })
}


export function fetchGiftList(params) {
    return request({
        url:'/orderGift/giftList',
        method:'get',
        params:params
    })
}

export function createGiftList(params) {
    return request({
        url:'/orderGift/addGiftList',
        method:'post',
        params:params
    })
}
