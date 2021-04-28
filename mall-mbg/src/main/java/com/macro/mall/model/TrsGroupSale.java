package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TrsGroupSale implements Serializable {
    private Long id;

    private Long trsActivityId;

    @ApiModelProperty(value = "库存")
    private Integer groupNum;

    @ApiModelProperty(value = "报名数")
    private Integer groupHours;

    @ApiModelProperty(value = "是否开启拼团")
    private Integer groupSale;

    @ApiModelProperty(value = "拼团价格")
    private BigDecimal price;

    @ApiModelProperty(value = "拼团分销奖金")
    private BigDecimal bonus;

    @ApiModelProperty(value = "教师拼团分销奖金")
    private BigDecimal teacherBonus;

    @ApiModelProperty(value = "成团及佣金")
    private Integer groupCommission;

    @ApiModelProperty(value = "创建时间")
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

    public Long getTrsActivityId() {
        return trsActivityId;
    }

    public void setTrsActivityId(Long trsActivityId) {
        this.trsActivityId = trsActivityId;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

    public Integer getGroupHours() {
        return groupHours;
    }

    public void setGroupHours(Integer groupHours) {
        this.groupHours = groupHours;
    }

    public Integer getGroupSale() {
        return groupSale;
    }

    public void setGroupSale(Integer groupSale) {
        this.groupSale = groupSale;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public BigDecimal getTeacherBonus() {
        return teacherBonus;
    }

    public void setTeacherBonus(BigDecimal teacherBonus) {
        this.teacherBonus = teacherBonus;
    }

    public Integer getGroupCommission() {
        return groupCommission;
    }

    public void setGroupCommission(Integer groupCommission) {
        this.groupCommission = groupCommission;
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
        sb.append(", trsActivityId=").append(trsActivityId);
        sb.append(", groupNum=").append(groupNum);
        sb.append(", groupHours=").append(groupHours);
        sb.append(", groupSale=").append(groupSale);
        sb.append(", price=").append(price);
        sb.append(", bonus=").append(bonus);
        sb.append(", teacherBonus=").append(teacherBonus);
        sb.append(", groupCommission=").append(groupCommission);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}