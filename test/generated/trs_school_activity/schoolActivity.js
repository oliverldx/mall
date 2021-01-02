import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/school_activity/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/school_activity/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/school_activity/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/school_activity/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/school_activity/add',
        method:'post',
        data:data
    })
}

