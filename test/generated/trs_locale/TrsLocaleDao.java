package com.macro.mall.dao;


import com.macro.mall.dto.TrsLocaleQueryParam;
import com.macro.mall.model.TrsLocale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 现场自定义查询Dao
*/
public interface TrsLocaleDao {

    /**
    * 条件查询现场
    */
    List<TrsLocale> getList(@Param("queryParam") TrsLocaleQueryParam queryParam);

}
