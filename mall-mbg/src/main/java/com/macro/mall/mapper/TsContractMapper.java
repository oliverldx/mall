package com.macro.mall.mapper;

import com.macro.mall.model.TsContract;
import com.macro.mall.model.TsContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TsContractMapper {
    long countByExample(TsContractExample example);

    int deleteByExample(TsContractExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TsContract record);

    int insertSelective(TsContract record);

    List<TsContract> selectByExampleWithBLOBs(TsContractExample example);

    List<TsContract> selectByExample(TsContractExample example);

    TsContract selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TsContract record, @Param("example") TsContractExample example);

    int updateByExampleWithBLOBs(@Param("record") TsContract record, @Param("example") TsContractExample example);

    int updateByExample(@Param("record") TsContract record, @Param("example") TsContractExample example);

    int updateByPrimaryKeySelective(TsContract record);

    int updateByPrimaryKeyWithBLOBs(TsContract record);

    int updateByPrimaryKey(TsContract record);
}