package com.macro.mall.mapper;

import com.macro.mall.model.TusRelationshipConfig;
import com.macro.mall.model.TusRelationshipConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TusRelationshipConfigMapper {
    long countByExample(TusRelationshipConfigExample example);

    int deleteByExample(TusRelationshipConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TusRelationshipConfig record);

    int insertSelective(TusRelationshipConfig record);

    List<TusRelationshipConfig> selectByExample(TusRelationshipConfigExample example);

    TusRelationshipConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TusRelationshipConfig record, @Param("example") TusRelationshipConfigExample example);

    int updateByExample(@Param("record") TusRelationshipConfig record, @Param("example") TusRelationshipConfigExample example);

    int updateByPrimaryKeySelective(TusRelationshipConfig record);

    int updateByPrimaryKey(TusRelationshipConfig record);
}