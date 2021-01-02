package com.macro.mall.dao;


import com.macro.mall.dto.TrsActivityQueryParam;
import com.macro.mall.model.TrsActivity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 活动自定义查询Dao
*/
public interface TrsActivityDao {

    /**
    * 条件查询订单
    */
    List<TrsActivity> getList(@Param("queryParam") TrsActivityQueryParam queryParam);

}
