package com.macro.mall.dao;


import com.macro.mall.model.TrsLocale;
import org.apache.ibatis.annotations.Param;

/**
* 现场自定义查询Dao
*/
public interface TrsLocaleDao {

    /**
    * 根据activityId获取现场
    */
    TrsLocale getByActivityId(@Param("activityId") Long activityId);

}
