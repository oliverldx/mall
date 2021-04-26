package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 参团队员查询参数
*/
@Data
public class TosGroupMemberSubListQueryParam {

        @ApiModelProperty(value = "昵称")
        private String nickName;
        @ApiModelProperty(value = "姓名")
        private String name;
        @ApiModelProperty(value = "手机号")
        private String mobile;
        @ApiModelProperty(value = "姓名")
        private String name;

}
