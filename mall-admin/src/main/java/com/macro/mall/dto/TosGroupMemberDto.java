package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.macro.mall.model.TosGroupMember;


/**
* 参团队员dto
*/
@Data
public class TosGroupMemberDto extends TosGroupMember {

        @ApiModelProperty(value = "姓名")
        private String userName;

}
