package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 机构活动查询参数
*/
@Data
public class TrsSchoolActivityQueryParam {

        @ApiModelProperty(value = "ID")
        private String id;
        @ApiModelProperty(value = "培训机构")
        private String trsSchoolId;
        @ApiModelProperty(value = "可选课程数量")
        private String courseNum;
        @ApiModelProperty(value = "排序")
        private String sort;

}
