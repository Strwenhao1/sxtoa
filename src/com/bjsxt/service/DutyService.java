package com.bjsxt.service;

import com.bjsxt.entity.Duty;

import java.util.Date;
import java.util.List;

public interface DutyService {
    public int addDuty(Duty duty);

    public Duty findTodyDUty(String emprid, Date dtdate);

    public int updateDuty(Duty duty);

    public List<Duty> selectAllDuty();

    public List<Duty> findCondition( String emprid
            , String deptno, String dtdate);


}
