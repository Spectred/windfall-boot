package com.spectred.web.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusinessException extends RuntimeException {

    private String errorCode;

    private String errorMsg;
}
