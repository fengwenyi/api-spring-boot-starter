# Spring Boot API Starter

## 快速开始

### 添加依赖

**Maven**

```xml
<dependency>
    <groupId>com.fengwenyi</groupId>
    <artifactId>api-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

**Gradle**

```groovy
implementation("com.fengwenyi:api-spring-boot-starter:1.0.0")
```

### 开启注解

> @EnableApiStarter


## 功能列表

- [x] [全局异常处理](wiki/global-exception-handler.md)
- [x] [异常](wiki/exception.md)
- [x] [自定义注解参数校验](wiki/constraints.md)

## 更新日志

### v1.0.0

2021.08.17

- 支持全局异常处理
- 异常列表
- 异常断言抛出
- 自定义注解参数校验：手机号校验(@Phone)，身份证号码校验(@IdCardNo)