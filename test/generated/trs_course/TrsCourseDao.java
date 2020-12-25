package com.macro.mall.dao;


import com.macro.mall.dto.TrsCourseQueryParam;
import com.macro.mall.model.TrsCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 课程自定义查询Dao
*/
public interface TrsCourseDao {

    /**
    * 条件查询订单
    */
    List<TrsCourse> getList(@Param("queryParam") TrsCourseQueryParam queryParam);

}
