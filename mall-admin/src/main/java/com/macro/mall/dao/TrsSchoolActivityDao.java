package com.macro.mall.dao;


import com.macro.mall.dto.TrsSchoolActivityQueryParam;
import com.macro.mall.dto.TrsSchoolActivityDto;
import com.macro.mall.dto.TrsSchoolActivitySubListQueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 机构活动自定义查询Dao
*/
public interface TrsSchoolActivityDao {

    /**
    * 条件查询机构活动
    */
    List<TrsSchoolActivityDto> getList(@Param("queryParam") TrsSchoolActivityQueryParam queryParam);

    /**
    * 条件查询School
    */
    List<TrsSchoolActivitySubListQueryParam> getSchoolList(@Param("queryParam") TrsSchoolActivitySubListQueryParam queryParam);

}
