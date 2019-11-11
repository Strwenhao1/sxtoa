package com.bjsxt.controller;

import com.bjsxt.entity.Dept;
import com.bjsxt.entity.Employee;
import com.bjsxt.entity.Position;
import com.bjsxt.service.DeptService;
import com.bjsxt.service.EmployeeService;
import com.bjsxt.service.PositionService;
import com.bjsxt.service.impl.DeptServiceImpl;
import com.bjsxt.service.impl.EmployeeServiceImpl;
import com.bjsxt.service.impl.PositionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

@WebServlet("/employeeController")
public class EmployeeController extends BaseController {
    private EmployeeService empService = new EmployeeServiceImpl();
    private DeptService deptService = new DeptServiceImpl();
    private PositionService positionService = new PositionServiceImpl();


    protected void findCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> emps = empService.findAllEmp("", "", "1", "");
        List<Dept> depts = deptService.findAll();
        List<Position> positions = positionService.findAll();

        req.setAttribute("depts", depts);
        req.setAttribute("positions", positions);
        req.setAttribute("emps", emps);
        req.getRequestDispatcher("empAdd.jsp").forward(req, resp);

    }



    protected void addEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empId = req.getParameter("empId");
        String password = req.getParameter("password");
        Integer deptno = Integer.parseInt(req.getParameter("deptno"));
        Integer posid = Integer.parseInt(req.getParameter("posid"));
        String mgrid = req.getParameter("mgrid");
        String realName = req.getParameter("realName");
        String sex = req.getParameter("sex");
        java.sql.Date birthDate = java.sql.Date.valueOf(req.getParameter("birthDate"));
        java.sql.Date hireDate = java.sql.Date.valueOf(req.getParameter("hireDate"));
        java.sql.Date leaveDate = java.sql.Date.valueOf(req.getParameter("leaveDate"));
        Integer onDuty = Integer.parseInt(req.getParameter("onDuty"));
        Integer empType = Integer.parseInt(req.getParameter("empType"));
        String phone = req.getParameter("phone");
        String qq = req.getParameter("qq");
        String emerContactPerson = req.getParameter("emerContactPerson");
        String idCard = req.getParameter("idCard");


        Employee emp = new Employee(empId, password, deptno, posid, mgrid, realName, sex, birthDate, hireDate, leaveDate
                , onDuty, empType, phone, qq, emerContactPerson, idCard);


        int i = empService.addEmp(emp);
        resp.sendRedirect("employeeController?method=findAllEmp");


    }

    protected void findAllEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empid = req.getParameter("empid");
        String deptno = req.getParameter("deptno");
        System.out.println(deptno);
        String onduty = req.getParameter("onduty");
        String hiredate = req.getParameter("hiredate");
        List<Dept> depts = deptService.findAll();
        req.setAttribute("depts", depts);
        List<Employee> emps = empService.findAllEmp(empid, deptno, onduty, hiredate);
        HttpSession session = req.getSession();

        req.setAttribute("emps", emps);
        req.getRequestDispatcher("empList.jsp").forward(req, resp);

    }

    protected void findByEmpid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empid = req.getParameter("empid");
        String target = req.getParameter("target");
        List<Employee> emps = empService.findAllEmp(empid, "", "", "");
        Employee emp = emps.get(0);
        req.setAttribute("emp", emp);
        emps = empService.findAllEmp("", "", "", "");
        req.setAttribute("emps", emps);
        //当访问的页面是empUpdate.jsp时  到数据查找部门和岗位
        if (target.equals("empUpdate.jsp")){
            List<Dept> depts = deptService.findAll();
            List<Position> positions = positionService.findAll();
            req.setAttribute("depts", depts);
            req.setAttribute("positions", positions);
        }

        req.getRequestDispatcher(target).forward(req, resp);
    }
//    empUpdate.html
    protected void updateEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empId = req.getParameter("empId");
        String password = req.getParameter("password");
        Integer deptno = Integer.parseInt(req.getParameter("deptno"));
        Integer posid = Integer.parseInt(req.getParameter("posid"));
        String mgrid = req.getParameter("mgrId");
        String realName = req.getParameter("realName");
        String sex = req.getParameter("sex");
        java.sql.Date birthDate = java.sql.Date.valueOf(req.getParameter("birthDate"));
        java.sql.Date hireDate = java.sql.Date.valueOf(req.getParameter("hireDate"));
        java.sql.Date leaveDate = java.sql.Date.valueOf(req.getParameter("leaveDate"));
        Integer onDuty = Integer.parseInt(req.getParameter("onDuty"));
        Integer empType = Integer.parseInt(req.getParameter("empType"));
        String phone = req.getParameter("phone");
        String qq = req.getParameter("qq");
        String emerContactPerson = req.getParameter("emerContactPerson");
        String idCard = req.getParameter("idCard");


        Employee emp = new Employee(empId, password, deptno, posid, mgrid, realName, sex, birthDate, hireDate, leaveDate
                , onDuty, empType, phone, qq, emerContactPerson, idCard);

        System.out.println(emp);
        int i = empService.updateEmp(emp);

        resp.sendRedirect("employeeController?method=findAllEmp");

    }


    protected void deleteEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empId = req.getParameter("empId");
        int i = empService.deleteEmp(empId);

        resp.sendRedirect("employeeController?method=findAllEmp");

    }

    protected void countEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String i = new String(String.valueOf(empService.countEmp()));


        System.out.println(i);
        resp.getWriter().write(empService.countEmp()+"");
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getRequestURL());
        String empid = req.getParameter("empid");
        String password = req.getParameter("password");
        System.out.println(empid+"\t"+password);
        Employee loginEmp = empService.login(empid, password);
        System.out.println(loginEmp);
        HttpSession session = req.getSession();

        if (loginEmp!=null){
            session.setAttribute("employee", loginEmp);
            resp.sendRedirect("main.html");
            return;
        }
        session.setAttribute("msg", "登陆失败");
        resp.sendRedirect("login.jsp");


    }


    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath()+"/login.jsp");
    }

    protected void loginCheck(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String yzm = req.getParameter("yzm");
        if(!yzm.equals(req.getSession().getAttribute("randStr"))){
            req.getSession().setAttribute("msg", "验证码错误");
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
            return;
        }
        req.getRequestDispatcher("employeeController?method=login").forward(req, resp);
    }
}
