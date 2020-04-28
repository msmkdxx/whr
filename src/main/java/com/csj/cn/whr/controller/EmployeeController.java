package com.csj.cn.whr.controller;

import com.csj.cn.whr.dto.Employee;
import com.csj.cn.whr.service.EmployeeService;
import com.csj.cn.whr.utils.ExcelUtils;
import com.csj.cn.whr.utils.PageUtils;
import com.csj.cn.whr.utils.ReturnResult;
import com.csj.cn.whr.utils.ReturnResultUtils;
import com.csj.cn.whr.vo.EmployeeVo;
import com.csj.cn.whr.vo.SearchVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/2710:40
 */
@Api(tags = "员工管理")
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "模糊查询员工列表")
    @GetMapping(value = "/selectEmployeeListByLike")
    public PageUtils<List<Employee>> selectEmployeeListByLike(@RequestParam(name = "searchStr", required = false, defaultValue = "") String searchStr,
                                                              @RequestParam(name = "pageNo", required = false, defaultValue = "1") int pageNo,
                                                              @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        PageUtils pageUtils = new PageUtils();
        pageUtils.setPageNo(pageNo);
        pageUtils.setCurrentPage(pageNo);
        pageUtils.setPageSize(pageSize);
        Map employeeListMap = employeeService.selectEmployeeList(searchStr, pageUtils.getPageNo(), pageSize);
        pageUtils.setCurrentList((List<Employee>) employeeListMap.get("currentList"));
        pageUtils.setTotalCount((Long) employeeListMap.get("totalCount"));
        return pageUtils;
    }

    @ApiOperation(value = "条件查询员工列表")
    @GetMapping(value = "/selectEmployeeListBy")
    public PageUtils<List<Employee>> selectEmployeeListBy(@RequestParam(name = "pageNo", required = false, defaultValue = "1") int pageNo,
                                                          @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
                                                          @Validated SearchVo searchVo) {
        PageUtils pageUtils = new PageUtils();
        pageUtils.setPageNo(pageNo);
        pageUtils.setCurrentPage(pageNo);
        pageUtils.setPageSize(pageSize);
        Map employeeListMap = employeeService.selectEmployeeList(pageUtils.getPageNo(), pageSize, searchVo);
        pageUtils.setCurrentList((List<Employee>) employeeListMap.get("currentList"));
        pageUtils.setTotalCount((Long) employeeListMap.get("totalCount"));
        return pageUtils;
    }

    @ApiOperation(value = "通过id查询员工信息")
    @GetMapping(value = "/selectEmployeeById")
    public Employee selectEmployeeById(@RequestParam Long id) {
        return employeeService.selectEmployeeById(id);
    }

    @ApiOperation(value = "添加员工信息")
    @GetMapping(value = "/insertEmployee")
    public ReturnResult insertEmployee(@Validated EmployeeVo employeeVo) {
        if (employeeService.insertEmployee(employeeVo)) return ReturnResultUtils.returnSucess();

        return ReturnResultUtils.returnFail(111, "添加失败了!!!");
    }

    @ApiOperation(value = "修改员工信息")
    @GetMapping(value = "/updateEmployee")
    public ReturnResult updateEmployee(@Validated EmployeeVo employeeVo) {
        if (employeeService.updateEmployee(employeeVo)) return ReturnResultUtils.returnSucess();

        return ReturnResultUtils.returnFail(112, "修改失败了!!!");
    }

    @ApiOperation(value = "删除员工")
    @GetMapping(value = "/delEmployees")
    public ReturnResult delEmployees(@RequestParam Long... ids) {
        if (employeeService.delEmployees(ids)) return ReturnResultUtils.returnSucess();

        return ReturnResultUtils.returnFail(113, "删除失败了!!!");
    }

    @ApiOperation(value = "导入Excel")
    @GetMapping(value = "/readExcel")
    public ReturnResult readExcel(String fileName) {
        InputStream fileInputStream = null;
        try {
            //读取user.xlsx表格，获得文件输入流
            fileInputStream = new FileInputStream(fileName);
            //获得实体类对象集合
            List<Employee> employees = (List<Employee>) ExcelUtils.readExcel(fileInputStream, EmployeeVo.class, 1);
            if (ObjectUtils.isEmpty(employees)) {
                return ReturnResultUtils.returnFail(121, "文件内容为空");
            }
            //批量插入到数据库user表中
            employeeService.insertEmployees(employees);
            return ReturnResultUtils.returnSucess();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关闭文件输入流，释放资源
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ReturnResultUtils.returnFail(122, "导入失败！！！");
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping(value = "/writeExcel")
    public ReturnResult writeExcel(String fileName) {
        FileOutputStream fileOutputStream = null;
        try {
            //获取文件输出流
            fileOutputStream = new FileOutputStream(fileName);
            //获得实体类对象集合
            List<Employee> employees = employeeService.selectEmployees();
            if (ObjectUtils.isEmpty(employees)) {
                return ReturnResultUtils.returnFail(124, "导出失败！！！");
            }
            //把数据写入到指定的Excel表格中
            ExcelUtils.writeExcel(fileOutputStream, EmployeeVo.class, employees);
            return ReturnResultUtils.returnSucess();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ReturnResultUtils.returnFail(124, "导出失败！！！");
    }
}
