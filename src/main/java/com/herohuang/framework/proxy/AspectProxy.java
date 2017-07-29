package com.herohuang.framework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 切面代理
 *
 * @author Acheron
 * @date 27/07/2017
 * @since 1.0.0
 */
public abstract class AspectProxy implements Proxy {

    public static final Logger LOGGER = LoggerFactory.getLogger(AspectProxy.class);

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;
        Class<?> targetClass = proxyChain.getTargetClass();
        Method targetMethod = proxyChain.getTargetMethod();
        Object[] methodParams = proxyChain.getMethodParams();

        begin();
        try {
            if (intercept(targetClass, targetMethod, methodParams)) {
                before(targetClass, targetMethod, methodParams);
                result = proxyChain.doProxyChain();
                after(targetClass, targetMethod, methodParams, result);
            } else {
                result = proxyChain.doProxyChain();
            }

        } catch (Exception e) {
            LOGGER.error("Proxy failure", e);
            error(targetClass, targetMethod, methodParams, e);
            throw e;
        } finally {
            end();
        }
        return result;
    }

    public boolean intercept(Class<?> targetclass, Method targetmethod, Object[] methodparams) {
        return true;
    }

    public void after(Class<?> targetClass, Method targetMethod, Object[] methodParams, Object result) {
    }

    public void before(Class<?> targetClass, Method targetMethod, Object[] methodParams) {
    }

    public void error(Class<?> targetClass, Method targetMethod, Object[] methodParams, Exception e) {
    }

    public void begin() {

    }

    public void end() {

    }
}
