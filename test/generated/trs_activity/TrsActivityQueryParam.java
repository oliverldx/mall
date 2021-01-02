package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 活动查询参数
*/
@Data
public class TrsActivityQueryParam {

        @ApiModelProperty(value = "TODO")
        private String id;
        @ApiModelProperty(value = "访问二维码")
        private String qrcode;
        @ApiModelProperty(value = "活动名称")
        private String name;
        @ApiModelProperty(value = "活动价格")
        private String price;
        @ApiModelProperty(value = "课程数量")
        private String courseNum;
        @ApiModelProperty(value = "销售数量")
        private String salesNum;
        @ApiModelProperty(value = "状态")
        private String status;

}
