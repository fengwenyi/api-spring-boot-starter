package com.fengwenyi.apistarter.config;

import com.fengwenyi.apistarter.EnableApiStarter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-16
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = EnableApiStarter.class)
public class ApiAutoConfiguration {
}
