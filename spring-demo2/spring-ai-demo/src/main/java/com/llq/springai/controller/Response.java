package com.llq.springai.controller;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    /**
     * 响应码
     */
    private String code;
    /**
     * 响应信息
     */
    private String msg;
    /**
     * 响应数据
     */
    private Object data;
 
}