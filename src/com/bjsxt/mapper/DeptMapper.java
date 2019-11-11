package com.bjsxt.mapper;

import com.bjsxt.entity.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
    public int insert(Dept dept);

    public List<Dept> findAll();

    public int deleteByDeptno(@Param("deptno") int deptno);

    public Dept findByDeptno(@Param("deptno") int deptno);

    public int updateDept(Dept dept);

    public int countDept();
}
