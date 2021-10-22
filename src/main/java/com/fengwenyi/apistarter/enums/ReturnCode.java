package com.fengwenyi.apistarter.enums;

import com.fengwenyi.api.result.IReturnCode;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-16
 */
public enum ReturnCode implements IReturnCode {

    // 参数相关异常
    PARAM_MISS(101001, "参数缺失")
    , PARAM_VALIDATED(101002, "参数校验失败")

    ;

    // 错误码
    private final int code;

    // 错误信息
    private final String message;

    ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
