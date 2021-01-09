package com.macro.mall.dao;


import com.macro.mall.dto.TrsGiftQueryParam;
import com.macro.mall.model.TrsGift;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 赠品自定义查询Dao
*/
public interface TrsGiftDao {

    /**
    * 条件查询赠品
    */
    List<TrsGift> getList(@Param("queryParam") TrsGiftQueryParam queryParam);

}
