package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.macro.mall.model.TosOrderGift;


/**
* 订单赠品信息dto
*/
@Data
public class TosOrderGiftDto extends TosOrderGift {

        @ApiModelProperty(value = "名称")
        private String giftName;

}
