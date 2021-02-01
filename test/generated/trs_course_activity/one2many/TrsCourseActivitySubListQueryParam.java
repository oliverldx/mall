package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 课程活动查询参数
*/
@Data
public class TrsCourseActivitySubListQueryParam {

        @ApiModelProperty(value = "TODO")
        private String id;
        @ApiModelProperty(value = "图片")
        private String pic;
        @ApiModelProperty(value = "名称")
        private String name;
        @ApiModelProperty(value = "原价")
        private String price;

}
