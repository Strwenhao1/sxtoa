package com.bjsxt.service.impl;

import com.bjsxt.entity.Expenseitem;
import com.bjsxt.mapper.ExpenseitemMapper;
import com.bjsxt.service.ExpenseItemService;
import com.bjsxt.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ExpenseItemServiceImpl implements ExpenseItemService {
    @Override
    public boolean addItem(Expenseitem expenseitem) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ExpenseitemMapper mapper = sqlSession.getMapper(ExpenseitemMapper.class);
        int i = mapper.addItem(expenseitem);
        sqlSession.commit();
        sqlSession.close();
        return i==1;
    }

    @Override
    public List<Expenseitem> findByExpid(String expid) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ExpenseitemMapper mapper = sqlSession.getMapper(ExpenseitemMapper.class);
        List<Expenseitem> byExpid = mapper.findByExpid(expid);
        sqlSession.commit();
        sqlSession.close();
        return byExpid;
    }
}
