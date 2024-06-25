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
 * 水处理三扩展表
 * </p>
 *
 * @author llq
 * @since 2023-12-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class JcScl3Kz implements Serializable {

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
     * 
A池预脱硝区
     */
    private String acytxq;

    /**
     * B池预脱硝区
     */
    private String bcytxu;

    /**
     * A池厌氧区
     */
    private String acyyq;

    /**
     * 
B池厌氧区
     */
    private String bcyyq;

    /**
     * A池缺氧区
     */
    private String acqyq;

    /**
     * B池缺氧区
     */
    private String bcqyq;

    /**
     * A池预脱硝区3
     */
    private String acytxq3;

    /**
     * B池预脱硝区3
     */
    private String bcytxq3;

    /**
     * A池好氧区2
     */
    private String achyq2;

    /**
     * B池好氧区1
     */
    private String bchyq1;

    /**
     * A池预脱硝区3
     */
    private String achyq3;

    /**
     * B池预脱硝区3
     */
    private String bchyq3;

    /**
     * A池好氧区
     */
    private String bcytxq;

    /**
     * B池好氧区
     */
    private String achyq;

    /**
     * A池预脱硝区
     */
    private String bchyq;

    /**
     * B池预脱硝区2
     */
    private String acytxq2;

    /**
     * A池好氧区2
     */
    private String bcytxq2;

    /**
     * B池好氧区2
     */
    private String bchyq2;

    /**
     * A池好氧区
     */
    private String achyl;

    /**
     * B池好氧区
     */
    private String bchyl;

    /**
     * A池
     */
    private String ac;

    /**
     * B池
     */
    private String bc;

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
