package com.herohuang.framework.bean;

import java.lang.reflect.Method;

/**
 * 封闭处Action处理信息
 *
 * @author Acheron
 * @date 25/07/2017
 * @since 1.0.0
 */
public class Handler {

    /**
     * Controller Class
     */
    private Class<?> controllerClass;

    /**
     * Action method
     */
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
