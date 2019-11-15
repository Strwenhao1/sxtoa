package com.bjsxt.controller;

import com.bjsxt.entity.Employee;
import com.bjsxt.entity.Expense;
import com.bjsxt.entity.Expenseitem;
import com.bjsxt.service.EmployeeService;
import com.bjsxt.service.ExpenseItemService;
import com.bjsxt.service.ExpenseService;
import com.bjsxt.service.impl.EmployeeServiceImpl;
import com.bjsxt.service.impl.ExpenseItemServiceImpl;
import com.bjsxt.service.impl.ExpenseServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@WebServlet("/expenseController")
public class ExpenseController extends BaseController {
    EmployeeService employeeService = new EmployeeServiceImpl();
    ExpenseService expenseService = new ExpenseServiceImpl();
    ExpenseItemService expenseItemService = new ExpenseItemServiceImpl();

    protected void findMgr(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> mgrs = employeeService.findAllMgrs();
        Gson gson = new Gson();
        String s = gson.toJson(mgrs);
        resp.getWriter().write(s);
    }

    protected void addExpense(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Expense expense = new Expense();
//        System.out.println(req.getSession().getAttribute("employee"));
        String empId = ((Employee) req.getSession().getAttribute("employee")).getEmpId();
        System.out.println("empId:" + empId);
        /*设置报销人员*/
        expense.setEmpid(empId);
        /*设置报销审批人*/
        String nextauditor = req.getParameter("nextauditor");
        System.out.println("nextauditor:" + nextauditor);

        expense.setNextauditor(nextauditor);
        /*设置报销时间*/
        expense.setExptime(new Date());
        String expdesc = req.getParameter("expdesc");
        System.out.println("expdesc:" + expdesc);

        /*设置报销简介*/
        expense.setExpdesc(expdesc);
        /*设置报销订单状态*/
        expense.setStatus("0");
        expense.setLastresult("未审核");
        String[] types = req.getParameterValues("type");
        String[] amounts = req.getParameterValues("amount");
        String[] itemdescs = req.getParameterValues("itemdesc");
        Double totalAmount = Double.valueOf(req.getParameter("totalAmount"));
        List<Expenseitem> items = new ArrayList<>();
        for (int i = 0; i < types.length; i++) {
            Expenseitem ei = new Expenseitem();

            double amount = Double.parseDouble(amounts[i]);
            ei.setAmount(amount);
            ei.setType(types[i]);
            ei.setItemdesc(itemdescs[i]);
            items.add(ei);
        }
        expense.setTotalamount(totalAmount);
        System.out.println("expense:" + expense);
        expenseService.addExpense(expense, items);

        System.out.println("items:" + items);

//        resp.sendRedirect("myExpense.html");

    }

    protected void findAllExpense(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empid = ((Employee) req.getSession().getAttribute("employee")).getEmpId();

        List<Expense> expenses = expenseService.findAllExpense("");
        List<Expense> exp = new ArrayList<>();
        for (Expense esp : expenses){
            if (esp.getNextauditor().equals(empid)&&!esp.getStatus().equals("5")){
                System.out.println("esp.getStatus().equals(5):"+!esp.getStatus().equals("5"));
                exp.add(esp);
            }
        }

        GsonBuilder builder = new GsonBuilder().setDateFormat("yyyy-MM-dd");
        Gson gson = builder.create();
        String s = gson.toJson(exp);
        resp.getWriter().write(s);
//        System.out.println(allExpense);
    }

    protected void findByCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String expid = req.getParameter("expid");
        List<Expenseitem> expenses = expenseItemService.findByExpid(expid);
        req.setAttribute("expenses", expenses);
        req.getRequestDispatcher("expenseDetail.jsp").forward(req, resp);
    }

    protected void findMyExpense(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empid = ((Employee) req.getSession().getAttribute("employee")).getEmpId();
//        System.out.println("empid:"+empid);
        List<Expense> expenses = expenseService.findAllExpense(empid);
        System.out.println(expenses);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//        Gson gson = new Gson();
        String s = gson.toJson(expenses);
        resp.getWriter().write(s);
    }


}