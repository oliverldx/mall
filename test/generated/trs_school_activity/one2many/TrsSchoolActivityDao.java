package com.macro.mall.dao;


import com.macro.mall.dto.TrsSchoolActivityQueryParam;
import com.macro.mall.model.TrsSchoolActivity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 机构活动自定义查询Dao
*/
public interface TrsSchoolActivityDao {

    /**
    * 条件查询机构活动
    */
    List<TrsSchoolActivity> getList(@Param("queryParam") TrsSchoolActivityQueryParam queryParam);

}
