package com.fengwenyi.apistarter.enums;

import com.fengwenyi.api.result.IReturnCode;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-09
 */
public enum ApiResult implements IReturnCode {

    PARAM_EXCEPTION("PARAM_EXCEPTION", "参数异常")
    , PARAM_ILLEGAL("PARAM_ILLEGAL", "参数非法")
    , PARAM_MISS("PARAM_MISS", "参数缺失")
    , PARAM_VALIDATED("PARAM_VALIDATED", "参数校验失败")

    , DATA_EXCEPTION("DATA_EXCEPTION", "数据异常")

    ;

    private final String code;

    private final String msg;

    ApiResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
