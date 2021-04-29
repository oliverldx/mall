package com.macro.mall.dto;

import com.macro.mall.model.TrsCourse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
* 课程dto
*/
@Data
public class TrsCourseDto extends TrsCourse {

        @ApiModelProperty(value = "机构名称")
        private String schoolName;

}
