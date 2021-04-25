package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 订单赠品信息查询参数
*/
@Data
public class TosOrderGiftSubListQueryParam {

        @ApiModelProperty(value = "TODO")
        private String id;
        @ApiModelProperty(value = "商品图片")
        private String pic;
        @ApiModelProperty(value = "名称")
        private String name;
        @ApiModelProperty(value = "赞助商名称")
        private String sponsorName;

}
