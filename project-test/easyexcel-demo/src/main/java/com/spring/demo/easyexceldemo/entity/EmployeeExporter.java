package com.spring.demo.easyexceldemo.entity;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.spring.demo.easyexceldemo.converter.EducationConverter;
import com.spring.demo.easyexceldemo.converter.GenderConverter;
import com.spring.demo.easyexceldemo.converter.MaritalStatusConverter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("employee")
@ApiModel(value = "EmployeeExporter", description = "员工信息导出实体")
public class EmployeeExporter implements Serializable {

    @ApiModelProperty("主键")
    @ExcelIgnore
    private Long id;

    @ApiModelProperty("姓名")
    @TableField("user_name")
    @ColumnWidth(16)
    @ExcelProperty(value = "姓名", index = 0)
    private String userName;

    @ApiModelProperty("性别")
    @ColumnWidth(16)
    @ExcelProperty(value = "性别", index = 1, converter = GenderConverter.class)
    private String gender;

    @ApiModelProperty("年龄")
    @ColumnWidth(16)
    @ExcelProperty(value = "年龄", index = 2)
    private int age;

    @ApiModelProperty("生日")
    @ColumnWidth(28)
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @ExcelProperty("生日")
//    @ExcelProperty(value = "生日", index = 3, converter = DateDateConverter.class)
    private Date birthday;

    @ApiModelProperty("婚姻状况")
    @TableField("marital_status")
    @ColumnWidth(20)
    @ExcelProperty(value = "婚姻状况", index = 4, converter = MaritalStatusConverter.class)
    private String maritalStatus;

    @ApiModelProperty("学历")
    @ColumnWidth(18)
    @ExcelProperty(value = "学历", index = 5, converter = EducationConverter.class)
    private String education;

    @ApiModelProperty("血型")
    @TableField("blood_type")
    @ColumnWidth(18)
    @ExcelProperty(value = "血型", index = 6)
    private String bloodType;

    @ApiModelProperty("手机号码")
    @ColumnWidth(22)
    @ExcelProperty(value = "手机号码", index = 7)
    private String mobile;

    @ApiModelProperty("部门")
    @TableField("department_name")
    @ColumnWidth(20)
    @ExcelProperty(value = "部门", index = 8)
    private String departmentName;

    @ApiModelProperty("国家地区")
    @TableField("national_area")
    @ColumnWidth(20)
    @ExcelProperty(value = "国家地区", index = 9)
    private String nationalArea;

    @ApiModelProperty("省")
    @ColumnWidth(20)
    @ExcelProperty(value = "省", index = 10)
    private String province;

    @ApiModelProperty("市")
    @ColumnWidth(20)
    @ExcelProperty(value = "市", index = 11)
    private String city;

    @ApiModelProperty("身份证")
    @TableField("id_card_number")
    @ColumnWidth(24)
    @ExcelProperty(value = "身份证", index = 12)
    private String idCardNumber;

    @ApiModelProperty("个人邮箱")
    @TableField("personal_mail_box")
    @ColumnWidth(24)
    @ExcelProperty(value = "个人邮箱", index = 13)
    private String personalMailBox;

}
