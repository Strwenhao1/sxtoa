package com.bjsxt.mapper;

import com.bjsxt.entity.Expenseitem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExpenseitemMapper {
    public int addItem(Expenseitem expenseitem);

    public List<Expenseitem> findByExpid(@Param("expid") String expid);

}
