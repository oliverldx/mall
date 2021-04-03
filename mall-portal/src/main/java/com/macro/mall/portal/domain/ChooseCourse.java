package com.macro.mall.portal.domain;

import com.macro.mall.model.TrsCourse;
import lombok.Data;

import java.io.Serializable;

@Data
public class ChooseCourse extends TrsCourse implements Serializable {

    private String bookNum;
    private String schoolName;
    private String addresses;


}
