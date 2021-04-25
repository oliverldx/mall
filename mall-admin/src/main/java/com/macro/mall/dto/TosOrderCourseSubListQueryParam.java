package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 订单课程信息查询参数
*/
@Data
public class TosOrderCourseSubListQueryParam {

        @ApiModelProperty(value = "TODO")
        private String id;
        @ApiModelProperty(value = "图片")
        private String pic;
        @ApiModelProperty(value = "名称")
        private String name;

}
