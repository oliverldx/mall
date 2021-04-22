package com.macro.mall.dao;


import com.macro.mall.model.TrsCourse;
import org.apache.ibatis.annotations.Param;

/**
* 课程自定义查询Dao
*/
public interface TrsCourseDao {

    /**
    * 根据schoolId获取课程
    */
    TrsCourse getBySchoolId(@Param("schoolId") Long schoolId);

}
