package com.bjsxt.mapper;

import com.bjsxt.entity.Expense;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExpenseMapper {
    public int addExpense(Expense expense);

    public List<Expense> findAllExpense(@Param("empid") String empid);


}
