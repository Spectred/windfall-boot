package com.spectred.web.config;

import com.spectred.web.common.BusinessException;
import com.spectred.web.common.CommonResult;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author SWD
 */
@EnableWebMvc
@Configuration
public class UnifiedReturnConfig {

    @RestControllerAdvice(value = {"com.spectred.web.controller"})
    static class CommonResultResponseAdvice implements ResponseBodyAdvice<Object> {

        @Override
        public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
            return true;
        }

        @Override
        public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
            return o instanceof CommonResult ? o : new CommonResult<>(o);
        }
    }

    @RestControllerAdvice("com.spectred.web.controller")
    static class UnifiedExceptionHandler{

        @ExceptionHandler(BusinessException.class)
        public CommonResult<Void> handleBusinessException(BusinessException be){
            return CommonResult.errorResult(be.getErrorCode(), be.getErrorMsg());
        }
    }
}
