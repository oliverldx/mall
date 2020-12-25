package com.macro.mall.dao;


import com.macro.mall.dto.${tableName}QueryParam;
import com.macro.mall.model.${tableName};
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* ${chineseName}自定义查询Dao
*/
public interface ${tableName}Dao {

    /**
    * 条件查询订单
    */
    List<${tableName}> getList(@Param("queryParam") ${tableName}QueryParam queryParam);

}
