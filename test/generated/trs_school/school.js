import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/school/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/school/delete',
          method:'post',
          params:params
        })
}


