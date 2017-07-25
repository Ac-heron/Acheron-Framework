package com.herohuang.framework.helper;

import com.herohuang.framework.annotation.Controller;
import com.herohuang.framework.annotation.Service;
import com.herohuang.framework.util.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Class helper
 * 此类用户获取应用包下的所有类，应用包下的所有service类，所有controller类
 * 获取应用包名下的所有Bean类(带有Controllert和service注解的类产生的对象理解为本框架所管理的Bean）
 *
 * @author Acheron
 * @date 24/07/2017
 * @since 1.0.0
 */
public final class ClassHelper {

    /**
     * 用户存放所加载的类
     */
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取应用包下的所有类
     */
    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    /**
     * 获取应用包下所有service类
     */
    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Service.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包下所有Controller类
     */
    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Controller.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包下的所有Bean类(包括Service/Controller等）
     */
    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> classSet = new HashSet<>();
        classSet.addAll(getServiceClassSet());
        classSet.addAll(getControllerClassSet());
        return classSet;
    }

}
