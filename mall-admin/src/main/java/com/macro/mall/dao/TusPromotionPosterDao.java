package com.macro.mall.dao;


import com.macro.mall.model.TusPromotionPoster;
import org.apache.ibatis.annotations.Param;

/**
* 推广海报自定义查询Dao
*/
public interface TusPromotionPosterDao {

    /**
    * 根据userId获取推广海报
    */
    TusPromotionPoster getByUserId(@Param("userId") Long userId);

}
