package com.fengwenyi.apistarter.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * ApplicationContext
 *
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 1.0.1
 */
public class SpringContextUtils implements ApplicationContextAware {

    public static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
