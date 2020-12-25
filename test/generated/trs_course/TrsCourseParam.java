package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
* 课程查询参数
*/
@Getter
@Setter
public class TrsCourseQueryParam {

            @ApiModelProperty(value = "TODO")
            private String id;
            @ApiModelProperty(value = "图片")
            private String pic;
            @ApiModelProperty(value = "名称")
            private String name;
            @ApiModelProperty(value = "原价")
            private String price;
            @ApiModelProperty(value = "培训机构")
            private String trsschoolid;
            @ApiModelProperty(value = "状态")
            private String status;

}
