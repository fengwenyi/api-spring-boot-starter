package com.fengwenyi.apistarter.enums;

import com.fengwenyi.api.result.IReturnCode;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-16
 */
public enum ReturnCode implements IReturnCode {

    // 系统异常
    ERROR("100001", "系统异常")

    // 参数相关异常
    , PARAM_MISS("101001", "参数缺失")
    , PARAM_VALIDATED("101002", "参数校验失败")
    , PARAM_EXCEPTION("101003", "参数异常")

    ;

    // 错误码
    private final String errCode;

    // 错误信息
    private final String msg;

    ReturnCode(String errCode, String msg) {
        this.errCode = errCode;
        this.msg = msg;
    }

    @Override
    public String getErrCode() {
        return errCode;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
