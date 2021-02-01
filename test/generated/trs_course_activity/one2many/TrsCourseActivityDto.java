package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.macro.mall.model.TrsCourseActivity;


/**
* 课程活动dto
*/
@Data
public class TrsCourseActivityDto extends TrsCourseActivity {

        @ApiModelProperty(value = "名称")
        private String courseName;

}
