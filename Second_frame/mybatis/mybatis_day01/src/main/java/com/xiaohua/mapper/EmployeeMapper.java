package com.xiaohua.mapper;

import com.xiaohua.entity.Employee;

import java.util.List;

public interface EmployeeMapper {

    List<Employee> select(Employee employee);

    List<Employee> select2(Employee employee);
    List<Employee> selectByDid(Employee employee);
}
