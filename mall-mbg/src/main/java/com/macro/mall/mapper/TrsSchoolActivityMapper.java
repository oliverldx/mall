package com.macro.mall.mapper;

import com.macro.mall.model.TrsSchoolActivity;
import com.macro.mall.model.TrsSchoolActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrsSchoolActivityMapper {
    long countByExample(TrsSchoolActivityExample example);

    int deleteByExample(TrsSchoolActivityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TrsSchoolActivity record);

    int insertSelective(TrsSchoolActivity record);

    List<TrsSchoolActivity> selectByExample(TrsSchoolActivityExample example);

    TrsSchoolActivity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TrsSchoolActivity record, @Param("example") TrsSchoolActivityExample example);

    int updateByExample(@Param("record") TrsSchoolActivity record, @Param("example") TrsSchoolActivityExample example);

    int updateByPrimaryKeySelective(TrsSchoolActivity record);

    int updateByPrimaryKey(TrsSchoolActivity record);
}