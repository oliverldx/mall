package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 课程活动查询参数
*/
@Data
public class TrsCourseActivityQueryParam {

        @ApiModelProperty(value = "TODO")
        private String id;
        @ApiModelProperty(value = "课程")
        private String trsCourseId;
        @ApiModelProperty(value = "库存")
        private String courseNum;
        @ApiModelProperty(value = "排序")
        private String sort;
        @ApiModelProperty(value = "报名数")
        private String applyNum;

}