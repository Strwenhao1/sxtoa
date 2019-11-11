package com.bjsxt.entity;

import java.io.Serializable;
import java.util.Date;

public class Expense implements Serializable {
    private Integer expid;
    private String empid;
    private Double totalamount;
    private Date exptime;
    private String expdesc;
    private String nextauditor;
    private String lastresult;
    private String realname;

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    //0 新建 1 审核中 2 审核通过 3 审核拒绝 4 审核打回 5 已报销
    private String status;

    @Override
    public String toString() {
        return "Expense{" +
                "expid=" + expid +
                ", empid='" + empid + '\'' +
                ", totalamount=" + totalamount +
                ", exptime=" + exptime +
                ", expdesc='" + expdesc + '\'' +
                ", nextauditor='" + nextauditor + '\'' +
                ", lastresult='" + lastresult + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Expense(Integer expid, String empid, Double totalamount, Date exptime, String expdesc, String nextauditor, String lastresult, String status) {
        this.expid = expid;
        this.empid = empid;
        this.totalamount = totalamount;
        this.exptime = exptime;
        this.expdesc = expdesc;
        this.nextauditor = nextauditor;
        this.lastresult = lastresult;
        this.status = status;
    }

    public Expense() {
    }

    public Integer getExpid() {
        return expid;
    }

    public void setExpid(Integer expid) {
        this.expid = expid;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public Double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
    }

    public Date getExptime() {
        return exptime;
    }

    public void setExptime(Date exptime) {
        this.exptime = exptime;
    }

    public String getExpdesc() {
        return expdesc;
    }

    public void setExpdesc(String expdesc) {
        this.expdesc = expdesc;
    }

    public String getNextauditor() {
        return nextauditor;
    }

    public void setNextauditor(String nextauditor) {
        this.nextauditor = nextauditor;
    }

    public String getLastresult() {
        return lastresult;
    }

    public void setLastresult(String lastresult) {
        this.lastresult = lastresult;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
