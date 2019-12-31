package com.spectred.creep.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 业务异常
 *
 * @author SWD
 */
@Data
@AllArgsConstructor
public class BusinessException extends RuntimeException {

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;
}
