package com.spectred.creep.common;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

/**
 * @author SWD
 */
@Setter
@Getter
public class CommonResponse<T> {

    @JSONField(ordinal = 0)
    private String status;
    @JSONField(ordinal = 1)
    private String errorCode;
    @JSONField(ordinal = 2)
    private String errorMsg;
    @JSONField(ordinal = 3)
    private T resultBody;

    public CommonResponse() {
    }

    public CommonResponse(T resultBody) {
        this.status = "1";
        this.errorCode = null;
        this.errorMsg = null;
        this.resultBody = resultBody;
    }

    public static <T> CommonResponse<T> errorResult(String errorCode, String errorMsg) {
        CommonResponse<T> errorResult = new CommonResponse<>();
        errorResult.setStatus("-1");
        errorResult.setErrorCode(errorCode);
        errorResult.setErrorMsg(errorMsg);
        return errorResult;
    }


}
