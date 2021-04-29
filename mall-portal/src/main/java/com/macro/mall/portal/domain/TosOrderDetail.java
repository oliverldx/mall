package com.macro.mall.portal.domain;

import com.macro.mall.model.TosOrder;
import com.macro.mall.model.TosOrderCourse;
import com.macro.mall.model.TosOrderGift;
import lombok.Data;

import java.util.List;

@Data
public class TosOrderDetail {

    private TosOrder tosOrder;
    private List<TosOrderGift> tosOrderGifts;
    private List<TosOrderCourse> tosOrderCourses;

}
