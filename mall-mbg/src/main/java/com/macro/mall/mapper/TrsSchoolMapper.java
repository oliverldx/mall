package com.macro.mall.mapper;

import com.macro.mall.model.TrsSchool;
import com.macro.mall.model.TrsSchoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrsSchoolMapper {
    long countByExample(TrsSchoolExample example);

    int deleteByExample(TrsSchoolExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TrsSchool record);

    int insertSelective(TrsSchool record);

    List<TrsSchool> selectByExampleWithBLOBs(TrsSchoolExample example);

    List<TrsSchool> selectByExample(TrsSchoolExample example);

    TrsSchool selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TrsSchool record, @Param("example") TrsSchoolExample example);

    int updateByExampleWithBLOBs(@Param("record") TrsSchool record, @Param("example") TrsSchoolExample example);

    int updateByExample(@Param("record") TrsSchool record, @Param("example") TrsSchoolExample example);

    int updateByPrimaryKeySelective(TrsSchool record);

    int updateByPrimaryKeyWithBLOBs(TrsSchool record);

    int updateByPrimaryKey(TrsSchool record);
}