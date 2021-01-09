package com.macro.mall.dao;


import com.macro.mall.dto.TrsPagesQueryParam;
import com.macro.mall.model.TrsPages;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 页面自定义查询Dao
*/
public interface TrsPagesDao {

    /**
    * 条件查询页面
    */
    List<TrsPages> getList(@Param("queryParam") TrsPagesQueryParam queryParam);

}
