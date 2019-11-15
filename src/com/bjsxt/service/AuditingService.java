package com.bjsxt.service;

import com.bjsxt.entity.Auditing;
import com.bjsxt.entity.Expense;

import java.util.List;

public interface AuditingService {
    public int addAuditing(Auditing auditing);

    public List<Auditing> selectAuditing(Integer expid);

//    public List<Auditing> selectAuditingByEmpid(String empid);

    public List<Expense> selectAuditingByEmpid(String empid);


}
