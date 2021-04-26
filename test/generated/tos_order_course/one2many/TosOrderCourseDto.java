package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.macro.mall.model.TosOrderCourse;


/**
* 订单课程信息dto
*/
@Data
public class TosOrderCourseDto extends TosOrderCourse {

        @ApiModelProperty(value = "TODO")
        private String courseId;
        @ApiModelProperty(value = "图片")
        private String coursePic;
        @ApiModelProperty(value = "名称")
        private String courseName;

}
