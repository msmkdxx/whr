package com.csj.cn.whr.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/2711:00
 */
@Data
public class EmployeeVo extends BaseRowModel implements Serializable {
    private static final long serialVersionUID = 2753134683927931738L;

    private Long id;

    @ExcelProperty(value = "员工姓名",index = 0)
    @ApiModelProperty(value = "员工姓名")
    private String name;

    @ExcelProperty(value = "工号",index = 1)
    @ApiModelProperty(value = "工号")
    private Long jobNumber;

    @ExcelProperty(value = "性别",index = 2)
    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ExcelProperty(value = "出生日期",index = 3)
    @ApiModelProperty(value = "出生日期")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @ExcelProperty(value = "身份证号码",index = 4)
    @ApiModelProperty(value = "身份证号码")
    private String identity;

    @ExcelProperty(value = "婚姻状况",index = 5)
    @ApiModelProperty(value = "婚姻状况")
    private Integer isMarried;

    @ExcelProperty(value = "民族",index = 6)
    @ApiModelProperty(value = "民族")
    private Integer nationId;

    @ExcelProperty(value = "籍贯",index = 7)
    @ApiModelProperty(value = "籍贯")
    private String hometown;

    @ExcelProperty(value = "政治面貌",index = 8)
    @ApiModelProperty(value = "政治面貌")
    private Integer politicalId;

    @ExcelProperty(value = "邮箱",index = 9)
    @ApiModelProperty(value = "邮箱")
    private String email;

    @ExcelProperty(value = "手机号",index = 10)
    @ApiModelProperty(value = "手机号")
    private String phone;

    @ExcelProperty(value = "地址",index = 11)
    @ApiModelProperty(value = "地址")
    private String address;

    @ExcelProperty(value = "所属部门",index = 12)
    @ApiModelProperty(value = "所属部门")
    private Integer departmentId;

    @ExcelProperty(value = "职位",index = 13)
    @ApiModelProperty(value = "职位")
    private Integer positionId;

    @ExcelProperty(value = "职称",index = 14)
    @ApiModelProperty(value = "职称")
    private Integer jobTitle;

    @ExcelProperty(value = "聘用形式",index = 15)
    @ApiModelProperty(value = "聘用形式")
    private Integer employmentForm;

    @ExcelProperty(value = "入职日期",index = 16)
    @ApiModelProperty(value = "入职日期")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entryDate;
}
