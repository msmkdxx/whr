package com.csj.cn.whr.service;

import com.csj.cn.whr.dto.Employee;
import com.csj.cn.whr.vo.EmployeeVo;
import com.csj.cn.whr.vo.SearchVo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    /**
     * 查询所有员工
     *
     * @return
     */
    List<Employee> selectEmployees();

    /**
     * 查询员工列表
     *
     * @param searchStr
     * @param pageNo
     * @param pageSize
     * @return
     */
    Map selectEmployeeList(String searchStr, int pageNo, int pageSize);

    /**
     * 查询员工列表
     *
     * @param pageNo
     * @param pageSize
     * @param searchVo
     * @return
     */
    Map selectEmployeeList(int pageNo, int pageSize, SearchVo searchVo);

    /**
     * 通过id查询员工信息
     *
     * @param id
     * @return
     */
    Employee selectEmployeeById(Long id);

    /**
     * 添加员工信息
     *
     * @param employeeVo
     * @return
     */
    boolean insertEmployee(EmployeeVo employeeVo);

    boolean insertEmployees(List<Employee> employees);

    /**
     * 修改员工信息
     *
     * @param employeeVo
     * @return
     */
    boolean updateEmployee(EmployeeVo employeeVo);

    /**
     * 删除员工
     *
     * @param ids
     * @return
     */
    boolean delEmployees(Long... ids);

}
