package com.spring.demo.easyexceldemo.entity;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("employee")
@ApiModel(value = "EmployeeExporter", description = "员工信息导出实体")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1974561117197209738L;
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("姓名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("年龄")
    private int age;

    @ApiModelProperty("生日")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
//    @ExcelProperty(value = "生日", index = 3, converter = DateDateConverter.class)
    private Date birthday;

    @ApiModelProperty("婚姻状况")
    @TableField("marital_status")

    private String maritalStatus;

    @ApiModelProperty("学历")

    private String education;

    @ApiModelProperty("血型")
    @TableField("blood_type")
    private String bloodType;

    @ApiModelProperty("手机号码")
    private String mobile;

    @ApiModelProperty("部门")
    @TableField("department_name")
    private String departmentName;

    @ApiModelProperty("国家地区")
    @TableField("national_area")
    private String nationalArea;

    @ApiModelProperty("省")
    private String province;

    @ApiModelProperty("市")
    private String city;

    @ApiModelProperty("身份证")
    @TableField("id_card_number")
    private String idCardNumber;

    @ApiModelProperty("个人邮箱")
    @TableField("personal_mail_box")
    private String personalMailBox;

}
