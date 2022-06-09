package com.fengwenyi.apistarter.handler;

import com.fengwenyi.api.result.IReturnCode;
import com.fengwenyi.api.result.ResponseTemplate;
import com.fengwenyi.apistarter.enums.ApiResult;
import com.fengwenyi.apistarter.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-11
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 参数缺失异常
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseTemplate<Void> missingServletRequestParameterExceptionHandler(HttpServletRequest request, MissingServletRequestParameterException e) {
        log.error("MissingServletRequestParameterException, uri:{}", request.getRequestURI());
        log.error("msg={}", e.getParameterName());
        return ResponseTemplate.fail(ApiResult.PARAM_MISS, "参数缺失异常: [" + e.getParameterName() + "]");
    }

    // 参数校验失败异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseTemplate<Void> handleParamCheckException(HttpServletRequest request, MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException, uri:{}", request.getRequestURI());
        BindingResult bindingResult = e.getBindingResult();
        StringJoiner errMsgJoiner = new StringJoiner(",", "[", "]");
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                String msg = objectError.getDefaultMessage();
                if (StringUtils.hasText(msg)) {
                    errMsgJoiner.add(msg);
                }
            }
        }
        log.error("msg={}", errMsgJoiner);
        return ResponseTemplate.fail(ApiResult.PARAM_VALIDATED, "参数检验失败: " + errMsgJoiner);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseTemplate<Void> constraintViolationExceptionHandler(HttpServletRequest request, ConstraintViolationException e) {
        log.error("ConstraintViolationException, uri:{}", request.getRequestURI());
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        StringJoiner errMsgJoiner = new StringJoiner(",", "[", "]");
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            String errMsg = constraintViolation.getMessageTemplate();
            if (StringUtils.hasText(errMsg)) {
                errMsgJoiner.add(errMsg);
            }
        }
        log.error("msg={}", errMsgJoiner);
        return ResponseTemplate.fail(ApiResult.PARAM_VALIDATED, "参数校验失败: " + errMsgJoiner);
    }

    /**
     * Api Exception
     * @param request 请求
     * @param e {@link ApiException}
     * @return 异常信息
     */
    @ExceptionHandler(ApiException.class)
    public ResponseTemplate<Void> apiExceptionHandler(HttpServletRequest request, ApiException e) {
        log.info("ApiException, uri:{}", request.getRequestURI());
        IReturnCode returnCode = e.getReturnCode();
        String message = e.getMessage();
        if (Objects.isNull(returnCode)) {
            log.error("msg={}", message);
            return ResponseTemplate.fail(message);
        }
        if (StringUtils.hasText(message)) {
            log.error("code={}, message={}", returnCode.getCode(), message);
            return ResponseTemplate.fail(returnCode, message);
        }
        log.error("code={}, message={}", returnCode.getCode(), returnCode.getMessage());
        return ResponseTemplate.fail(returnCode);
    }

    // 系统异常
    @ExceptionHandler(Exception.class)
    public ResponseTemplate<Void> exceptionHandler(HttpServletRequest request, Exception e) {
        log.error("Exception, uri:{}", request.getRequestURI(), e);
        return ResponseTemplate.fail();
    }

}
