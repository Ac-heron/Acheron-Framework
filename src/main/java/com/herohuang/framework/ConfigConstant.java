package com.herohuang.framework;

/**
 * 配置常量
 *
 * @author Acheron
 * @since 1.0.0
 */
public interface ConfigConstant {
    String CONFIG_FILE = "heron.properties";

    String JDBC_DRIVER = "heron.framework.jdbc.driver";
    String JDBC_URL = "heron.framework.jdbc.url";
    String JDBC_USERNAME = "heron.framework.jdbc.username";
    String JDBC_PASSWORD = "heron.framework.jdbc.password";

    String APP_BASE_PACKAGE = "heron.framework.app.base_package";
    String APP_JSP_PATH = "heron.framework.app.jsp_path";
    String APP_STATIC_PATH = "heron.framework.app.static_path";

    String APP_UPLOAD_LIMIT = "heron.framework.app.upload_limit";
}
