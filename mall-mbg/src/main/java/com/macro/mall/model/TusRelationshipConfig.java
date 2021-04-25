package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class TusRelationshipConfig implements Serializable {
    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long tusUserId;

    @ApiModelProperty(value = "一级")
    private Long levelOne;

    @ApiModelProperty(value = "直接二级用户")
    private Long levelTwo;

    @ApiModelProperty(value = "是否下单")
    private Integer takeOrder;

    @ApiModelProperty(value = "等级")
    private Integer level;

    @ApiModelProperty(value = "所属团队")
    private Long team;

    @ApiModelProperty(value = "所属学校")
    private Long school;

    @ApiModelProperty(value = "注册时间")
    private Date createDate;

    @ApiModelProperty(value = "修改时间")
    private Date modifyDate;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTusUserId() {
        return tusUserId;
    }

    public void setTusUserId(Long tusUserId) {
        this.tusUserId = tusUserId;
    }

    public Long getLevelOne() {
        return levelOne;
    }

    public void setLevelOne(Long levelOne) {
        this.levelOne = levelOne;
    }

    public Long getLevelTwo() {
        return levelTwo;
    }

    public void setLevelTwo(Long levelTwo) {
        this.levelTwo = levelTwo;
    }

    public Integer getTakeOrder() {
        return takeOrder;
    }

    public void setTakeOrder(Integer takeOrder) {
        this.takeOrder = takeOrder;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getTeam() {
        return team;
    }

    public void setTeam(Long team) {
        this.team = team;
    }

    public Long getSchool() {
        return school;
    }

    public void setSchool(Long school) {
        this.school = school;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tusUserId=").append(tusUserId);
        sb.append(", levelOne=").append(levelOne);
        sb.append(", levelTwo=").append(levelTwo);
        sb.append(", takeOrder=").append(takeOrder);
        sb.append(", level=").append(level);
        sb.append(", team=").append(team);
        sb.append(", school=").append(school);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}