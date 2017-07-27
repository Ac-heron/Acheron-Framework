package com.herohuang.framework.proxy;

/**
 * 代理接口
 *
 * @author Acheron
 * @date 27/07/2017
 * @since 1.0.0
 */
public interface Proxy {

    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
