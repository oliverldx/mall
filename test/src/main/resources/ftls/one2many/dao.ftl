package com.macro.mall.dao;


import com.macro.mall.dto.${tableName}QueryParam;
import com.macro.mall.dto.${tableName}Dto;
<#if showSubList>
import com.macro.mall.dto.${tableName}SubListQueryParam;
</#if>
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* ${chineseName}自定义查询Dao
*/
public interface ${tableName}Dao {

    /**
    * 条件查询${chineseName}
    */
    List<${tableName}Dto> getList(@Param("queryParam") ${tableName}QueryParam queryParam);

<#if showSubList>
    /**
    * 条件查询${subListName}
    */
    List<${tableName}SubListQueryParam> get${subListName}List(@Param("queryParam") ${tableName}SubListQueryParam queryParam);
</#if>

}
