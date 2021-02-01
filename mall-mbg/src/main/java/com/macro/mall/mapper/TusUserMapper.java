package com.macro.mall.mapper;

import com.macro.mall.model.TusUser;
import com.macro.mall.model.TusUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TusUserMapper {
    long countByExample(TusUserExample example);

    int deleteByExample(TusUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TusUser record);

    int insertSelective(TusUser record);

    List<TusUser> selectByExampleWithBLOBs(TusUserExample example);

    List<TusUser> selectByExample(TusUserExample example);

    TusUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TusUser record, @Param("example") TusUserExample example);

    int updateByExampleWithBLOBs(@Param("record") TusUser record, @Param("example") TusUserExample example);

    int updateByExample(@Param("record") TusUser record, @Param("example") TusUserExample example);

    int updateByPrimaryKeySelective(TusUser record);

    int updateByPrimaryKeyWithBLOBs(TusUser record);

    int updateByPrimaryKey(TusUser record);
}