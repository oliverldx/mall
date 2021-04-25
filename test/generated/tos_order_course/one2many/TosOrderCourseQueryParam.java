package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 订单课程信息查询参数
*/
@Data
public class TosOrderCourseQueryParam {

        @ApiModelProperty(value = "ID")
        private String id;
        @ApiModelProperty(value = "订单id")
        private String tosOrderId;
        @ApiModelProperty(value = "课程id")
        private String trsCourseId;

}
