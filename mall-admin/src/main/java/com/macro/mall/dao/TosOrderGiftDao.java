package com.macro.mall.dao;


import com.macro.mall.dto.TosOrderGiftQueryParam;
import com.macro.mall.dto.TosOrderGiftDto;
import com.macro.mall.dto.TosOrderGiftSubListQueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 订单赠品信息自定义查询Dao
*/
public interface TosOrderGiftDao {

    /**
    * 条件查询订单赠品信息
    */
    List<TosOrderGiftDto> getList(@Param("queryParam") TosOrderGiftQueryParam queryParam);

    /**
    * 条件查询Gift
    */
    List<TosOrderGiftSubListQueryParam> getGiftList(@Param("queryParam") TosOrderGiftSubListQueryParam queryParam);

}
