package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class TrsGift implements Serializable {
    private Long id;

    private Long trsActivityId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "赞助商名称")
    private String sponsorName;

    @ApiModelProperty(value = "数量")
    private Integer num;

    @ApiModelProperty(value = "价值")
    private Long price;

    @ApiModelProperty(value = "有效期")
    private Date validateTime;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "修改时间")
    private Date modifyDate;

    @ApiModelProperty(value = "商品图片")
    private String pic;

    @ApiModelProperty(value = "商家地址")
    private String sponsorAddress;

    @ApiModelProperty(value = "介绍")
    private String description;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getValidateTime() {
        return validateTime;
    }

    public void setValidateTime(Date validateTime) {
        this.validateTime = validateTime;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getSponsorAddress() {
        return sponsorAddress;
    }

    public void setSponsorAddress(String sponsorAddress) {
        this.sponsorAddress = sponsorAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", trsActivityId=").append(trsActivityId);
        sb.append(", name=").append(name);
        sb.append(", sponsorName=").append(sponsorName);
        sb.append(", num=").append(num);
        sb.append(", price=").append(price);
        sb.append(", validateTime=").append(validateTime);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", pic=").append(pic);
        sb.append(", sponsorAddress=").append(sponsorAddress);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}