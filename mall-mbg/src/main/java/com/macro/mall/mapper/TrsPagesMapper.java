package com.macro.mall.mapper;

import com.macro.mall.model.TrsPages;
import com.macro.mall.model.TrsPagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrsPagesMapper {
    long countByExample(TrsPagesExample example);

    int deleteByExample(TrsPagesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TrsPages record);

    int insertSelective(TrsPages record);

    List<TrsPages> selectByExampleWithBLOBs(TrsPagesExample example);

    List<TrsPages> selectByExample(TrsPagesExample example);

    TrsPages selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TrsPages record, @Param("example") TrsPagesExample example);

    int updateByExampleWithBLOBs(@Param("record") TrsPages record, @Param("example") TrsPagesExample example);

    int updateByExample(@Param("record") TrsPages record, @Param("example") TrsPagesExample example);

    int updateByPrimaryKeySelective(TrsPages record);

    int updateByPrimaryKeyWithBLOBs(TrsPages record);

    int updateByPrimaryKey(TrsPages record);
}