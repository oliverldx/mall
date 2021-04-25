package com.macro.mall.dao;


import com.macro.mall.dto.TusRelationshipConfigQueryParam;
import com.macro.mall.model.TusRelationshipConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 关系设置自定义查询Dao
*/
public interface TusRelationshipConfigDao {

    /**
    * 条件查询关系设置
    */
    List<TusRelationshipConfig> getList(@Param("queryParam") TusRelationshipConfigQueryParam queryParam);

}
