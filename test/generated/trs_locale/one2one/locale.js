import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/locale/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/locale/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/locale/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/locale/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/locale/add',
        method:'post',
        data:data
    })
}

export function getByActivityId(id) {
    return request({
        url:'/locale/getByActivityId/'+id,
        method:'get'
    })
}

