package com.bjsxt.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        resp.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Headers",
                "*");
        resp.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");



        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String method = req.getParameter("method");

        Class clazz = this.getClass();
        try {

            Method clazzMethod = clazz.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            clazzMethod.invoke(this, req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
