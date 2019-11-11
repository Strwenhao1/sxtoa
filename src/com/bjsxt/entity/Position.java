package com.bjsxt.entity;

public class Position {
    private Integer posid;
    private String pname;

    @Override
    public String toString() {
        return "Position{" +
                "posid=" + posid +
                ", pname='" + pname + '\'' +
                ", pdesc='" + pdesc + '\'' +
                '}';
    }

    private String pdesc;

    public Position() {
    }

    public Position(Integer posid, String pname, String pdesc) {
        this.posid = posid;
        this.pname = pname;
        this.pdesc = pdesc;
    }


    public Integer getPosid() {
        return posid;
    }

    public void setPosid(Integer posid) {
        this.posid = posid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }
}

