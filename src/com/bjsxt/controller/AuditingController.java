package com.bjsxt.controller;

import com.bjsxt.entity.Auditing;
import com.bjsxt.entity.Employee;
import com.bjsxt.service.AuditingService;
import com.bjsxt.service.impl.AuditingServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/auditingController")
public class AuditingController extends BaseController {
    AuditingService auditingService = new AuditingServiceImpl();
    protected void addAuditing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer expid = Integer.parseInt(req.getParameter("expid"));
        String empid = ((Employee)req.getSession().getAttribute("employee")).getEmpId();
        String result = req.getParameter("result");
        String auditdesc = req.getParameter("auditdesc");

        Auditing auditing = new Auditing(null,expid,empid,result,auditdesc,new Date());

        int i = auditingService.addAuditing(auditing);
        resp.getWriter().print(i);
    }

    protected void selectAuditing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer expid = Integer.parseInt(req.getParameter("expid"));
        System.out.println(expid);
        List<Auditing> auditings = auditingService.selectAuditing(expid);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String s = gson.toJson(auditings);
        resp.getWriter().write(s);

    }
}
