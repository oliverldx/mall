package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.macro.mall.model.TrsSchoolActivity;


/**
* 机构活动dto
*/
@Data
public class TrsSchoolActivityDto extends TrsSchoolActivity {

        @ApiModelProperty(value = "机构名称")
        private String schoolName;

}
