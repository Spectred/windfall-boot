package com.spectred.creep.advice;

import com.spectred.creep.common.CommonResponse;
import com.spectred.creep.exception.BusinessException;
import com.spectred.creep.exception.TempException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 全局异常处理器
 * [注] 继承ResponseEntityExceptionHandler后,@Valid的验证信息不能正常返回,待修复
 * @author SWD
 */
@RestControllerAdvice(basePackages = {"com.spectred.creep.controller"})
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(BusinessException.class)
    public CommonResponse<Void> handleBusinessException(BusinessException be) {
        return CommonResponse.errorResult(be.getErrorCode(), be.getErrorMsg());
    }

    @ExceptionHandler(TempException.class)
    public CommonResponse<Void> handleTempException(TempException te) {
        return CommonResponse.errorResult(te.getErrorCode(), te.getErrorMsg());
    }


}
