package com.macro.mall.dao;


import com.macro.mall.dto.TrsCourseDto;
import com.macro.mall.dto.TrsCourseQueryParam;
import com.macro.mall.model.TrsCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 课程自定义查询Dao
*/
public interface TrsCourseDao {

    /**
    * 根据schoolId获取课程
    */
    TrsCourse getBySchoolId(@Param("schoolId") Long schoolId);

    /**
     * 条件查询课程
     */
    List<TrsCourseDto> getList(@Param("queryParam") TrsCourseQueryParam queryParam);


}
