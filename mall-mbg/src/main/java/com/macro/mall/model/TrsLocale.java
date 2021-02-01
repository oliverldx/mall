package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class TrsLocale implements Serializable {
    private Long id;

    private Long trsActivityId;

    @ApiModelProperty(value = "活动名称")
    private String name;

    @ApiModelProperty(value = "3D图形文字")
    private String text3d;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "修改时间")
    private Date modifyDate;

    @ApiModelProperty(value = "是否开启")
    private Integer enable;

    @ApiModelProperty(value = "开启二维码自动注册老师")
    private Integer autoRegTeache;

    @ApiModelProperty(value = "开启家长组二维码")
    private Integer qrcodeParents;

    @ApiModelProperty(value = "活动连接")
    private String link;

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

    public String getText3d() {
        return text3d;
    }

    public void setText3d(String text3d) {
        this.text3d = text3d;
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

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getAutoRegTeache() {
        return autoRegTeache;
    }

    public void setAutoRegTeache(Integer autoRegTeache) {
        this.autoRegTeache = autoRegTeache;
    }

    public Integer getQrcodeParents() {
        return qrcodeParents;
    }

    public void setQrcodeParents(Integer qrcodeParents) {
        this.qrcodeParents = qrcodeParents;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
        sb.append(", text3d=").append(text3d);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", enable=").append(enable);
        sb.append(", autoRegTeache=").append(autoRegTeache);
        sb.append(", qrcodeParents=").append(qrcodeParents);
        sb.append(", link=").append(link);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}