package com.bjsxt.service.impl;

import com.bjsxt.entity.Auditing;
import com.bjsxt.entity.Employee;
import com.bjsxt.entity.Expense;
import com.bjsxt.mapper.AuditingMapper;
import com.bjsxt.mapper.EmployeeMapper;
import com.bjsxt.mapper.ExpenseMapper;
import com.bjsxt.service.AuditingService;
import com.bjsxt.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class AuditingServiceImpl implements AuditingService {

    @Override
    public int addAuditing(Auditing auditing) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        AuditingMapper amapper = sqlSession.getMapper(AuditingMapper.class);
        EmployeeMapper emapper = sqlSession.getMapper(EmployeeMapper.class);
        ExpenseMapper esmapper = sqlSession.getMapper(ExpenseMapper.class);

        Expense expense = esmapper.findExpeseByExpid(auditing.getExpid());
        if (expense.getStatus().equals("5")) {
            return 0;
        }
        if (auditing.getResult().equals("2")) {
            Double totalamount = expense.getTotalamount();
            if (totalamount > 2000) {
                Employee employee = emapper.findAllEmp(auditing.getEmpid(), "", "", "").get(0);
                if (employee.getMgrId() != null) {
                    expense.setNextauditor(employee.getMgrId());
                    expense.setStatus("1");
//                    expense.setLastresult("审核中");

                } else {
                    expense.setStatus("5");

                }
            } else {
                expense.setStatus("5");
//                expense.setLastresult("已报销");
            }

        } else {
            expense.setStatus(auditing.getResult());
        }

        expense.setLastresult(auditing.getAuditdesc());
        int i = amapper.addAuditing(auditing);
        int i1 = esmapper.updateExpenseStatus(expense);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public List<Auditing> selectAuditing(Integer expid) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        AuditingMapper mapper = sqlSession.getMapper(AuditingMapper.class);
        List<Auditing> auditings = mapper.selectAuditing(expid);
        sqlSession.commit();
        sqlSession.close();
        return auditings;
    }

//    @Override
//    public List<Auditing> selectAuditingByEmpid(String empid) {
//        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
//        AuditingMapper mapper = sqlSession.getMapper(AuditingMapper.class);
//        List<Auditing> auditings = mapper.selectAuditingByEmpid(empid);
//
//        return auditings;
//    }

    @Override
    public List<Expense> selectAuditingByEmpid(String empid) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        AuditingMapper mapper = sqlSession.getMapper(AuditingMapper.class);
        List<Expense> auditings = mapper.selectAuditingByEmpid(empid);

        return auditings;
    }
}
