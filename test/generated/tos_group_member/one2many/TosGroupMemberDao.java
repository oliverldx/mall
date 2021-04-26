package com.macro.mall.dao;


import com.macro.mall.dto.TosGroupMemberQueryParam;
import com.macro.mall.dto.TosGroupMemberDto;
import com.macro.mall.dto.TosGroupMemberSubListQueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 参团队员自定义查询Dao
*/
public interface TosGroupMemberDao {

    /**
    * 条件查询参团队员
    */
    List<TosGroupMemberDto> getList(@Param("queryParam") TosGroupMemberQueryParam queryParam);

    /**
    * 条件查询User
    */
    List<TosGroupMemberSubListQueryParam> getUserList(@Param("queryParam") TosGroupMemberSubListQueryParam queryParam);

}
