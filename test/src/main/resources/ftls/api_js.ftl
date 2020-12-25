import request from '@/utils/request'

export function fetchList(params) {
    return request({
        url:'${urlPathList}',
        method:'get',
        params:params
      })

}

export function del(params) {
      return request({
          url:'${urlPathDel}',
          method:'post',
          params:params
        })
}


