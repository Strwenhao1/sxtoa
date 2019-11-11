package com.bjsxt.service.impl;

import com.bjsxt.entity.Duty;
import com.bjsxt.mapper.DutyMapper;
import com.bjsxt.service.DutyService;
import com.bjsxt.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class DutyServiceImpl implements DutyService {
    @Override
    public int addDuty(Duty duty) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DutyMapper mapper = sqlSession.getMapper(DutyMapper.class);
        int i = mapper.addDuty(duty);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public Duty findTodyDUty(String emprid, Date dtdate) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DutyMapper mapper = sqlSession.getMapper(DutyMapper.class);
        Duty duty = mapper.findTodyDUty(emprid, dtdate);
        sqlSession.commit();
        sqlSession.close();
        return duty;
    }

    @Override
    public int updateDuty(Duty duty) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DutyMapper mapper = sqlSession.getMapper(DutyMapper.class);
        int i = mapper.updateDuty(duty);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public List<Duty> selectAllDuty() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DutyMapper mapper = sqlSession.getMapper(DutyMapper.class);
        List<Duty> duties = mapper.selectAllDuty();
        return duties;
    }

    @Override
    public List<Duty> findCondition(String emprid, String deptno, String dtdate) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DutyMapper mapper = sqlSession.getMapper(DutyMapper.class);
        List<Duty> duties = mapper.findCondition(emprid, deptno, dtdate);

        return duties;
    }
}
