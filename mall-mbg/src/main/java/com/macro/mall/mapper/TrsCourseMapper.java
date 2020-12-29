package com.macro.mall.mapper;

import com.macro.mall.model.TrsCourse;
import com.macro.mall.model.TrsCourseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrsCourseMapper {
    long countByExample(TrsCourseExample example);

    int deleteByExample(TrsCourseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TrsCourse record);

    int insertSelective(TrsCourse record);

    List<TrsCourse> selectByExampleWithBLOBs(TrsCourseExample example);

    List<TrsCourse> selectByExample(TrsCourseExample example);

    TrsCourse selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TrsCourse record, @Param("example") TrsCourseExample example);

    int updateByExampleWithBLOBs(@Param("record") TrsCourse record, @Param("example") TrsCourseExample example);

    int updateByExample(@Param("record") TrsCourse record, @Param("example") TrsCourseExample example);

    int updateByPrimaryKeySelective(TrsCourse record);

    int updateByPrimaryKeyWithBLOBs(TrsCourse record);

    int updateByPrimaryKey(TrsCourse record);
}