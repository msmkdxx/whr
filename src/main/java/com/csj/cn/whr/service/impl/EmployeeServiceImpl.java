package com.csj.cn.whr.service.impl;

import com.csj.cn.whr.dto.Employee;
import com.csj.cn.whr.dto.EmployeeExample;
import com.csj.cn.whr.mapper.EmployeeMapper;
import com.csj.cn.whr.service.EmployeeService;
import com.csj.cn.whr.vo.EmployeeVo;
import com.google.common.collect.Maps;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

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
        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
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
    public Map selectEmployeeList(int pageNo, int pageSize, Integer politicalId, Integer nationId, Integer departmentId, Integer positionId, Integer jobTitle, Integer employmentForm, Date from, Date to) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.setLimit(pageNo);
        employeeExample.setOffset(pageSize);
        if (politicalId != 0) {
            employeeExample.createCriteria().andPoliticalIdEqualTo(politicalId);
        } else if (nationId != 0) {
            employeeExample.createCriteria().andNationIdEqualTo(nationId);
        } else if (departmentId != 0) {
            employeeExample.createCriteria().andDepartmentIdEqualTo(departmentId);
        } else if (positionId != 0) {
            employeeExample.createCriteria().andPositionIdEqualTo(positionId);
        } else if (jobTitle != 0) {
            employeeExample.createCriteria().andJobTitleEqualTo(jobTitle);
        } else if (employmentForm != 0) {
            employeeExample.createCriteria().andEmploymentFormEqualTo(employmentForm);
        } else if (null != from && null != to) {
            employeeExample.createCriteria().andEntryDateBetween(from, to);
        }
        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
        long counts = employeeMapper.countByExample(employeeExample);
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
    public boolean delEmployeeById(Long id) {
        return employeeMapper.deleteByPrimaryKey(id) > 0;
    }

}
