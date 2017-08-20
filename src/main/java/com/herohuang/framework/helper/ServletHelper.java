package com.herohuang.framework.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * servlet helper
 *
 * @author Acheron
 * @date 16/08/2017
 * @since 1.0.0
 */
public final class ServletHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServletHelper.class);

    /**
     * 每个线程都有一份独自的serveltHelper实例
     */
    private static final ThreadLocal<ServletHelper> SERLVET_HELPER_THREAD = new ThreadLocal<>();

    private HttpServletRequest request;
    private HttpServletResponse response;

    public ServletHelper(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    /**
     * 初始化
     */
    public static void init(HttpServletRequest request, HttpServletResponse response) {
        SERLVET_HELPER_THREAD.set(new ServletHelper(request, response));
    }

    /**
     * 销毁
     */
    public static void destroy() {
        SERLVET_HELPER_THREAD.remove();
    }

    /**
     * 获取Request
     */
    private static HttpServletRequest getRequest() {
        return SERLVET_HELPER_THREAD.get().request;
    }

    /**
     * 获取Response
     */
    private static HttpServletResponse getResponse() {
        return SERLVET_HELPER_THREAD.get().response;
    }

    /**
     * 获取session
     */
    private static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 获取ServletContext
     */
    private static ServletContext getServletContext() {
        return getRequest().getServletContext();
    }

///// 一些常用的方法：//////////////////////////////////////

    /**
     * 将属性放入request中
     */
    public static void setRequestAttribute(String key, Object value) {
        getRequest().setAttribute(key, value);
    }

    /**
     * 从request中获取
     */
    public static <T> T getRequestAttribute(String key) {
        return (T) getRequest().getAttribute(key);
    }

    /**
     * 从request中移除属性
     */
    public static void removeRequestAttribute(String key) {
        getRequest().removeAttribute(key);
    }

    /**
     * 发送重定向响应
     */
    public static void sendRedirect(String location) {
        try {
            getResponse().sendRedirect(getRequest().getContextPath() + location);
        } catch (IOException e) {
            LOGGER.error("Redirect failure", e);
        }
    }


    /**
     * 将属性放入session
     */
    public static void setSessionAttribute(String key, Object value) {
        getSession().setAttribute(key, value);
    }

    /**
     * 从session中获取
     */
    public static <T> T getSessionAttribute(String key) {
        return (T) getRequest().getSession().getAttribute(key);
    }

    /**
     * 从session中移除属性
     */
    public static void removeSessionAttribute(String key) {
        getRequest().getSession().removeAttribute(key);
    }

    /**
     * session失效
     */
    public static void invalidateSession() {
        getRequest().getSession().invalidate();
    }


}
