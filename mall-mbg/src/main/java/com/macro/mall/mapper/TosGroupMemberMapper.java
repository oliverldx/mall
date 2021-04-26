package com.macro.mall.mapper;

import com.macro.mall.model.TosGroupMember;
import com.macro.mall.model.TosGroupMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TosGroupMemberMapper {
    long countByExample(TosGroupMemberExample example);

    int deleteByExample(TosGroupMemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TosGroupMember record);

    int insertSelective(TosGroupMember record);

    List<TosGroupMember> selectByExample(TosGroupMemberExample example);

    TosGroupMember selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TosGroupMember record, @Param("example") TosGroupMemberExample example);

    int updateByExample(@Param("record") TosGroupMember record, @Param("example") TosGroupMemberExample example);

    int updateByPrimaryKeySelective(TosGroupMember record);

    int updateByPrimaryKey(TosGroupMember record);
}