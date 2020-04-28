package com.csj.cn.whr.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/288:46
 */
@Data
public class SearchVo implements Serializable {
    @ApiModelProperty(value = "民族")
    private Integer nationId;
    @ApiModelProperty(value = "政治面貌")
    private Integer politicalId;
    @ApiModelProperty(value = "所属部门")
    private Integer departmentId;
    @ApiModelProperty(value = "职位")
    private Integer positionId;
    @ApiModelProperty(value = "职称")
    private Integer jobTitle;
    @ApiModelProperty(value = "聘用形式")
    private Integer employmentForm;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date from;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date to;
}
