package com.macro.mall.mapper;

import com.macro.mall.model.TrsLocale;
import com.macro.mall.model.TrsLocaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrsLocaleMapper {
    long countByExample(TrsLocaleExample example);

    int deleteByExample(TrsLocaleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TrsLocale record);

    int insertSelective(TrsLocale record);

    List<TrsLocale> selectByExampleWithBLOBs(TrsLocaleExample example);

    List<TrsLocale> selectByExample(TrsLocaleExample example);

    TrsLocale selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TrsLocale record, @Param("example") TrsLocaleExample example);

    int updateByExampleWithBLOBs(@Param("record") TrsLocale record, @Param("example") TrsLocaleExample example);

    int updateByExample(@Param("record") TrsLocale record, @Param("example") TrsLocaleExample example);

    int updateByPrimaryKeySelective(TrsLocale record);

    int updateByPrimaryKeyWithBLOBs(TrsLocale record);

    int updateByPrimaryKey(TrsLocale record);
}