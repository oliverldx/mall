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

export function update(id,data) {
    return request({
        url:'${urlPathUpdate}'+id,
        method:'post',
        data:data
    })
}

export function getById(id) {
    return request({
        url:'${urlPathGetById}'+id,
        method:'get'
    })
}

export function create(data) {
    return request({
        url:'${urlPathAdd}',
        method:'post',
        data:data
    })
}

<#if showSubList>

export function fetch${subListName?cap_first}List(params) {
    return request({
        url:'${urlPathSubList}',
        method:'get',
        params:params
    })
}

export function create${subListName?cap_first}List(params) {
    return request({
        url:'${urlPathAddSubList}',
        method:'post',
        params:params
    })
}
</#if>
