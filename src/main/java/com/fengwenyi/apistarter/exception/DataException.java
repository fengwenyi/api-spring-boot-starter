package com.fengwenyi.apistarter.exception;

import com.fengwenyi.apistarter.enums.ApiResult;

/**
 * 数据异常
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-05-16
 */
public class DataException extends ApiException{

    private static final long serialVersionUID = 6295269745786031689L;

    public DataException() {
    }

    public DataException(String message) {
        super(message);
        this.setReturnCode(ApiResult.DATA_EXCEPTION);
    }
}
