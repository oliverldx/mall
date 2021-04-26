package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 参团队员查询参数
*/
@Data
public class TosGroupMemberQueryParam {

        @ApiModelProperty(value = "ID")
        private String id;
        @ApiModelProperty(value = "ID")
        private String tosOrderId;
        @ApiModelProperty(value = "ID")
        private String tusUserId;

}
