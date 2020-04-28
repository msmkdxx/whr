package com.csj.cn.whr.service.impl;

import com.csj.cn.whr.dto.Employee;
import com.csj.cn.whr.dto.EmployeeExample;
import com.csj.cn.whr.mapper.EmployeeMapper;
import com.csj.cn.whr.service.EmployeeService;
import com.csj.cn.whr.vo.EmployeeVo;
import com.csj.cn.whr.vo.SearchVo;
import com.google.common.collect.Maps;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/2710:33
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> selectEmployees() {
        EmployeeExample employeeExample = new EmployeeExample();
        List<Employee> employeeList = employeeMapper.selectByExample(null);
        return employeeList;
    }

    @Override
    public Map selectEmployeeList(String searchStr, int pageNo, int pageSize) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.setLimit(pageNo);
        employeeExample.setOffset(pageSize);
        if (!StringUtils.isEmpty(searchStr)) {
            employeeExample.createCriteria().andNameLike("%" + searchStr + "%");
        }
        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
        long counts = employeeMapper.countByExample(employeeExample);
        Map<String, Object> employeeListMap = Maps.newHashMap();
        employeeListMap.put("currentList", employeeList);
        employeeListMap.put("totalCount", counts);
        return employeeListMap;
    }

    @Override
    public Map selectEmployeeList(int pageNo, int pageSize, SearchVo searchVo) {
        List<Employee> employeeList = employeeMapper.selectBySearch(pageNo, pageSize, searchVo);
        long counts = employeeMapper.selectCountBySearch(searchVo);
//        long counts = employeeMapper.countByExample(employeeExample);
        Map<String, Object> employeeListMap = Maps.newHashMap();
        employeeListMap.put("currentList", employeeList);
        employeeListMap.put("totalCount", counts);
        return employeeListMap;
    }

    @Override
    public Employee selectEmployeeById(Long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean insertEmployee(EmployeeVo employeeVo) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeVo, employee);
        return employeeMapper.insertSelective(employee) > 0;
    }

    @Override
    public boolean insertEmployees(List<Employee> employees) {
        return employeeMapper.insertEmployees(employees) == employees.size();
    }

    @Override
    public boolean updateEmployee(EmployeeVo employeeVo) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeVo, employee);
        return employeeMapper.updateByPrimaryKeySelective(employee) > 0;
    }

    @Override
    public boolean delEmployees(Long... ids) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andIdIn(Arrays.asList(ids));
        return employeeMapper.deleteByExample(employeeExample) > 0;
    }

}
