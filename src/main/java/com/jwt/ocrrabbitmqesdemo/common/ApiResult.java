package com.jwt.ocrrabbitmqesdemo.common;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ApiResult {

    private String code;
    private String message;
    private Object data;

    public ApiResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ApiResult valueOf(Object data) {
        return new ApiResult("0000","success",data);
    }

    public static Object errorOf(ErrorCode errorCode, String message) {
        return new ApiResult(errorCode.getCode(),errorCode.getMsg(),message);
    }
}
