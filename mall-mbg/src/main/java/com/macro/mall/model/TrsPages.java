package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class TrsPages implements Serializable {
    private Long id;

    private Long trsActivityId;

    @ApiModelProperty(value = "分享页商品标题")
    private String name;

    @ApiModelProperty(value = "分享标题")
    private String subName;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "修改时间")
    private Date modifyDate;

    @ApiModelProperty(value = "首页学校显示数量")
    private Integer showSchNum;

    @ApiModelProperty(value = "首页课程显示数量")
    private Integer showCrsNum;

    @ApiModelProperty(value = "收入排行榜")
    private Integer incomeRanking;

    @ApiModelProperty(value = "是否显示报名数")
    private Integer showBooking;

    @ApiModelProperty(value = "分享页显示我的收入")
    private Integer showMyIncome;

    @ApiModelProperty(value = "倒计时天数")
    private Integer dayLimit;

    @ApiModelProperty(value = "分享页顶部轮播图片")
    private String swipePic;

    @ApiModelProperty(value = "主页面顶部图片")
    private String topPic;

    @ApiModelProperty(value = "分享图片")
    private String sharePic;

    @ApiModelProperty(value = "分享描述")
    private String description;

    @ApiModelProperty(value = "背景颜色")
    private String backgroundColor;

    @ApiModelProperty(value = "音频文件")
    private String audio;

    @ApiModelProperty(value = "分享海报底部文字")
    private String buttomText;

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

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public Integer getShowSchNum() {
        return showSchNum;
    }

    public void setShowSchNum(Integer showSchNum) {
        this.showSchNum = showSchNum;
    }

    public Integer getShowCrsNum() {
        return showCrsNum;
    }

    public void setShowCrsNum(Integer showCrsNum) {
        this.showCrsNum = showCrsNum;
    }

    public Integer getIncomeRanking() {
        return incomeRanking;
    }

    public void setIncomeRanking(Integer incomeRanking) {
        this.incomeRanking = incomeRanking;
    }

    public Integer getShowBooking() {
        return showBooking;
    }

    public void setShowBooking(Integer showBooking) {
        this.showBooking = showBooking;
    }

    public Integer getShowMyIncome() {
        return showMyIncome;
    }

    public void setShowMyIncome(Integer showMyIncome) {
        this.showMyIncome = showMyIncome;
    }

    public Integer getDayLimit() {
        return dayLimit;
    }

    public void setDayLimit(Integer dayLimit) {
        this.dayLimit = dayLimit;
    }

    public String getSwipePic() {
        return swipePic;
    }

    public void setSwipePic(String swipePic) {
        this.swipePic = swipePic;
    }

    public String getTopPic() {
        return topPic;
    }

    public void setTopPic(String topPic) {
        this.topPic = topPic;
    }

    public String getSharePic() {
        return sharePic;
    }

    public void setSharePic(String sharePic) {
        this.sharePic = sharePic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getButtomText() {
        return buttomText;
    }

    public void setButtomText(String buttomText) {
        this.buttomText = buttomText;
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
        sb.append(", subName=").append(subName);
        sb.append(", sort=").append(sort);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", showSchNum=").append(showSchNum);
        sb.append(", showCrsNum=").append(showCrsNum);
        sb.append(", incomeRanking=").append(incomeRanking);
        sb.append(", showBooking=").append(showBooking);
        sb.append(", showMyIncome=").append(showMyIncome);
        sb.append(", dayLimit=").append(dayLimit);
        sb.append(", swipePic=").append(swipePic);
        sb.append(", topPic=").append(topPic);
        sb.append(", sharePic=").append(sharePic);
        sb.append(", description=").append(description);
        sb.append(", backgroundColor=").append(backgroundColor);
        sb.append(", audio=").append(audio);
        sb.append(", buttomText=").append(buttomText);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}