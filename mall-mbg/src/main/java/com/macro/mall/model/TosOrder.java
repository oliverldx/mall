package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class TosOrder implements Serializable {
    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "ID")
    private Long tusUserId;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "订单状态")
    private Integer status;

    @ApiModelProperty(value = "下单时间")
    private Date orderTime;

    @ApiModelProperty(value = "支付时间")
    private Date payTime;

    @ApiModelProperty(value = "总金额")
    private Long totalMoney;

    @ApiModelProperty(value = "分销金额")
    private Long distributionMoney;

    @ApiModelProperty(value = "成团时间")
    private Date groupTime;

    @ApiModelProperty(value = "成团订单数量")
    private Integer groupOrderNo;

    @ApiModelProperty(value = "订单类型")
    private Integer type;

    @ApiModelProperty(value = "团类型")
    private Integer groupType;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Long getDistributionMoney() {
        return distributionMoney;
    }

    public void setDistributionMoney(Long distributionMoney) {
        this.distributionMoney = distributionMoney;
    }

    public Date getGroupTime() {
        return groupTime;
    }

    public void setGroupTime(Date groupTime) {
        this.groupTime = groupTime;
    }

    public Integer getGroupOrderNo() {
        return groupOrderNo;
    }

    public void setGroupOrderNo(Integer groupOrderNo) {
        this.groupOrderNo = groupOrderNo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
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
        sb.append(", orderNo=").append(orderNo);
        sb.append(", status=").append(status);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", payTime=").append(payTime);
        sb.append(", totalMoney=").append(totalMoney);
        sb.append(", distributionMoney=").append(distributionMoney);
        sb.append(", groupTime=").append(groupTime);
        sb.append(", groupOrderNo=").append(groupOrderNo);
        sb.append(", type=").append(type);
        sb.append(", groupType=").append(groupType);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}