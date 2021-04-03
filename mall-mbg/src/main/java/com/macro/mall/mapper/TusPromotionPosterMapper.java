package com.macro.mall.mapper;

import com.macro.mall.model.TusPromotionPoster;
import com.macro.mall.model.TusPromotionPosterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TusPromotionPosterMapper {
    long countByExample(TusPromotionPosterExample example);

    int deleteByExample(TusPromotionPosterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TusPromotionPoster record);

    int insertSelective(TusPromotionPoster record);

    List<TusPromotionPoster> selectByExampleWithBLOBs(TusPromotionPosterExample example);

    List<TusPromotionPoster> selectByExample(TusPromotionPosterExample example);

    TusPromotionPoster selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TusPromotionPoster record, @Param("example") TusPromotionPosterExample example);

    int updateByExampleWithBLOBs(@Param("record") TusPromotionPoster record, @Param("example") TusPromotionPosterExample example);

    int updateByExample(@Param("record") TusPromotionPoster record, @Param("example") TusPromotionPosterExample example);

    int updateByPrimaryKeySelective(TusPromotionPoster record);

    int updateByPrimaryKeyWithBLOBs(TusPromotionPoster record);

    int updateByPrimaryKey(TusPromotionPoster record);
}