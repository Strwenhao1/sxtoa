package com.bjsxt.service.impl;

import com.bjsxt.entity.Employee;
import com.bjsxt.mapper.EmployeeMapper;
import com.bjsxt.service.EmployeeService;
import com.bjsxt.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public int addEmp(Employee employee) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        int i = mapper.addEmp(employee);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public List<Employee> findAllEmp(String empid, String deptno, String onduty, String hiredate) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> emps = mapper.findAllEmp(empid, deptno, onduty, hiredate);
        sqlSession.close();
        return emps;
    }

    @Override
    public int updateEmp(Employee employee) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        int i = mapper.updateEmp(employee);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public int deleteEmp(String empId) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        int i = mapper.deleteEmp(empId);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public int countEmp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        int i = mapper.countEmp();
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public Employee login(String empid, String password) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee loginEmp = mapper.login(empid, password);

        return loginEmp;
    }

    @Override
    public List<Employee> findAllMgrs() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> allMgrs = mapper.findAllMgrs();

        return allMgrs;
    }


}
