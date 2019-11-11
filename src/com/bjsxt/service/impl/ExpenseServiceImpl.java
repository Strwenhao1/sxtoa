package com.bjsxt.service.impl;

import com.bjsxt.entity.Expense;
import com.bjsxt.entity.Expenseitem;
import com.bjsxt.mapper.ExpenseMapper;
import com.bjsxt.mapper.ExpenseitemMapper;
import com.bjsxt.service.ExpenseItemService;
import com.bjsxt.service.ExpenseService;
import com.bjsxt.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ExpenseServiceImpl implements ExpenseService {

    @Override
    public boolean addExpense(Expense expense, List<Expenseitem> items) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ExpenseMapper mapper = sqlSession.getMapper(ExpenseMapper.class);
        ExpenseitemMapper itemMapper = sqlSession.getMapper(ExpenseitemMapper.class);

        int i = mapper.addExpense(expense);
        for (Expenseitem item:items){
            item.setExpid(expense.getExpid());
            itemMapper.addItem(item);
        }
        sqlSession.commit();
        sqlSession.close();
        return i==1;
    }

    @Override
    public List<Expense> findAllExpense(String empid) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ExpenseMapper mapper = sqlSession.getMapper(ExpenseMapper.class);
        List<Expense> allExpense = mapper.findAllExpense(empid);

        return allExpense;
    }
}
