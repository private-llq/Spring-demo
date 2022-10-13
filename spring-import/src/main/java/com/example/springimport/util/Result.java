//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.springimport.util;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Result<T> {
    private String serviceCode;
    private String methodCode;
    private int statusCode;
    private String message;
    private String errorStackTrace;
    @Expose(
        serialize = false,
        deserialize = false
    )
    private boolean isSuccess;
    private T data;

    public Result(String serviceCode, String methodCode, int statusCode, T data) {
        this.statusCode = StatusCode.SUCCESS;
        this.isSuccess = false;
        this.setServiceCode(serviceCode);
        this.setMethodCode(methodCode);
        this.setStatusCode(statusCode);
        this.setData(data);
        this.isSuccess();
    }

    public Result(String serviceCode, String methodCode, int statusCode) {
        this(serviceCode, methodCode, statusCode, (T) null);
    }

    public Result(String serviceCode, String methodCode, T data) {
        this(serviceCode, methodCode, StatusCode.SUCCESS, data);
    }

    public Result(String serviceCode, String methodCode) {
        this(serviceCode, methodCode, StatusCode.SUCCESS, (T) null);
    }

    public Result(T data) {
        this("common", "return", StatusCode.SUCCESS, data);
    }

    public Result() {
        this("common", "return", StatusCode.SUCCESS, (T) null);
    }

    public Result(int statusCode) {
        this("common", "return", statusCode, (T) null);
    }

    public Result(int statusCode, String message) {
        this.statusCode = StatusCode.SUCCESS;
        this.isSuccess = false;
        this.setStatusCode(statusCode);
        this.setMessage(message);
    }

    public Result(int statusCode, String message, T data) {
        this.statusCode = StatusCode.SUCCESS;
        this.isSuccess = false;
        this.setStatusCode(statusCode);
        this.setMessage(message);
        this.setData(data);
    }

    public Result(String message) {
        this(StatusCode.SUCCESS, message);
    }

    public Result(int statusCode, T data) {
        this("common", "return", statusCode, data);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @JsonIgnore
    public boolean isSuccess() {
        this.isSuccess = this.getStatusCode() == StatusCode.SUCCESS;
        return this.isSuccess;
    }

    public boolean hasData() {
        return this.getData() != null;
    }

    @JsonIgnore
    public String getServiceCode() {
        return this.serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    @JsonIgnore
    public String getMethodCode() {
        return this.methodCode;
    }

    public void setMethodCode(String methodCode) {
        this.methodCode = methodCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorStackTrace() {
        return this.errorStackTrace;
    }

    public void setErrorStackTrace(String errorStackTrace) {
        this.errorStackTrace = errorStackTrace;
    }

    public static Result success() {
        return success((Object)null);
    }

    public static <T> Result<T> success(T data) {
        return new Result(StatusCode.SUCCESS, "操作成功！", data);
    }
}
