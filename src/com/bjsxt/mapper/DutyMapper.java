package com.bjsxt.mapper;

import com.bjsxt.entity.Duty;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DutyMapper {
    public int addDuty(Duty duty);

    public Duty findTodyDUty(@Param("emprid")String emprid, @Param("dtdate")Date dtdate);

    public int updateDuty(Duty duty);

    public List<Duty> selectAllDuty();

    public List<Duty> findCondition(@Param("emprid") String emprid
            ,@Param("deptno") String deptno,@Param("dtdate") String dtdate);

}
