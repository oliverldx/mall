package com.macro.mall.dao;


import com.macro.mall.dto.TusCapitalRecordQueryParam;
import com.macro.mall.dto.TusCapitalRecordDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 资金记录自定义查询Dao
*/
public interface TusCapitalRecordDao {

    /**
    * 条件查询资金记录
    */
    List<TusCapitalRecordDto> getList(@Param("queryParam") TusCapitalRecordQueryParam queryParam);


}