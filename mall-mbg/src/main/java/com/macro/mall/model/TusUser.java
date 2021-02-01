package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class TusUser implements Serializable {
    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "等级")
    private String level;

    @ApiModelProperty(value = "余额")
    private Long balance;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "是否下单")
    private String takeOrder;

    @ApiModelProperty(value = "邀请人数")
    private Integer invitePeopleCount;

    @ApiModelProperty(value = "注册时间")
    private Date createDate;

    @ApiModelProperty(value = "修改时间")
    private Date modifyDate;

    @ApiModelProperty(value = "上一级")
    private Long parentLevelOne;

    @ApiModelProperty(value = "上二级")
    private Long parentLevelTwo;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "头像")
    private String pic;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTakeOrder() {
        return takeOrder;
    }

    public void setTakeOrder(String takeOrder) {
        this.takeOrder = takeOrder;
    }

    public Integer getInvitePeopleCount() {
        return invitePeopleCount;
    }

    public void setInvitePeopleCount(Integer invitePeopleCount) {
        this.invitePeopleCount = invitePeopleCount;
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

    public Long getParentLevelOne() {
        return parentLevelOne;
    }

    public void setParentLevelOne(Long parentLevelOne) {
        this.parentLevelOne = parentLevelOne;
    }

    public Long getParentLevelTwo() {
        return parentLevelTwo;
    }

    public void setParentLevelTwo(Long parentLevelTwo) {
        this.parentLevelTwo = parentLevelTwo;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", nickName=").append(nickName);
        sb.append(", level=").append(level);
        sb.append(", balance=").append(balance);
        sb.append(", sex=").append(sex);
        sb.append(", name=").append(name);
        sb.append(", mobile=").append(mobile);
        sb.append(", takeOrder=").append(takeOrder);
        sb.append(", invitePeopleCount=").append(invitePeopleCount);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", parentLevelOne=").append(parentLevelOne);
        sb.append(", parentLevelTwo=").append(parentLevelTwo);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", pic=").append(pic);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}