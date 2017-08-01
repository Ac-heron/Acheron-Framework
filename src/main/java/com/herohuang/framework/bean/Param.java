package com.herohuang.framework.bean;

import com.herohuang.framework.util.CastUtil;
import com.herohuang.framework.util.CollectionUtil;

import java.util.Map;

/**
 * 封装请求参数
 *
 * @author Acheron
 * @date 25/07/2017
 * @since 1.0.0
 */
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 获取所有参数
     *
     * @return
     */
    public Map<String, Object> getMap() {
        return paramMap;
    }

    /**
     * 验证是否为空
     *
     * @param
     * @return
     */
    public boolean isEmpty() {
        return CollectionUtil.isEmpty(paramMap);
    }


    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    public int getInt(String name) {
        return CastUtil.castInt(paramMap.get(name));
    }

    public String getString(String name) {
        return CastUtil.castString(paramMap.get(name));
    }

    public boolean getBoolean(String name) {
        return CastUtil.castBoolean(paramMap.get(name));
    }

    public double getDouble(String name) {
        return CastUtil.castDouble(paramMap.get(name));
    }

}
