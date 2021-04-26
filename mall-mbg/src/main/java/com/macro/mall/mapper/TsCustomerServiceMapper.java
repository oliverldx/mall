package com.macro.mall.mapper;

import com.macro.mall.model.TsCustomerService;
import com.macro.mall.model.TsCustomerServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TsCustomerServiceMapper {
    long countByExample(TsCustomerServiceExample example);

    int deleteByExample(TsCustomerServiceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TsCustomerService record);

    int insertSelective(TsCustomerService record);

    List<TsCustomerService> selectByExampleWithBLOBs(TsCustomerServiceExample example);

    List<TsCustomerService> selectByExample(TsCustomerServiceExample example);

    TsCustomerService selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TsCustomerService record, @Param("example") TsCustomerServiceExample example);

    int updateByExampleWithBLOBs(@Param("record") TsCustomerService record, @Param("example") TsCustomerServiceExample example);

    int updateByExample(@Param("record") TsCustomerService record, @Param("example") TsCustomerServiceExample example);

    int updateByPrimaryKeySelective(TsCustomerService record);

    int updateByPrimaryKeyWithBLOBs(TsCustomerService record);

    int updateByPrimaryKey(TsCustomerService record);
}