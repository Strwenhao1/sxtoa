package com.bjsxt.entity;

public class EcharsData {
    String amount;
    String ictype;

    public String getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "EcharsData{" +
                "amount='" + amount + '\'' +
                ", ictype='" + ictype + '\'' +
                '}';
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getIctype() {
        return ictype;
    }

    public void setIctype(String ictype) {
        this.ictype = ictype;
    }

    public EcharsData() {
    }

    public EcharsData(String amount, String ictype) {
        this.amount = amount;
        this.ictype = ictype;
    }
}
