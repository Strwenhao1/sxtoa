package com.bjsxt.Test;

import com.bjsxt.entity.Dept;
import com.bjsxt.entity.Duty;
import com.bjsxt.entity.Expenseitem;
import com.bjsxt.service.DutyService;
import com.bjsxt.service.impl.DutyServiceImpl;
import com.bjsxt.service.impl.ExpenseItemServiceImpl;
import com.bjsxt.util.SqlSessionUtil;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class test {
    public static void main(String[] args) throws ParseException {
        DutyService dutyService = new DutyServiceImpl();
      /*  SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Duty duty = new Duty("asd",new Date(),sdf.format(new Date()),sdf.format(new Date()));*/
//        dutyService.addDuty(duty);
//        System.out.println(new Date().toLocaleString());
//        Date d = sdf.format(new Date());
//        System.out.println();

//        Date d= sdf.parse("2019-11-09");
//        System.out.println(new Date("2019-11-09"));
//        String format = sdf.format(d);


     /*   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = simpleDateFormat.format(new Date());
        Date date = null;
        try {
            date = simpleDateFormat.parse(sDate);
            System.out.println(date);
        } catch (ParseException e) {

        }
        Duty asd = dutyService.findTodyDUty("asd", date);
        System.out.println(asd==null);*/
//        Date currentDate = new Date()
//        java.sql.Date date = new java.sql.Date(currentDate.getTime());
//        sdf


//        List<Duty> condition = dutyService.findCondition("asd", "", "");
//        System.out.println(condition);

//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
////        String s = date.toLocaleString();
//        System.out.println(sdf.format(date));

        ExpenseItemServiceImpl service = new ExpenseItemServiceImpl();
        List<Expenseitem> byExpid = service.findByExpid(3 + "");
        System.out.println(byExpid);


    }
}

