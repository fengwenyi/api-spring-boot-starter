package com.fengwenyi.apistarter.exception;

import com.fengwenyi.api.result.IReturnCode;
import lombok.Getter;
import lombok.Setter;

/**
 * API Exception
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-11
 */
@Getter
@Setter
public class BizException extends RuntimeException {

    private IReturnCode returnCode;

    public BizException() {
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(IReturnCode returnCode) {
        this.returnCode = returnCode;
    }

    public BizException(IReturnCode returnCode, String message) {
        super(message);
        this.returnCode = returnCode;
    }

    public BizException(IReturnCode returnCode, Throwable cause) {
        super(cause);
        this.returnCode = returnCode;
    }

    public BizException(IReturnCode returnCode, Throwable cause, String message) {
        super(message, cause);
        this.returnCode = returnCode;
    }
}

