package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 赠品查询参数
*/
@Data
public class TrsGiftQueryParam {

        @ApiModelProperty(value = "TODO")
        private String id;
        @ApiModelProperty(value = "商品图片")
        private String pic;
        @ApiModelProperty(value = "名称")
        private String name;
        @ApiModelProperty(value = "赞助商名称")
        private String sponsorName;
        @ApiModelProperty(value = "数量")
        private String num;
        @ApiModelProperty(value = "有效期")
        private String validateTime;
        @ApiModelProperty(value = "状态")
        private String status;
        @ApiModelProperty(value = "排序")
        private String sort;

}
