package com.macro.mall.dto;

import com.macro.mall.model.TsCustomerService;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
* 客服中心dto
*/
@Data
public class TsCustomerServiceDto extends TsCustomerService {

        @ApiModelProperty(value = "活动名称")
        private String activityName;

}
