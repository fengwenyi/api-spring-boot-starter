# 常用工具类

## Asserts: 断言

| 方法 | 描述 |
| --- | --- |
| fail(msg) | 失败 |
| fail(returnCode) | 失败 |
| fail(returnCode, msg) | 失败 |
| notBlank(str, msg) | 断言字符串不为空，为空将抛出 ApiException 异常 |
| notNull(obj, msg) | 断言对象不为空，为空将抛出 ApiException 异常 |
| notEmpty(collect, msg) | 断言对象不为空，为空将抛出 ApiException 异常 |