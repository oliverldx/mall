package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class TrsGroupDistribution implements Serializable {
    private Long id;

    private Long trsActivityId;

    @ApiModelProperty(value = "一级返利")
    private Long levelOneBonus;

    @ApiModelProperty(value = "二级返利")
    private Long levelTwoBonus;

    @ApiModelProperty(value = "分销")
    private Integer groupDistribution;

    @ApiModelProperty(value = "教师一级返利")
    private Long teacherLoneBonus;

    @ApiModelProperty(value = "教师二级返利")
    private Long teacherLtwoBonus;

    @ApiModelProperty(value = "上下级绑定时间")
    private Integer bindLevelTime;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "修改时间")
    private Date modifyDate;

    @ApiModelProperty(value = "是否购买才可以分销")
    private Integer distributionAfterBuy;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrsActivityId() {
        return trsActivityId;
    }

    public void setTrsActivityId(Long trsActivityId) {
        this.trsActivityId = trsActivityId;
    }

    public Long getLevelOneBonus() {
        return levelOneBonus;
    }

    public void setLevelOneBonus(Long levelOneBonus) {
        this.levelOneBonus = levelOneBonus;
    }

    public Long getLevelTwoBonus() {
        return levelTwoBonus;
    }

    public void setLevelTwoBonus(Long levelTwoBonus) {
        this.levelTwoBonus = levelTwoBonus;
    }

    public Integer getGroupDistribution() {
        return groupDistribution;
    }

    public void setGroupDistribution(Integer groupDistribution) {
        this.groupDistribution = groupDistribution;
    }

    public Long getTeacherLoneBonus() {
        return teacherLoneBonus;
    }

    public void setTeacherLoneBonus(Long teacherLoneBonus) {
        this.teacherLoneBonus = teacherLoneBonus;
    }

    public Long getTeacherLtwoBonus() {
        return teacherLtwoBonus;
    }

    public void setTeacherLtwoBonus(Long teacherLtwoBonus) {
        this.teacherLtwoBonus = teacherLtwoBonus;
    }

    public Integer getBindLevelTime() {
        return bindLevelTime;
    }

    public void setBindLevelTime(Integer bindLevelTime) {
        this.bindLevelTime = bindLevelTime;
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

    public Integer getDistributionAfterBuy() {
        return distributionAfterBuy;
    }

    public void setDistributionAfterBuy(Integer distributionAfterBuy) {
        this.distributionAfterBuy = distributionAfterBuy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", trsActivityId=").append(trsActivityId);
        sb.append(", levelOneBonus=").append(levelOneBonus);
        sb.append(", levelTwoBonus=").append(levelTwoBonus);
        sb.append(", groupDistribution=").append(groupDistribution);
        sb.append(", teacherLoneBonus=").append(teacherLoneBonus);
        sb.append(", teacherLtwoBonus=").append(teacherLtwoBonus);
        sb.append(", bindLevelTime=").append(bindLevelTime);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", distributionAfterBuy=").append(distributionAfterBuy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}