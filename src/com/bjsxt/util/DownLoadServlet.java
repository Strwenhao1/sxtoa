package com.bjsxt.util;

import com.bjsxt.entity.Duty;
import com.bjsxt.service.DutyService;
import com.bjsxt.service.impl.DutyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@WebServlet("/downLoadServlet")
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String pi = req.getParameter("pi");
        String[] split = pi.split(",");
        int tag = 1;
        DutyService dutyService = new DutyServiceImpl();
        List<Duty> duties = new ArrayList<>();

        String mgrid = "";
        String dtdate = "";
        for (String i : split) {
            if (tag == 1) {
                mgrid = i;
            }
            if (tag == 2) {
                dtdate = i;
                tag = 0;
                System.out.println(mgrid + "\t" + dtdate);
                List<Duty> condition = dutyService.findCondition(mgrid, "", dtdate);
                duties.add(condition.get(0));
            }
            tag++;
        }
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(date));
        File file = new File("d:/" + sdf.format(date)+".txt");
        PrintWriter pw = new PrintWriter(file);
        pw.println("员工编号" + "\t"
                + "员工姓名" + "\t"
                + "签到日期"+ "\t\t"
                + "签到时间" + "\t"
                + "签退时间" + "\t");
        for (Duty duty : duties) {

            pw.println(duty.getEmprid() + "\t"
                    + duty.getRealname() + "\t"
                    + sdf.format(duty.getDtdate())+ "\t"
                    + duty.getSignintime() + "\t"
                    + duty.getSignouttime() + "\t");
        }
        pw.flush();
        pw.close();


        resp.getWriter().write("d:/" + sdf.format(date)+".txt");
//        System.out.println(duties);
//        System.out.println(pi);
//

//        dutyService.findCondition()
    }
}
