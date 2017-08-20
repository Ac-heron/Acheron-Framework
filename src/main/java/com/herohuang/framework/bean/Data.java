package com.herohuang.framework.bean;

/**
 * 返回,如果是Data类型
 *
 * @author Acheron
 * @date 25/07/2017
 * @since 1.0.0
 */
public class Data {

    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }

}
