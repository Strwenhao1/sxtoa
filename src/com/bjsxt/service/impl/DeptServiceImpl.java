package com.bjsxt.service.impl;

import com.bjsxt.entity.Dept;
import com.bjsxt.mapper.DeptMapper;
import com.bjsxt.service.DeptService;
import com.bjsxt.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    @Override
    public int insert(Dept dept) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        int insert = mapper.insert(dept);
        sqlSession.commit();
        sqlSession.close();
        return insert;
    }

    @Override
    public List<Dept> findAll() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> depts  = mapper.findAll();

        sqlSession.close();
        return depts;
    }

    @Override
    public int deleteByDeptno(int deptno) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        int delete = mapper.deleteByDeptno(deptno);
        sqlSession.commit();
        sqlSession.close();
        return delete;
    }

    @Override
    public Dept findByDeptno(int deptno) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.findByDeptno(deptno);
        sqlSession.close();
        return dept;
    }

    @Override
    public int updateDept(Dept dept) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        int update = mapper.updateDept(dept);
        sqlSession.commit();
        sqlSession.close();
        return update;
    }

    @Override
    public int countDept() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        int i = mapper.countDept();
        sqlSession.commit();
        sqlSession.close();
        System.out.println(i);
        return i;
    }


}
