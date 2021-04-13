package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class TrsActivity implements Serializable {
    private Long id;

    @ApiModelProperty(value = "活动名称")
    private String name;

    @ApiModelProperty(value = "活动价格")
    private Long price;

    @ApiModelProperty(value = "销售数量")
    private Integer salesNum;

    @ApiModelProperty(value = "课程数量")
    private Integer courseNum;

    @ApiModelProperty(value = "访问二维码")
    private String qrcode;

    @ApiModelProperty(value = "结束时间")
    private Date endDate;

    @ApiModelProperty(value = "开始时间")
    private Date startDate;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "修改时间")
    private Date modifyDate;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "是否需要选足课程")
    private Integer chooseAllCourse;

    @ApiModelProperty(value = "赠品可选数量限制")
    private Integer giftNum;

    @ApiModelProperty(value = "是否开启抽奖")
    private Integer luckyDraw;

    @ApiModelProperty(value = "是否开启机构评分")
    private Integer schoolMark;

    @ApiModelProperty(value = "图片")
    private String pic;

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(Integer salesNum) {
        this.salesNum = salesNum;
    }

    public Integer getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(Integer courseNum) {
        this.courseNum = courseNum;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

    public Integer getChooseAllCourse() {
        return chooseAllCourse;
    }

    public void setChooseAllCourse(Integer chooseAllCourse) {
        this.chooseAllCourse = chooseAllCourse;
    }

    public Integer getGiftNum() {
        return giftNum;
    }

    public void setGiftNum(Integer giftNum) {
        this.giftNum = giftNum;
    }

    public Integer getLuckyDraw() {
        return luckyDraw;
    }

    public void setLuckyDraw(Integer luckyDraw) {
        this.luckyDraw = luckyDraw;
    }

    public Integer getSchoolMark() {
        return schoolMark;
    }

    public void setSchoolMark(Integer schoolMark) {
        this.schoolMark = schoolMark;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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
        sb.append(", price=").append(price);
        sb.append(", salesNum=").append(salesNum);
        sb.append(", courseNum=").append(courseNum);
        sb.append(", qrcode=").append(qrcode);
        sb.append(", endDate=").append(endDate);
        sb.append(", startDate=").append(startDate);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", status=").append(status);
        sb.append(", chooseAllCourse=").append(chooseAllCourse);
        sb.append(", giftNum=").append(giftNum);
        sb.append(", luckyDraw=").append(luckyDraw);
        sb.append(", schoolMark=").append(schoolMark);
        sb.append(", pic=").append(pic);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}