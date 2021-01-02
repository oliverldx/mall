package com.macro.mall.mapper;

import com.macro.mall.model.TrsActivity;
import com.macro.mall.model.TrsActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrsActivityMapper {
    long countByExample(TrsActivityExample example);

    int deleteByExample(TrsActivityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TrsActivity record);

    int insertSelective(TrsActivity record);

    List<TrsActivity> selectByExampleWithBLOBs(TrsActivityExample example);

    List<TrsActivity> selectByExample(TrsActivityExample example);

    TrsActivity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TrsActivity record, @Param("example") TrsActivityExample example);

    int updateByExampleWithBLOBs(@Param("record") TrsActivity record, @Param("example") TrsActivityExample example);

    int updateByExample(@Param("record") TrsActivity record, @Param("example") TrsActivityExample example);

    int updateByPrimaryKeySelective(TrsActivity record);

    int updateByPrimaryKeyWithBLOBs(TrsActivity record);

    int updateByPrimaryKey(TrsActivity record);
}