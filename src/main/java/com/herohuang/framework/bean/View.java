package com.herohuang.framework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回视图，如果是view类型，则代表一个页面(jsp等
 *
 * @author Acheron
 * @date 25/07/2017
 * @since 1.0.0
 */
public class View {

    /**
     * 视图路径
     */
    private String path;

    /**
     * 模型数据
     */
    private Map<String, Object> model;

    public View(String path) {
        this.path = path;
        model = new HashMap<>();
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public View addModel(String key, Object value) {
        model.put(key, value);
        return this;
    }
}

