package com.macro.mall.base;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.macro.mall.model.TrsPages;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public abstract class Serializer<T> extends JsonSerializer<T> {

    public abstract List<String> getStrArrayFields();

    public void writeStringToArray(T t, String fieldName, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        jsonGenerator.writeFieldName(fieldName);
        String property = (String) PropertyUtils.getProperty(t, fieldName);
        if(StringUtils.isBlank(property)) {
            jsonGenerator.writeObject(Arrays.asList());
        }else {
            String[] strArray = Convert.toStrArray(StrUtil.strip(property, "[", "]"));
            jsonGenerator.writeObject(strArray);
        }
    }

    @Override
    public void serialize(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        System.out.println("test Serializer");
        jsonGenerator.writeStartObject();
        FieldUtils.getAllFieldsList(TrsPages.class).stream().forEach(field -> {
            Class<?> type = field.getType();
            String typeName = type.getSimpleName();
            String fieldName = field.getName();
//                System.out.println("field name:"+fieldName + ", type name: " + typeName);
            List<String> strArrayFields = getStrArrayFields();
            try {
                if(strArrayFields.contains(fieldName))  {
                    writeStringToArray(t, fieldName, jsonGenerator, serializerProvider);
                    return;
                }
                if(StringUtils.containsIgnoreCase(typeName,"long")) {
                    if(StringUtils.equalsIgnoreCase("serialVersionUID",fieldName)) {
                        return;
                    }
                    jsonGenerator.writeNumberField(fieldName, (Long) PropertyUtils.getProperty(t,fieldName));
                }else if(StringUtils.containsIgnoreCase(typeName,"int")) {
                    jsonGenerator.writeNumberField(fieldName,(Integer) PropertyUtils.getProperty(t,fieldName));
                }else if(StringUtils.containsIgnoreCase(typeName,"Date")) {
                    Date date = (Date) PropertyUtils.getProperty(t, fieldName);
                    jsonGenerator.writeNumberField(fieldName, date.getTime());
                }else if (StringUtils.containsIgnoreCase(typeName,"string")) {
                    jsonGenerator.writeObjectField(fieldName, (String) PropertyUtils.getProperty(t,fieldName));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        jsonGenerator.writeEndObject();
    }
}
