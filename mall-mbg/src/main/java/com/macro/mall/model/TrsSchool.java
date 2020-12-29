package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class TrsSchool implements Serializable {
    private Long id;

    @ApiModelProperty(value = "机构名称")
    private String name;

    @ApiModelProperty(value = "联系人")
    private String contactName;

    @ApiModelProperty(value = "联系方式")
    private String contactNo;

    @ApiModelProperty(value = "机构logo")
    private String logo;

    @ApiModelProperty(value = "机构视频")
    private String video;

    @ApiModelProperty(value = "地图标注")
    private String latlongitude;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "修改时间")
    private Date modifyDate;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "分校名称")
    private String subSchool;

    @ApiModelProperty(value = "介绍")
    private String description;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getLatlongitude() {
        return latlongitude;
    }

    public void setLatlongitude(String latlongitude) {
        this.latlongitude = latlongitude;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSubSchool() {
        return subSchool;
    }

    public void setSubSchool(String subSchool) {
        this.subSchool = subSchool;
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
        sb.append(", name=").append(name);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactNo=").append(contactNo);
        sb.append(", logo=").append(logo);
        sb.append(", video=").append(video);
        sb.append(", latlongitude=").append(latlongitude);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", status=").append(status);
        sb.append(", subSchool=").append(subSchool);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}