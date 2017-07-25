package com.herohuang.framework;

import com.herohuang.framework.helper.BeanHelper;
import com.herohuang.framework.helper.ClassHelper;
import com.herohuang.framework.helper.ControllerHelper;
import com.herohuang.framework.helper.IocHelper;
import com.herohuang.framework.util.ClassUtil;

/**
 * 统一加载各种Helper类
 *
 * @author Acheron
 * @date 25/07/2017
 * @since 1.0.0
 */
public final class HelperLoader {

    public static void init(){
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };

        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(),true);
        }
    }
}
