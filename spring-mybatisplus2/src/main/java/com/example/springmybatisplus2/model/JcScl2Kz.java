package com.example.springmybatisplus2.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 水处理二扩展表
 * </p>
 *
 * @author llq
 * @since 2023-12-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class JcScl2Kz implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 字典项
     */
    private String itemId;

    /**
     * 1#机
     */
    private String onej;

    /**
     * 2#机
     */
    private String twoj;

    /**
     * 3#机
     */
    private String threej;

    /**
     * 4#机
     */
    private String fourj;

    /**
     * 5#机
     */
    private String fivej;

    /**
     * 6#机
     */
    private String sixj;

    /**
     * 7#机
     */
    private String sevenj;

    /**
     * 8#机
     */
    private String eightj;

    /**
     * 1#机y
     */
    private String onejy;

    /**
     * 2#机y
     */
    private String twojy;

    /**
     * 3#机y
     */
    private String threejy;

    /**
     * 4#机h
     */
    private String fourjh;

    /**
     * 5#机y
     */
    private String fivejy;

    /**
     * 6#机y
     */
    private String sixjy;

    /**
     * 7#机y
     */
    private String sevenjy;

    /**
     * 8#机h
     */
    private String eightjh;

    /**
     * 1#机a
     */
    private String oneja;

    /**
     * 2#机a
     */
    private String twoja;

    /**
     * 3#机b
     */
    private String treejb;

    /**
     * 4#机b
     */
    private String fourjb;

    /**
     * 1#机w
     */
    private String onejw;

    /**
     * 2#机w
     */
    private String twojw;

    /**
     * 3#机w
     */
    private String threejw;

    /**
     * 任务id
     */
    private String taskId;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 项目ID
     */
    private Integer projectId;

    /**
     * 分析时间
     */
    private String analysisTime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 逻辑删除标志
     */
    private Integer flag;


}
