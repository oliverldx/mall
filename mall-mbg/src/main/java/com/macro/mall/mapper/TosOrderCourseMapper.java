package com.macro.mall.mapper;

import com.macro.mall.model.TosOrderCourse;
import com.macro.mall.model.TosOrderCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TosOrderCourseMapper {
    long countByExample(TosOrderCourseExample example);

    int deleteByExample(TosOrderCourseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TosOrderCourse record);

    int insertSelective(TosOrderCourse record);

    List<TosOrderCourse> selectByExample(TosOrderCourseExample example);

    TosOrderCourse selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TosOrderCourse record, @Param("example") TosOrderCourseExample example);

    int updateByExample(@Param("record") TosOrderCourse record, @Param("example") TosOrderCourseExample example);

    int updateByPrimaryKeySelective(TosOrderCourse record);

    int updateByPrimaryKey(TosOrderCourse record);
}