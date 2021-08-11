package com.fengwenyi.apistarter.utils;


import com.fengwenyi.api.result.IReturnCode;
import com.fengwenyi.apistarter.exception.ApiException;

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
     * @param returnCode {@link IReturnCode}
     */
    public static void fail(IReturnCode returnCode) {
        throw new ApiException(returnCode);
    }

    /**
     * 失败
     * @param returnCode {@link IReturnCode}
     * @param msg 描述
     */
    public static void fail(IReturnCode returnCode, String msg) {
        throw new ApiException(returnCode, msg);
    }

}
