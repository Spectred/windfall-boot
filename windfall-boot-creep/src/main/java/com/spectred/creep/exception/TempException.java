package com.spectred.creep.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author SWD
 */
@Data
@AllArgsConstructor
public class TempException extends RuntimeException {

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;


}
