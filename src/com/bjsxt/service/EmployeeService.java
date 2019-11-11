package com.bjsxt.service;

import com.bjsxt.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public int addEmp(Employee employee);

    public List<Employee> findAllEmp( String empid,String deptno
            , String onduty,String hiredate);

    public int updateEmp(Employee employee);

    public int deleteEmp(String empId);

    public int countEmp();

    public Employee login(String empid,String password);

    public List<Employee> findAllMgrs();


}
