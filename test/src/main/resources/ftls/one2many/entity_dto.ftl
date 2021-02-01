package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.macro.mall.model.${tableName};


/**
* ${chineseName}dto
*/
@Data
public class ${tableName}Dto extends ${tableName} {

<#list aliasColumns as column>
    <#--只渲染label不为空的字段-->
    <#if column.label?default("")?trim?length gt 1>
        @ApiModelProperty(value = "${column.comment!'TODO'}")
        private String ${column.name};
    </#if>
</#list>

}
