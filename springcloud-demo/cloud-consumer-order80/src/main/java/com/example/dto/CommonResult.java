//Json封装体CommentResult,传给前端，判断编码是否成功，成功才显示
package com.example.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author liulq
 */
@Data
@ToString
@Builder
public class CommonResult<T> {  //泛型：如果装的payment 返回payment,装的order 返回order

    private Integer code;
    private String message;
    @JsonIgnore
    private T data;

    public CommonResult() {
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
