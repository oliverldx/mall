package com.macro.mall.mapper;

import com.macro.mall.model.CustomerService;
import com.macro.mall.model.CustomerServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerServiceMapper {
    long countByExample(CustomerServiceExample example);

    int deleteByExample(CustomerServiceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustomerService record);

    int insertSelective(CustomerService record);

    List<CustomerService> selectByExampleWithBLOBs(CustomerServiceExample example);

    List<CustomerService> selectByExample(CustomerServiceExample example);

    CustomerService selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustomerService record, @Param("example") CustomerServiceExample example);

    int updateByExampleWithBLOBs(@Param("record") CustomerService record, @Param("example") CustomerServiceExample example);

    int updateByExample(@Param("record") CustomerService record, @Param("example") CustomerServiceExample example);

    int updateByPrimaryKeySelective(CustomerService record);

    int updateByPrimaryKeyWithBLOBs(CustomerService record);

    int updateByPrimaryKey(CustomerService record);
}