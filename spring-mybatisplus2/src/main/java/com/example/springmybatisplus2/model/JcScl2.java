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
 * 水处理二
 * </p>
 *
 * @author llq
 * @since 2023-12-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class JcScl2 implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 星期
     */
    private String xq;

    /**
     * 天气
     */
    private String tq;

    /**
     * 回流污泥量
     */
    private String hlwnl;

    /**
     * 剩余污泥量
     */
    private String sywnl;

    /**
     * 值班记录
     */
    private String zbjl;

    /**
     * 值班记录2
     */
    private String zbjl2;

    /**
     * 值班记录3
     */
    private String zbjl3;

    /**
     * 早班人员
     */
    private String zabjl;

    /**
     * 晚班人员
     */
    private String wbjl;

    /**
     * 中班人员
     */
    private String zhbjl;

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
