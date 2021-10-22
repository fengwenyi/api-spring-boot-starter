package com.fengwenyi.apistarter.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

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
        Asserts.notNull(context, "获取ApplicationContext失败");
        return context;
    }

    /**
     * 根据bean名称获取bean对象
     * @param beanName bean名称
     * @return bean对象
     */
    public static Object getBean(String beanName) {
        return getContext().getBean(beanName);
    }
}
