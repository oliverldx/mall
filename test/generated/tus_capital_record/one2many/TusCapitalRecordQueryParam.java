package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 资金记录查询参数
*/
@Data
public class TusCapitalRecordQueryParam {

        @ApiModelProperty(value = "ID")
        private String id;
        @ApiModelProperty(value = "用户id")
        private String tusUserId;
        @ApiModelProperty(value = "金额")
        private String money;
        @ApiModelProperty(value = "备注")
        private String description;
        @ApiModelProperty(value = "修改时间")
        private String modifyDate;

}
