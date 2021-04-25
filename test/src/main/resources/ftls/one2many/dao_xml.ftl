<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.macro.mall.dao.${tableName}Dao">

    <resultMap id="${tableName}Dto" type="com.macro.mall.dto.${tableName}Dto" extends="com.macro.mall.mapper.${tableName}Mapper.BaseResultMap">
        <#list aliasColumns as column>
        <#--只渲染label不为空的字段-->
            <#if column.label?default("")?trim?length gt 1>
                <result column="${column.code}" jdbcType="${column.type?upper_case}" property="${column.name}" />
            </#if>
        </#list>
    </resultMap>

    <select id="getList" resultMap="${tableName}Dto">
        ${sql}
    </select>

    <#if showSubList>
    <resultMap id="${tableName}SubListQueryParam" type="com.macro.mall.dto.${tableName}SubListQueryParam">
        <#list subListColumns as column>
        <#--只渲染label不为空的字段-->
            <#if column.label?default("")?trim?length gt 1>
                <#if column.type == 'text'>
                    <result column="${column.code}" jdbcType="LONGVARCHAR" property="${column.name}" />
                </#if>
                <#else >
                <result column="${column.code}" jdbcType="${column.type?upper_case}" property="${column.name}" />
            </#if>
        </#list>
    </resultMap>

    <select id="get${subListName}List" resultMap="${tableName}SubListQueryParam">
        ${subListSql}
    </select>
    </#if>
</mapper>