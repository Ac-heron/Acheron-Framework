package com.herohuang.framework.helper;

import com.herohuang.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 此类作用：相当于一个bean容器
 * 根据类来实例化对象，将对象放在一个静态的Map中，通过map的key来获取value(bean对象）
 *
 * @author Acheron
 * @date 24/07/2017
 * @since 1.0.0
 */
public final class BeanHelper {

    /**
     * 存放Bean类与Bean实例的映射关系
     */
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet) {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, obj);
        }
    }

    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    /**
     * 获取Bean实例
     *
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> cls) {
        if (!BEAN_MAP.containsKey(cls)) {
            throw new RuntimeException("Cant not get ban by class:" + cls);
        }
        return (T) BEAN_MAP.get(cls);
    }

    /**
     * 设置bean实例
     *
     * @param cls
     * @param obj
     */
    public static void setBean(Class<?> cls, Object obj) {
        BEAN_MAP.put(cls, obj);
    }

}
