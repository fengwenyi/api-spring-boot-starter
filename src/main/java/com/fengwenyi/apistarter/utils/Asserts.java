package com.fengwenyi.apistarter.utils;

import com.fengwenyi.api.result.Result;
import com.fengwenyi.apistarter.exception.ApiException;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Objects;

/**
 * 断言
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-03
 */
public class Asserts {

    /**
     * 失败
     * @param msg 描述
     */
    public static void fail(String msg) {
        throw new ApiException(msg);
    }

    /**
     * 失败
     * @param result {@link Result}
     */
    public static void fail(Result result) {
        throw new ApiException(result);
    }

    /**
     * 失败
     * @param result {@link Result}
     * @param msg 描述
     */
    public static void fail(Result result, String msg) {
        throw new ApiException(result, msg);
    }

    /**
     * 断言字符串不为空，为空将抛出 {@link ApiException} 异常
     * @param str 待判断的字符串
     * @param msg 为空提示信息
     */
    public static void notBlank(String str, String msg) {
        if (!StringUtils.hasText(str)) {
            fail(msg);
        }
    }

    /**
     * 断言对象不为空，为空将抛出 {@link ApiException} 异常
     * @param obj 待判断的对象
     * @param msg 为空提示信息
     */
    public static void notNull(Object obj, String msg) {
        if (Objects.isNull(obj)) {
            fail(msg);
        }
    }


    /**
     * 断言集合不为空，为空将抛出 {@link ApiException} 异常
     * @param collection 待判断的集合
     * @param msg 为空提示信息
     */
    public static void notEmpty(Collection<?> collection, String msg) {
        if (CollectionUtils.isEmpty(collection)) {
            fail(msg);
        }
    }
}
