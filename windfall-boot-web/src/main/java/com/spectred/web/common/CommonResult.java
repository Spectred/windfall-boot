package com.spectred.web.common;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author SWD
 */
@Data
@Accessors(chain = true)
public final class CommonResult<T> {

    private int status = 1;

    private String errorCode = "";

    private String errorMsg = "";

    private T resultBody;

    public CommonResult() {
    }

    public CommonResult(T resultBody) {
        this.resultBody = resultBody;
    }


    public static <T> CommonResult<T> errorResult(String errorCode, String errorMsg){
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.errorCode = errorCode;
        commonResult.errorMsg = errorMsg;
        commonResult.status = -1;
        return commonResult;
    }
}
