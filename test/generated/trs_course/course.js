import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'/course/list',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'/course/delete',
          method:'post',
          params:params
        })
}


