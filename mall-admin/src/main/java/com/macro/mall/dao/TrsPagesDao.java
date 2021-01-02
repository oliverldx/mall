package com.macro.mall.dao;


import com.macro.mall.model.TrsPages;
import org.apache.ibatis.annotations.Param;

/**
* 页面自定义查询Dao
*/
public interface TrsPagesDao {

    /**
    * 根据ActivityId获取页面对象
    */
    TrsPages getByActivityId(@Param("activityId") Long activityId);

}
