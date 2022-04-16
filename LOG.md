# 更新日志

## v1.2.1

2022.04.16


## v1.2.0

2022.04.09 ~ 2022.04.16

- 【新增】启用状态常量 com.fengwenyi.apistarter.constant.EnabledState
- 【新增】删除状态常量 com.fengwenyi.apistarter.constant.DeletedState
- 【变更】BaseBizEntity 逻辑删除字段改为 deletedState
- 【升级】api-result -> 2.6.0
- 【删除】弃用状态枚举 com.fengwenyi.apistarter.enums.EnabledState
- 【删除】删除状态枚举 com.fengwenyi.apistarter.enums.DeleteState


## v1.1.1

2021.11.24 ~ 2022.04.09

- 【变更】jdk -> 1.8。
- 【升级】spring boot -> 2.6.6。
- 【升级】api-result -> 2.5.3。


## v1.1.0

2021.10.11

- 【新增】新增删除状态枚举 `DeleteState`。
- 【新增】新增启用状态枚举 `EnabledState`。
- 【新增】SpringContextUtils类，新增getBean(beanName)。
- 【变更】全局异常处理，apiException异常HTTP状态码为200。
- 【变更】业务基础类，releaseStatus -> enableState。
- 【变更】业务基础类，deleteStatus -> deleteState。
- 【变更】全局异常处理，默认错误响应码。
- 【优化】完善注释。
- 【升级】api-result -> 2.5.1。
- 【升级】spring boot -> 2.5.6。

## v1.0.1

2021.09.15

- 【新增】ApplicationContext工具类：SpringContextUtils
- 【新增】断言Asserts：新增断言集合不为空方法 notEmpty(collect, msg)
- 【升级】JavaLib 2.1.3 -> 2.1.4
- 【升级】api-result 2.4.0 -> 2.4.2



## v1.0.0

2021.08.17

- 支持全局异常处理
- 异常列表
- 异常断言抛出
- 自定义注解参数校验：手机号校验(@Phone)，身份证号码校验(@IdCardNo)