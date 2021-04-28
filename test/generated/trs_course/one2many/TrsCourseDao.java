package com.macro.mall.dao;


import com.macro.mall.dto.TrsCourseQueryParam;
import com.macro.mall.dto.TrsCourseDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 课程自定义查询Dao
*/
public interface TrsCourseDao {

    /**
    * 条件查询课程
    */
    List<TrsCourseDto> getList(@Param("queryParam") TrsCourseQueryParam queryParam);


}
