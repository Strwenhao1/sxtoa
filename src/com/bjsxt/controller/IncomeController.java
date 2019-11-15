package com.bjsxt.controller;

import com.bjsxt.entity.Dept;
import com.bjsxt.entity.EcharsData;
import com.bjsxt.entity.Employee;
import com.bjsxt.entity.Income;
import com.bjsxt.service.DeptService;
import com.bjsxt.service.IncomeService;
import com.bjsxt.service.impl.DeptServiceImpl;
import com.bjsxt.service.impl.IncomeServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/incomeController")
public class IncomeController extends BaseController {
    IncomeService incomeService = new IncomeServiceImpl();
    DeptService deptService = new DeptServiceImpl();

    protected void addIncome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer amount = Integer.parseInt(req.getParameter("amount"));
        String icdate = req.getParameter("icdate");
        String ictype = req.getParameter("ictype");
        String indesc = req.getParameter("indesc");
        String empid = ((Employee) req.getSession().getAttribute("employee")).getEmpId();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(icdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Income income = new Income(amount, parse, ictype, indesc, empid);
        int i = incomeService.addIncome(income);
        System.out.println(i);

    }

    protected void findAllDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> depts = deptService.findAll();
        req.setAttribute("depts", depts);
        req.getRequestDispatcher("incomeAdd.jsp").forward(req, resp);
    }


    protected void findByCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firsttime = req.getParameter("firsttime");
        String lasttime = req.getParameter("lasttime");
        String ictype = req.getParameter("ictype");

        List<Income> incomes = incomeService.findByCondition(firsttime, lasttime, ictype);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String s = gson.toJson(incomes);
        resp.getWriter().write(s);

    }


    protected void findData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<EcharsData> data = incomeService.findData();
        Gson gson = new Gson();
        String s = gson.toJson(data);
        System.out.println(s);
        resp.getWriter().write(s);
    }
}
