package com.macro.mall.dao;


import com.macro.mall.dto.TosOrderCourseQueryParam;
import com.macro.mall.model.TosOrderCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 订单课程信息自定义查询Dao
*/
public interface TosOrderCourseDao {

    /**
    * 条件查询订单课程信息
    */
    List<TosOrderCourse> getList(@Param("queryParam") TosOrderCourseQueryParam queryParam);

}
