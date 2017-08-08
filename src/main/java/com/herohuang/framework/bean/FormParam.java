package com.herohuang.framework.bean;

/**
 * 封装表单参数
 *
 * @author Acheron
 * @date 08/08/2017
 * @since 1.0.0
 */
public class FormParam {
    private String fieldName;
    private Object fieldValue;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }

    public FormParam(String fieldName, Object fieldValue) {

        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
