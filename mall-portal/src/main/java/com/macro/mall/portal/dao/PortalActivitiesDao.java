package com.macro.mall.portal.dao;

import com.macro.mall.portal.domain.Activities;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PortalActivitiesDao {

    List<Activities> getActivities(@Param("id")String id);
}
