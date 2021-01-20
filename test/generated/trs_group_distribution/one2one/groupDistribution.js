import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/groupDistribution/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/groupDistribution/delete',
          method:'post',
          params:params
        })
}

export function update(id,data) {
    return request({
        url:'/groupDistribution/update/'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'/groupDistribution/'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'/groupDistribution/add',
        method:'post',
        data:data
    })
}

export function getByActivityId(id) {
    return request({
        url:'/groupDistribution/getByActivityId/'+id,
        method:'get'
    })
}

