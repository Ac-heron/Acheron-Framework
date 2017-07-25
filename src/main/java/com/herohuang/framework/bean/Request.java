package com.herohuang.framework.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 封闭请求信息
 *
 * @author Acheron
 * @date 25/07/2017
 * @since 1.0.0
 */
public class Request {

    /**
     * request method
     */
    private String requestMethod;

    /**
     * request path
     */
   private String requestPath;

    public Request(String requestMethod, String requestPath) {
        this.requestMethod = requestMethod;
        this.requestPath = requestPath;
    }

    public String getRequestMethod() {
        return requestMethod;
    }


    public String getRequestPath() {
        return requestPath;
    }

    /**
     * 此处重写hashcode equals方法，不然controllerhelper中的ACTION_MAP存进去，取出来的不一致
     * @return
     */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
}
