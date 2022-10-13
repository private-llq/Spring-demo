package com.example.springimport.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "rf_service")
public class RfService extends DbPageParameter implements Serializable {
    /**
     * ID
     */
    @Id
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 分类：1-数据库、2-中间件
     */
    private Integer category;

    /**
     * 类型：1-Mysql、2-Oracle、3-SQL Server、4-CLickhouse、5-InfluxDB、6-PostgreSQL  、7-Redis、8-Kafak，
            9-Nginx、10-Zookeeper、11-Minio、12-kkFileView（在线文件预览服务）、13-seata（分布式事务服务）、14-配置总线
            
     */
    private Integer type;

    /**
     * 版本号
     */
    private String version;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 介绍
     */
    private String description;

    /**
     * Logo文件ID
     */
    @Column(name = "logo_file_id")
    private Long logoFileId;

    /**
     * 授权代码
     */
    @Column(name = "auth_code")
    private String authCode;

    /**
     * 发布时间
     */
    @Column(name = "release_time")
    private Date releaseTime;

    /**
     * 镜像ID
     */
    @Column(name = "image_id")
    private Long imageId;

    /**
     * 创建者ID
     */
    @Column(name = "creator_id")
    private Long creatorId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新者ID
     */
    @Column(name = "updator_id")
    private Long updatorId;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 标志：0-已删除、1-未删除
     */
    private Integer flag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取分类：1-数据库、2-中间件
     *
     * @return category - 分类：1-数据库、2-中间件
     */
    public Integer getCategory() {
        return category;
    }

    /**
     * 设置分类：1-数据库、2-中间件
     *
     * @param category 分类：1-数据库、2-中间件
     */
    public void setCategory(Integer category) {
        this.category = category;
    }

    /**
     * 获取类型：1-Mysql、2-Oracle、3-SQL Server、4-CLickhouse、5-InfluxDB、6-PostgreSQL  、7-Redis、8-Kafak，
            9-Nginx、10-Zookeeper、11-Minio、12-kkFileView（在线文件预览服务）、13-seata（分布式事务服务）、14-配置总线
            
     *
     * @return type - 类型：1-Mysql、2-Oracle、3-SQL Server、4-CLickhouse、5-InfluxDB、6-PostgreSQL  、7-Redis、8-Kafak，
            9-Nginx、10-Zookeeper、11-Minio、12-kkFileView（在线文件预览服务）、13-seata（分布式事务服务）、14-配置总线
            
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型：1-Mysql、2-Oracle、3-SQL Server、4-CLickhouse、5-InfluxDB、6-PostgreSQL  、7-Redis、8-Kafak，
            9-Nginx、10-Zookeeper、11-Minio、12-kkFileView（在线文件预览服务）、13-seata（分布式事务服务）、14-配置总线
            
     *
     * @param type 类型：1-Mysql、2-Oracle、3-SQL Server、4-CLickhouse、5-InfluxDB、6-PostgreSQL  、7-Redis、8-Kafak，
            9-Nginx、10-Zookeeper、11-Minio、12-kkFileView（在线文件预览服务）、13-seata（分布式事务服务）、14-配置总线
            
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取版本号
     *
     * @return version - 版本号
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取简介
     *
     * @return introduction - 简介
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 设置简介
     *
     * @param introduction 简介
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * 获取介绍
     *
     * @return description - 介绍
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置介绍
     *
     * @param description 介绍
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取Logo文件ID
     *
     * @return logo_file_id - Logo文件ID
     */
    public Long getLogoFileId() {
        return logoFileId;
    }

    /**
     * 设置Logo文件ID
     *
     * @param logoFileId Logo文件ID
     */
    public void setLogoFileId(Long logoFileId) {
        this.logoFileId = logoFileId;
    }

    /**
     * 获取授权代码
     *
     * @return auth_code - 授权代码
     */
    public String getAuthCode() {
        return authCode;
    }

    /**
     * 设置授权代码
     *
     * @param authCode 授权代码
     */
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    /**
     * 获取发布时间
     *
     * @return release_time - 发布时间
     */
    public Date getReleaseTime() {
        return releaseTime;
    }

    /**
     * 设置发布时间
     *
     * @param releaseTime 发布时间
     */
    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**
     * 获取镜像ID
     *
     * @return image_id - 镜像ID
     */
    public Long getImageId() {
        return imageId;
    }

    /**
     * 设置镜像ID
     *
     * @param imageId 镜像ID
     */
    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    /**
     * 获取创建者ID
     *
     * @return creator_id - 创建者ID
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建者ID
     *
     * @param creatorId 创建者ID
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新者ID
     *
     * @return updator_id - 更新者ID
     */
    public Long getUpdatorId() {
        return updatorId;
    }

    /**
     * 设置更新者ID
     *
     * @param updatorId 更新者ID
     */
    public void setUpdatorId(Long updatorId) {
        this.updatorId = updatorId;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取标志：0-已删除、1-未删除
     *
     * @return flag - 标志：0-已删除、1-未删除
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * 设置标志：0-已删除、1-未删除
     *
     * @param flag 标志：0-已删除、1-未删除
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", category=").append(category);
        sb.append(", type=").append(type);
        sb.append(", version=").append(version);
        sb.append(", introduction=").append(introduction);
        sb.append(", description=").append(description);
        sb.append(", logoFileId=").append(logoFileId);
        sb.append(", authCode=").append(authCode);
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", imageId=").append(imageId);
        sb.append(", creatorId=").append(creatorId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updatorId=").append(updatorId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", flag=").append(flag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}