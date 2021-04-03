package com.macro.mall.mapper;

import com.macro.mall.model.TusCapitalRecord;
import com.macro.mall.model.TusCapitalRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TusCapitalRecordMapper {
    long countByExample(TusCapitalRecordExample example);

    int deleteByExample(TusCapitalRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TusCapitalRecord record);

    int insertSelective(TusCapitalRecord record);

    List<TusCapitalRecord> selectByExampleWithBLOBs(TusCapitalRecordExample example);

    List<TusCapitalRecord> selectByExample(TusCapitalRecordExample example);

    TusCapitalRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TusCapitalRecord record, @Param("example") TusCapitalRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") TusCapitalRecord record, @Param("example") TusCapitalRecordExample example);

    int updateByExample(@Param("record") TusCapitalRecord record, @Param("example") TusCapitalRecordExample example);

    int updateByPrimaryKeySelective(TusCapitalRecord record);

    int updateByPrimaryKeyWithBLOBs(TusCapitalRecord record);

    int updateByPrimaryKey(TusCapitalRecord record);
}