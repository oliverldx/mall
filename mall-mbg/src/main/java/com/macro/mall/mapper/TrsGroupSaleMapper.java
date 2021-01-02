package com.macro.mall.mapper;

import com.macro.mall.model.TrsGroupSale;
import com.macro.mall.model.TrsGroupSaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrsGroupSaleMapper {
    long countByExample(TrsGroupSaleExample example);

    int deleteByExample(TrsGroupSaleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TrsGroupSale record);

    int insertSelective(TrsGroupSale record);

    List<TrsGroupSale> selectByExample(TrsGroupSaleExample example);

    TrsGroupSale selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TrsGroupSale record, @Param("example") TrsGroupSaleExample example);

    int updateByExample(@Param("record") TrsGroupSale record, @Param("example") TrsGroupSaleExample example);

    int updateByPrimaryKeySelective(TrsGroupSale record);

    int updateByPrimaryKey(TrsGroupSale record);
}