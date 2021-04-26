package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class TosOrderCourse implements Serializable {
    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "订单id")
    private Long tosOrderId;

    @ApiModelProperty(value = "课程id")
    private Long trsCourseId;

    @ApiModelProperty(value = "分校")
    private String school;

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

    public Long getTosOrderId() {
        return tosOrderId;
    }

    public void setTosOrderId(Long tosOrderId) {
        this.tosOrderId = tosOrderId;
    }

    public Long getTrsCourseId() {
        return trsCourseId;
    }

    public void setTrsCourseId(Long trsCourseId) {
        this.trsCourseId = trsCourseId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
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
        sb.append(", tosOrderId=").append(tosOrderId);
        sb.append(", trsCourseId=").append(trsCourseId);
        sb.append(", school=").append(school);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}