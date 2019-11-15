package com.bjsxt.entity;

import java.util.Date;

public class Income {
    private Integer icid;
    private Integer amount;
    private Date icdate;
    private String ictype;
    private String indesc;
    private String userid;

    private String realname;

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }


    public Income() {
    }

    @Override
    public String toString() {
        return "Income{" +
                "icid=" + icid +
                ", amount=" + amount +
                ", icdate=" + icdate +
                ", ictype='" + ictype + '\'' +
                ", indesc='" + indesc + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }

    public Income(Integer amount, Date icdate, String ictype, String indesc, String userid) {
        this.amount = amount;
        this.icdate = icdate;
        this.ictype = ictype;
        this.indesc = indesc;
        this.userid = userid;
    }

    public Integer getIcid() {
        return icid;
    }

    public void setIcid(Integer icid) {
        this.icid = icid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getIcdate() {
        return icdate;
    }

    public void setIcdate(Date icdate) {
        this.icdate = icdate;
    }

    public String getIctype() {
        return ictype;
    }

    public void setIctype(String ictype) {
        this.ictype = ictype;
    }

    public String getIndesc() {
        return indesc;
    }

    public void setIndesc(String indesc) {
        this.indesc = indesc;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
