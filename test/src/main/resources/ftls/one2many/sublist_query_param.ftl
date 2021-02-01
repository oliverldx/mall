package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* ${chineseName}查询参数
*/
@Data
public class ${tableName}SubListQueryParam {

<#list subListColumns as column>
    <#--只渲染label不为空的字段-->
    <#if column.label?default("")?trim?length gt 1>
        @ApiModelProperty(value = "${column.comment!'TODO'}")
        private String ${column.name};
    </#if>
</#list>

}
