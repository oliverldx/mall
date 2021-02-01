package com.macro.mall.dao;


import com.macro.mall.dto.TrsCourseActivityQueryParam;
import com.macro.mall.dto.TrsCourseActivityDto;
import com.macro.mall.dto.TrsCourseActivitySubListQueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 课程活动自定义查询Dao
*/
public interface TrsCourseActivityDao {

    /**
    * 条件查询课程活动
    */
    List<TrsCourseActivityDto> getList(@Param("queryParam") TrsCourseActivityQueryParam queryParam);

    /**
    * 条件查询Course
    */
    List<TrsCourseActivitySubListQueryParam> getCourseList(@Param("queryParam") TrsCourseActivitySubListQueryParam queryParam);

}
