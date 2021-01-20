package com.macro.mall.base;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.Iterator;
import java.util.StringJoiner;

public abstract class Deserializer<T> extends JsonDeserializer<T> {

    public abstract T create();

    public Class<T> getTClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        System.out.println("test Deserializer");
        TreeNode treeNode = p.getCodec().readTree(p);
        T t = create();
        Class<T> tClass = getTClass();
        FieldUtils.getAllFieldsList(tClass).stream().forEach(field -> {
            Class<?> type = field.getType();
            String typeName = type.getSimpleName();
            String fieldName = field.getName();
            System.out.println("field name:"+fieldName + ", type name: " + typeName);
            TreeNode node = treeNode.get(fieldName);
            try {
                if(StringUtils.containsIgnoreCase(typeName,"long")) {
                    if(StringUtils.equalsIgnoreCase("serialVersionUID",fieldName)) {
                        return;
                    }
                    IntNode n = (IntNode) node;
                    PropertyUtils.setProperty(t,fieldName,n.longValue());
                }else if(StringUtils.containsIgnoreCase(typeName,"int")) {
                    if(node instanceof TextNode) {
                        TextNode n = (TextNode) node;
                        PropertyUtils.setProperty(t,fieldName,n.intValue());
                    }else if(node instanceof IntNode) {
                        IntNode n = (IntNode) node;
                        PropertyUtils.setProperty(t,fieldName,n.intValue());
                    }
                }else if(StringUtils.containsIgnoreCase(typeName,"Date")) {
                    LongNode n = (LongNode) node;
                    PropertyUtils.setProperty(t,fieldName, new Date(n.longValue()));
                }else if (StringUtils.containsIgnoreCase(typeName,"string")) {
                    if(node instanceof TextNode) {
                        TextNode n = (TextNode) node;
                        PropertyUtils.setProperty(t,fieldName,n.asText());
                    }else if(node instanceof ArrayNode) {
                        ArrayNode n = (ArrayNode) node;
                        if (n == null || n.size() == 0) {
                            PropertyUtils.setProperty(t,fieldName,"[]");
                        }else {
                            Iterator<JsonNode> elements = n.elements();
                            StringJoiner stringJoiner = new StringJoiner(",");
                            while (elements.hasNext()) {
                                JsonNode next = elements.next();
                                stringJoiner.add(next.asText());
                            }
                            PropertyUtils.setProperty(t,fieldName,"["+stringJoiner.toString() + "]");
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        return t;
    }
}
