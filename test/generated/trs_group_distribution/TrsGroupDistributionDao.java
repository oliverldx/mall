package com.macro.mall.dao;


import com.macro.mall.dto.TrsGroupDistributionQueryParam;
import com.macro.mall.model.TrsGroupDistribution;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 分销自定义查询Dao
*/
public interface TrsGroupDistributionDao {

    /**
    * 条件查询分销
    */
    List<TrsGroupDistribution> getList(@Param("queryParam") TrsGroupDistributionQueryParam queryParam);

}
