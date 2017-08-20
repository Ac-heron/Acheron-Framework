package com.herohuang.framework.helper;

import com.herohuang.framework.annotation.Inject;
import com.herohuang.framework.util.ArrayUtil;
import com.herohuang.framework.util.CollectionUtil;
import com.herohuang.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入帮助类,实现Inject注解功能
 *
 * @author Acheron
 * @date 24/07/2017
 * @since 1.0.0
 */
public final class IocHelper {

    static {
        // 获取所有Bean
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            for (Map.Entry<Class<?>, Object> beanEntity : beanMap.entrySet()) {
                Class<?> beanClass = beanEntity.getKey();
                Object beanInstance = beanEntity.getValue();
                // 获取Bean类定义的所有成员变量(Field)
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    for (Field beanField : beanFields) {
                        // 判断当前Field是否带有Inject注解
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                // 通过反射初始化BeanField
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }

    }
}
