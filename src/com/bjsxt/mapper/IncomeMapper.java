package com.bjsxt.mapper;

import com.bjsxt.entity.EcharsData;
import com.bjsxt.entity.Income;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IncomeMapper {
    public int addIncome(Income income);

    public List<Income> findByCondition(@Param("firsttime") String firsttime
            , @Param("lasttime") String lasttime, @Param("ictype") String ictype);

    public List<EcharsData> findData();


}

