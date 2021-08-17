package com.fengwenyi.apistarter;


import com.fengwenyi.apistarter.config.ApiAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 入口
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-16
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ApiAutoConfiguration.class})
public @interface EnableApiStarter {


}
