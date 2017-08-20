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

    private static final Logger LOGGER = LoggerFactory.getLogger(AspectProxy.class);

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;
        Class<?> cls = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] params = proxyChain.getMethodParams();

        begin();
        try {
            if (intercept(cls, method, params)) {
                before(cls, method, params);
                result = proxyChain.doProxyChain();
                after(cls, method, params, result);
            } else {
                result = proxyChain.doProxyChain();
            }

        } catch (Exception e) {
            LOGGER.error("Proxy failure", e);
            error(cls, method, params, e);
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
