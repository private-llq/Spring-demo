package com.spring.demo.easyexceldemo.vo;

import lombok.Data;

@Data
public class ResultVo<T> {
    private static final String SUCCESS_CODE = "S10000";
    private static final String UNKNOWN_FAIL_CODE = "E10001";

    private T data;
    private String code;
    private String message;
    private boolean success;

    public ResultVo() {
    }

    public ResultVo(boolean success, String code) {
        this.success = success;
        this.code = code;
    }

    public ResultVo(T data, boolean success, String code, String message) {
        this.data = data;
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public static ResultVo<Void> success() {
        return success(null, (String)null);
    }

    public static <R> ResultVo<R> success(R data) {
        return success(data, (String)null);
    }

    public static <R> ResultVo<R> success(R data, String message) {
        return new ResultVo(data, true, SUCCESS_CODE, message);
    }

    public static ResultVo<Void> successMsg(String message) {
        return success(null, message);
    }

    public static <R> ResultVo<R> failure(String code) {
        return failure(code, (String)null);
    }

    public static <R> ResultVo<R> failure(String code, String message) {
        return failure(null, code, message);
    }

    public static <R> ResultVo<R> failure(R data, String code, String message) {
        return new ResultVo(data, false, code, message);
    }

    public static <R> ResultVo<R> failureMsg(String message) {
        return failure(UNKNOWN_FAIL_CODE, message);
    }
}
