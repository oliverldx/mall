package com.macro.mall.mapper;

import com.macro.mall.model.TrsGift;
import com.macro.mall.model.TrsGiftExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrsGiftMapper {
    long countByExample(TrsGiftExample example);

    int deleteByExample(TrsGiftExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TrsGift record);

    int insertSelective(TrsGift record);

    List<TrsGift> selectByExampleWithBLOBs(TrsGiftExample example);

    List<TrsGift> selectByExample(TrsGiftExample example);

    TrsGift selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TrsGift record, @Param("example") TrsGiftExample example);

    int updateByExampleWithBLOBs(@Param("record") TrsGift record, @Param("example") TrsGiftExample example);

    int updateByExample(@Param("record") TrsGift record, @Param("example") TrsGiftExample example);

    int updateByPrimaryKeySelective(TrsGift record);

    int updateByPrimaryKeyWithBLOBs(TrsGift record);

    int updateByPrimaryKey(TrsGift record);
}