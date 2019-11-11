package com.bjsxt.service;

import com.bjsxt.entity.Dept;

import java.util.List;

public interface DeptService {
    public int insert(Dept dept);

    public List<Dept> findAll();

    public int deleteByDeptno(int deptno);

    public Dept findByDeptno( int deptno);

    public int updateDept(Dept dept);

    public int countDept();

}
