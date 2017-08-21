package com.herohuang.framework.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 编码解码工具类
 *
 * @author Acheron
 * @date 25/07/2017
 * @since 1.0.0
 */
public final class CodecUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);

    /**
     * 将url编码
     */
    public static String encodeURL(String source) {
        String target;
        try {
            target = URLEncoder.encode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("Encode url failure", e);
            throw new RuntimeException(e);
        }
        return target;
    }

    /**
     * 将url解码
     */
    public static String decodeURL(String source) {
        String target;
        try {
            target = URLDecoder.decode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("Decode url failure", e);
            throw new RuntimeException(e);
        }
        return target;
    }

    /**
     * md5加密
     */
    public static String md5(String source) {
        return DigestUtils.md5Hex(source);
    }
}
