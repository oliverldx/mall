<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.macro.mall.dao.${tableName}Dao">

    <select id="getBy${fkId?cap_first}" resultMap="com.macro.mall.mapper.${tableName}Mapper.BaseResultMap">
        ${sql}
    </select>
</mapper>