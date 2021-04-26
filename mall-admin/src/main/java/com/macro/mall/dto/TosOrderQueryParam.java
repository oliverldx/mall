package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 订单查询参数
*/
@Data
public class TosOrderQueryParam {

        @ApiModelProperty(value = "ID")
        private String id;
        @ApiModelProperty(value = "订单号")
        private String orderNo;
        @ApiModelProperty(value = "订单类型")
        private String type;
        @ApiModelProperty(value = "用户ID")
        private String tusUserId;
        @ApiModelProperty(value = "总金额")
        private String totalMoney;
        @ApiModelProperty(value = "分销金额")
        private String distributionMoney;
        @ApiModelProperty(value = "订单状态")
        private String status;
        @ApiModelProperty(value = "下单时间")
        private String orderTime;

}
