package com.macro.mall.dao;


import com.macro.mall.dto.TrsCourseActivityQueryParam;
import com.macro.mall.model.TrsCourseActivity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 课程活动自定义查询Dao
*/
public interface TrsCourseActivityDao {

    /**
    * 条件查询课程活动
    */
    List<TrsCourseActivity> getList(@Param("queryParam") TrsCourseActivityQueryParam queryParam);

}
