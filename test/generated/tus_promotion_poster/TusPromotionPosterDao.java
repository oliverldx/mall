package com.macro.mall.dao;


import com.macro.mall.dto.TusPromotionPosterQueryParam;
import com.macro.mall.model.TusPromotionPoster;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 推广海报自定义查询Dao
*/
public interface TusPromotionPosterDao {

    /**
    * 条件查询推广海报
    */
    List<TusPromotionPoster> getList(@Param("queryParam") TusPromotionPosterQueryParam queryParam);

}
