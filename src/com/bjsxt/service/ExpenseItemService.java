package com.bjsxt.service;

import com.bjsxt.entity.Expense;
import com.bjsxt.entity.Expenseitem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExpenseItemService {
    public boolean addItem(Expenseitem expenseitem);

    public List<Expenseitem> findByExpid(String expid);


}
