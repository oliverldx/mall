package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.macro.mall.model.TosOrderGift;


/**
* 订单赠品信息dto
*/
@Data
public class TosOrderGiftDto extends TosOrderGift {

        @ApiModelProperty(value = "TODO")
        private String giftId;
        @ApiModelProperty(value = "商品图片")
        private String giftPic;
        @ApiModelProperty(value = "名称")
        private String giftName;
        @ApiModelProperty(value = "赞助商名称")
        private String giftSponsorName;

}
