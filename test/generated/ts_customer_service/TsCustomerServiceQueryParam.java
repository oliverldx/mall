package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 客服中心查询参数
*/
@Data
public class TsCustomerServiceQueryParam {

        @ApiModelProperty(value = "TODO")
        private String id;
        @ApiModelProperty(value = "活动名称")
        private String trsActivityId;
        @ApiModelProperty(value = "客服电话")
        private String phone;
        @ApiModelProperty(value = "客服二维码")
        private String pic;
        @ApiModelProperty(value = "创建时间")
        private String createDate;

}
