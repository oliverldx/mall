package com.macro.mall.portal.vo.converter;

import com.macro.mall.model.OmsOrderPayment;
import com.macro.mall.portal.vo.AliPayNotifyVO;
import org.mapstruct.Mapper;


@Mapper(componentModel="spring")
public interface OmsOrderPaymentConverter {
    /*@Mappings({
            @Mapping(source = "birthday", target = "birth"),
            @Mapping(source = "birthday", target = "birthDateFormat", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "birthExpressionFormat", expression = "java(org.apache.commons.lang3.time.DateFormatUtils.format(person.getBirthday(),\"yyyy-MM-dd HH:mm:ss\"))"),
            @Mapping(source = "user.age", target = "age"),
            @Mapping(target = "email", ignore = true)
    })*/

    OmsOrderPayment aliPayNotifyVO2OmsOrderPayment(AliPayNotifyVO aliPayNotifyVO);
}