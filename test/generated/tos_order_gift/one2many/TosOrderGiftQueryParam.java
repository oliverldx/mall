package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 订单赠品信息查询参数
*/
@Data
public class TosOrderGiftQueryParam {

        @ApiModelProperty(value = "ID")
        private String id;
        @ApiModelProperty(value = "订单id")
        private String tosOrderId;
        @ApiModelProperty(value = "赠品id")
        private String trsGiftId;
        @ApiModelProperty(value = "状态")
        private String status;

}
