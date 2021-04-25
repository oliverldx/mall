package com.macro.mall.mapper;

import com.macro.mall.model.TosOrderGift;
import com.macro.mall.model.TosOrderGiftExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TosOrderGiftMapper {
    long countByExample(TosOrderGiftExample example);

    int deleteByExample(TosOrderGiftExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TosOrderGift record);

    int insertSelective(TosOrderGift record);

    List<TosOrderGift> selectByExample(TosOrderGiftExample example);

    TosOrderGift selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TosOrderGift record, @Param("example") TosOrderGiftExample example);

    int updateByExample(@Param("record") TosOrderGift record, @Param("example") TosOrderGiftExample example);

    int updateByPrimaryKeySelective(TosOrderGift record);

    int updateByPrimaryKey(TosOrderGift record);
}