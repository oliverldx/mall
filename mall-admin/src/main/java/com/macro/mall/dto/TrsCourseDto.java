package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.macro.mall.model.TrsCourse;


/**
* 课程dto
*/
@Data
public class TrsCourseDto extends TrsCourse {

        @ApiModelProperty(value = "机构名称")
        private String schoolName;

}
