package com.macro.mall.dao;


import com.macro.mall.dto.TosGroupMemberQueryParam;
import com.macro.mall.model.TosGroupMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 参团队员自定义查询Dao
*/
public interface TosGroupMemberDao {

    /**
    * 条件查询参团队员
    */
    List<TosGroupMember> getList(@Param("queryParam") TosGroupMemberQueryParam queryParam);

}
