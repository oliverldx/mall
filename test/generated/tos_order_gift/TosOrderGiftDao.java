package com.macro.mall.dao;


import com.macro.mall.dto.TosOrderGiftQueryParam;
import com.macro.mall.model.TosOrderGift;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 订单赠品信息自定义查询Dao
*/
public interface TosOrderGiftDao {

    /**
    * 条件查询订单赠品信息
    */
    List<TosOrderGift> getList(@Param("queryParam") TosOrderGiftQueryParam queryParam);

}
