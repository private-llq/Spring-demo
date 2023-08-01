package com.example.doamin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package com.example.doamin
 * @date 2023/8/1 20:47
 * @description: 公司
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Payment implements Serializable {
    private Long id;
    private String serial;

}