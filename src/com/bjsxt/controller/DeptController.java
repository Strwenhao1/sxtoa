package com.bjsxt.controller;

import com.bjsxt.entity.Dept;
import com.bjsxt.service.DeptService;
import com.bjsxt.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deptController")
public class DeptController extends BaseController {
    private DeptService deptService = new DeptServiceImpl();


    protected void updateDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer deptno = Integer.parseInt(req.getParameter("deptno"));
        String deptname = req.getParameter("deptname");
        String location = req.getParameter("location");
        Dept dept = new Dept(deptno,deptname,location);
        int updateDept = deptService.updateDept(dept);
        resp.sendRedirect("deptController?method=findAllDept");
    }

    protected void findByDeptno(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        Integer deptno = Integer.parseInt(req.getParameter("deptno"));
        Dept dept = deptService.findByDeptno(deptno);
        req.setAttribute("dept", dept);
        req.getRequestDispatcher("deptUpdate.jsp").forward(req, resp);

    }

    protected void deptAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer deptno = Integer.parseInt(req.getParameter("deptno"));
        String deptname = req.getParameter("deptname");
        String location = req.getParameter("location");

        Dept dept = new Dept(deptno, deptname, location);

        int insert = deptService.insert(dept);
        if (insert == 1) {
            resp.sendRedirect("deptController?method=findAllDept");
        } else {
            resp.sendRedirect("deptAdd.html");

        }

    }

    protected void findAllDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> depts = deptService.findAll();
        if (depts != null) {

            req.setAttribute("depts", depts);
            req.getRequestDispatcher("deptList.jsp").forward(req, resp);
        }


    }

    protected void deleteDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer deptno = Integer.parseInt(req.getParameter("deptno"));
        System.out.println(deptno);
        int delete = deptService.deleteByDeptno(deptno);
        resp.sendRedirect("deptController?method=findAllDept");



    }



}

