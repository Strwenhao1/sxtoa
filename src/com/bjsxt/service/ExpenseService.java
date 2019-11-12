package com.bjsxt.service;

import com.bjsxt.entity.Expense;
import com.bjsxt.entity.Expenseitem;

import java.util.List;

public interface ExpenseService {
    public boolean addExpense(Expense expense, List<Expenseitem> items);

    public List<Expense> findAllExpense(String empid);

    public Expense findExpeseByExpid(Integer expid);

}
