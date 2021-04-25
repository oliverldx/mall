package com.macro.mall.dao;


import com.macro.mall.dto.TosOrderCourseQueryParam;
import com.macro.mall.dto.TosOrderCourseDto;
import com.macro.mall.dto.TosOrderCourseSubListQueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 订单课程信息自定义查询Dao
*/
public interface TosOrderCourseDao {

    /**
    * 条件查询订单课程信息
    */
    List<TosOrderCourseDto> getList(@Param("queryParam") TosOrderCourseQueryParam queryParam);

    /**
    * 条件查询Course
    */
    List<TosOrderCourseSubListQueryParam> getCourseList(@Param("queryParam") TosOrderCourseSubListQueryParam queryParam);

}
