package com.bjsxt.mapper;

import com.bjsxt.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    public int addEmp(Employee employee);

    public List<Employee> findAllEmp(@Param("empid") String empid, @Param("deptno")String deptno
            , @Param("onduty")String onduty, @Param("hiredate")String hiredate);

    public int updateEmp(Employee employee);

    public int deleteEmp(@Param("empId")String empId);

    public int countEmp();

    public Employee login(@Param("empid") String empid,@Param("password")String password);

    public List<Employee> findAllMgrs();
}
