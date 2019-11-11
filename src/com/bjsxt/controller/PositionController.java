package com.bjsxt.controller;

import com.bjsxt.entity.Position;
import com.bjsxt.service.PositionService;
import com.bjsxt.service.impl.PositionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/positionController")
public class PositionController extends BaseController {
    private PositionService positionService = new PositionServiceImpl();


    protected void updatePosition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println();
        Integer posid = Integer.parseInt(req.getParameter("posid"));
        String pname = req.getParameter("pname");
        String pdesc = req.getParameter("pdesc");
        Position position = new Position(posid, pname, pdesc);
        System.out.println(position);
        int i = positionService.updatePosition(position);
        resp.sendRedirect("positionController?method=findAllPosition");
    }

    protected void findByposid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Integer posid = Integer.parseInt(req.getParameter("posid"));


        Position position = positionService.findByPosid(posid);

        req.setAttribute("position",position);

        req.getRequestDispatcher("positionUpdate.jsp").forward(req, resp);

    }

    protected void positionAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer posid = Integer.parseInt(req.getParameter("posid"));
        String pname = req.getParameter("pname");
        String pdesc = req.getParameter("pdesc");
        Position position = new Position(posid, pname, pdesc);
        int insert = positionService.insert(position);


        if (insert == 1) {
            resp.sendRedirect("positionController?method=findAllPosition");
        } else {
            resp.sendRedirect("deptAdd.html");

        }

    }

    protected void findAllPosition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Position> positions = positionService.findAll();
//        System.out.println(positions);
        req.setAttribute("positions",positions);
        req.getRequestDispatcher("positionList.jsp").forward(req, resp);


    }

    protected void deletePosition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer posid = Integer.parseInt(req.getParameter("posid"));
        int delete = positionService.deleteByPosid(posid);
        resp.sendRedirect("positionController?method=findAllPosition");



    }

}
