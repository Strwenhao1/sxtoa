package com.bjsxt.service;

import com.bjsxt.entity.EcharsData;
import com.bjsxt.entity.Income;

import java.util.List;

public interface IncomeService {
    public int addIncome(Income income);

    public List<Income> findByCondition( String firsttime
            , String lasttime, String ictype);

    public List<EcharsData> findData();
}
