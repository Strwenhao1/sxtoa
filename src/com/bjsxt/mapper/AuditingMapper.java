package com.bjsxt.mapper;

import com.bjsxt.entity.Auditing;
import com.bjsxt.entity.Expense;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuditingMapper {
    public int addAuditing(Auditing auditing);

    public List<Auditing> selectAuditing(@Param("expid") Integer expid);

//    public List<Auditing> selectAuditingByEmpid(@Param("empid") String empid);

public List<Expense> selectAuditingByEmpid(@Param("empid") String empid);


    public List<List<String>> select(@Param("empid") String empid);
}
