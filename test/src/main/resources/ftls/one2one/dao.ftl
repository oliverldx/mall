package com.macro.mall.dao;


import com.macro.mall.model.${tableName};
import org.apache.ibatis.annotations.Param;

/**
* ${chineseName}自定义查询Dao
*/
public interface ${tableName}Dao {

    /**
    * 根据${fkId}获取${chineseName}
    */
    ${tableName} getBy${fkId?cap_first}(@Param("${fkId}") Long ${fkId});

}
