package com.macro.mall.mapper;

import com.macro.mall.model.TosOrder;
import com.macro.mall.model.TosOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TosOrderMapper {
    long countByExample(TosOrderExample example);

    int deleteByExample(TosOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TosOrder record);

    int insertSelective(TosOrder record);

    List<TosOrder> selectByExample(TosOrderExample example);

    TosOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TosOrder record, @Param("example") TosOrderExample example);

    int updateByExample(@Param("record") TosOrder record, @Param("example") TosOrderExample example);

    int updateByPrimaryKeySelective(TosOrder record);

    int updateByPrimaryKey(TosOrder record);
}