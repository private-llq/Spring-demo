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
 * 水处理三
 * </p>
 *
 * @author llq
 * @since 2023-12-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class JcScl3 implements Serializable {

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
    private String hlwll;

    /**
     * 运行记录1
     */
    private String yxjl1;

    /**
     * 运行记录2
     */
    private String yxjl2;

    /**
     * 运行记录3
     */
    private String yxjl3;

    /**
     * 早班人员
     */
    private String zbry;

    /**
     * 晚班人员
     */
    private String wbry;

    /**
     * 中班人员
     */
    private String zhbry;

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
