package com.example.springmybatisplus2.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author llq
 * @since 2023-12-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class M3 implements Serializable {

    private static final long serialVersionUID=1L;

    private String name;


}
