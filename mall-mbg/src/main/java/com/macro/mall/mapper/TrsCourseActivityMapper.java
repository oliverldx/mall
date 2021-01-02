package com.macro.mall.mapper;

import com.macro.mall.model.TrsCourseActivity;
import com.macro.mall.model.TrsCourseActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrsCourseActivityMapper {
    long countByExample(TrsCourseActivityExample example);

    int deleteByExample(TrsCourseActivityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TrsCourseActivity record);

    int insertSelective(TrsCourseActivity record);

    List<TrsCourseActivity> selectByExample(TrsCourseActivityExample example);

    TrsCourseActivity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TrsCourseActivity record, @Param("example") TrsCourseActivityExample example);

    int updateByExample(@Param("record") TrsCourseActivity record, @Param("example") TrsCourseActivityExample example);

    int updateByPrimaryKeySelective(TrsCourseActivity record);

    int updateByPrimaryKey(TrsCourseActivity record);
}