package com.fengwenyi.apistarter.handler;

import com.fengwenyi.api.result.IReturnCode;
import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.apistarter.enums.ReturnCode;
import com.fengwenyi.apistarter.exception.ApiException;
import com.fengwenyi.apistarter.exception.ParamException;
import com.fengwenyi.javalib.util.MdcUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultTemplate<Void> missingServletRequestParameterExceptionHandler(HttpServletRequest request, MissingServletRequestParameterException e) {
        log.error("MissingServletRequestParameterException, uri:{}", request.getRequestURI());
        log.error("msg={}", e.getParameterName());
        MdcUtils.clear();
        return ResultTemplate.fail(ReturnCode.PARAM_MISS, "参数缺失异常: [" + e.getParameterName() + "]");
    }

    // 参数校验失败异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultTemplate<Void> handleParamCheckException(HttpServletRequest request, MethodArgumentNotValidException e) {
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
        MdcUtils.clear();
        return ResultTemplate.fail(ReturnCode.PARAM_VALIDATED, "参数检验失败: " + errMsgJoiner);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultTemplate<Void> constraintViolationExceptionHandler(HttpServletRequest request, ConstraintViolationException e) {
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
        MdcUtils.clear();
        return ResultTemplate.fail(ReturnCode.PARAM_VALIDATED, "参数校验失败: " + errMsgJoiner);
    }

    // 参数异常
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ParamException.class)
    public ResultTemplate<Void> paramExceptionHandler(HttpServletRequest request, ParamException e) {
        log.error("ParamException, uri:{}", request.getRequestURI());
        log.error("msg={}", e.getMessage());
        MdcUtils.clear();
        return ResultTemplate.fail(ReturnCode.PARAM_EXCEPTION, "参数异常：" + e.getMessage());
    }

    // API通用异常
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ApiException.class)
    public ResultTemplate<Void> apiExceptionHandler(HttpServletRequest request, ApiException e) {
        log.error("ApiException, uri:{}", request.getRequestURI());
        IReturnCode returnCode = e.getReturnCode();
        String message = e.getMessage();
        if (Objects.isNull(returnCode)) {
            log.error("msg={}", message);
            return ResultTemplate.fail(message);
        }
        if (StringUtils.hasText(message)) {
            log.error("errCode={}, msg={}", returnCode.getErrCode(), message);
            return ResultTemplate.fail(returnCode, message);
        }
        log.error("errCode={}, msg={}", returnCode.getErrCode(), returnCode.getMsg());
        MdcUtils.clear();
        return ResultTemplate.fail(returnCode);
    }

    // 系统异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultTemplate<Void> exceptionHandler(HttpServletRequest request, Exception e) {
        log.error("Exception, uri:{}", request.getRequestURI(), e);
        MdcUtils.clear();
        return ResultTemplate.fail(ReturnCode.ERROR);
    }

}
