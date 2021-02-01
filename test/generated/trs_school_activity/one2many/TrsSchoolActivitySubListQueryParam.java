package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 机构活动查询参数
*/
@Data
public class TrsSchoolActivitySubListQueryParam {

        @ApiModelProperty(value = "TODO")
        private String id;
        @ApiModelProperty(value = "机构logo")
        private String logo;
        @ApiModelProperty(value = "机构名称")
        private String name;
        @ApiModelProperty(value = "联系人")
        private String contactName;

}
