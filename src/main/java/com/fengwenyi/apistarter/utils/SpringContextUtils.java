package com.fengwenyi.apistarter.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Objects;

/**
 *
 * ApplicationContext 工具类
 *
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 1.0.1
 */
public class SpringContextUtils implements ApplicationContextAware {

    // ApplicationContext
    public static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * 获取 ApplicationContext
     * @return ApplicationContext
     */
    public static ApplicationContext getContext() {
        if (Objects.isNull(context)) {
            Asserts.fail("无法获取ApplicationContext");
        }
        return context;
    }
}
