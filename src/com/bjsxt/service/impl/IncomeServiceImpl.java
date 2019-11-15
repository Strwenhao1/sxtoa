package com.bjsxt.service.impl;

import com.bjsxt.entity.EcharsData;
import com.bjsxt.entity.Income;
import com.bjsxt.mapper.IncomeMapper;
import com.bjsxt.service.IncomeService;
import com.bjsxt.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class IncomeServiceImpl implements IncomeService {


    @Override
    public int addIncome(Income income) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        IncomeMapper mapper = sqlSession.getMapper(IncomeMapper.class);
        int i = mapper.addIncome(income);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public List<Income> findByCondition(String firsttime, String lasttime, String ictype) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        IncomeMapper mapper = sqlSession.getMapper(IncomeMapper.class);
        List<Income> byCondition = mapper.findByCondition(firsttime, lasttime, ictype);
        return byCondition;
    }

    @Override
    public List<EcharsData> findData() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        IncomeMapper mapper = sqlSession.getMapper(IncomeMapper.class);
        List<EcharsData> datas = mapper.findData();

        return datas;
    }
}
