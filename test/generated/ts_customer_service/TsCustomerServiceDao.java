package com.macro.mall.dao;


import com.macro.mall.dto.TsCustomerServiceQueryParam;
import com.macro.mall.model.TsCustomerService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 客服中心自定义查询Dao
*/
public interface TsCustomerServiceDao {

    /**
    * 条件查询客服中心
    */
    List<TsCustomerService> getList(@Param("queryParam") TsCustomerServiceQueryParam queryParam);

}
