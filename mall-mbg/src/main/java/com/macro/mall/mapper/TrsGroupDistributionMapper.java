package com.macro.mall.mapper;

import com.macro.mall.model.TrsGroupDistribution;
import com.macro.mall.model.TrsGroupDistributionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrsGroupDistributionMapper {
    long countByExample(TrsGroupDistributionExample example);

    int deleteByExample(TrsGroupDistributionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TrsGroupDistribution record);

    int insertSelective(TrsGroupDistribution record);

    List<TrsGroupDistribution> selectByExample(TrsGroupDistributionExample example);

    TrsGroupDistribution selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TrsGroupDistribution record, @Param("example") TrsGroupDistributionExample example);

    int updateByExample(@Param("record") TrsGroupDistribution record, @Param("example") TrsGroupDistributionExample example);

    int updateByPrimaryKeySelective(TrsGroupDistribution record);

    int updateByPrimaryKey(TrsGroupDistribution record);
}