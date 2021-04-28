package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.macro.mall.model.TsCustomerService;


/**
* 客服中心dto
*/
@Data
public class TsCustomerServiceDto extends TsCustomerService {

        @ApiModelProperty(value = "活动名称")
        private String activityName;

}
