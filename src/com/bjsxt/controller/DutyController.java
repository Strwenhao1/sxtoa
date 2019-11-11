package com.bjsxt.controller;

import com.bjsxt.entity.Dept;
import com.bjsxt.entity.Duty;
import com.bjsxt.entity.Employee;
import com.bjsxt.service.DeptService;
import com.bjsxt.service.DutyService;
import com.bjsxt.service.impl.DeptServiceImpl;
import com.bjsxt.service.impl.DutyServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/dutyController")
public class DutyController extends BaseController {

    DutyService dutyService = new DutyServiceImpl();
    private DeptService deptService = new DeptServiceImpl();

    SimpleDateFormat dtdate = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    protected void addDuty(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = (Employee) req.getSession().getAttribute("employee");
        Duty duty = new Duty(employee.getEmpId(),new Date(),sdf.format(new Date()),sdf.format(new Date()));
        int i = dutyService.addDuty(duty);
    }

    protected void findTodyDuty(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = (Employee) req.getSession().getAttribute("employee");
        Date date = null;
        try {
             date = dtdate.parse(dtdate.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Duty todyDUty = dutyService.findTodyDUty(employee.getEmpId(), date);
        if (todyDUty!=null){
            resp.getWriter().write("1");
            return;
        }
        resp.getWriter().write("2");
        resp.sendRedirect("dutyController?method=addDuty");
    }

    protected void updateDuty(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = (Employee) req.getSession().getAttribute("employee");
        Date date = null;
        try {
            date = dtdate.parse(dtdate.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("employee"+employee.getEmpId()+"\t"+"date"+date);
        Duty todyDUty = dutyService.findTodyDUty(employee.getEmpId(), date);
        if (todyDUty==null){
            resp.getWriter().write("1");
            return;
        }
        Employee emp = (Employee) req.getSession().getAttribute("employee");
        Duty duty = new Duty(emp.getEmpId(),date,sdf.format(new Date()),sdf.format(new Date()));
        int i = dutyService.updateDuty(duty);


    }


    protected void selectAllDuty(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Duty> duties = dutyService.selectAllDuty();
        List<Dept> depts = deptService.findAll();
        System.out.println(depts);
        req.setAttribute("depts", depts);
        req.setAttribute("duties",duties);
        req.getRequestDispatcher("dutyList.jsp").forward(req, resp);
    }

    protected void findCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String emprid = req.getParameter("emprid");
        String deptno = req.getParameter("deptno");
        String dtdate = req.getParameter("dtdate");

        List<Duty> condition = dutyService.findCondition(emprid, deptno, dtdate);
        System.out.println(condition);
        GsonBuilder builder = new GsonBuilder().setDateFormat("yyyy-MM-dd");
        Gson gson = builder.create();
        String s = gson.toJson(condition);
        resp.getWriter().write(s);
//        System.out.println(s);
//        System.out.println(emprid+"\t"+deptno+"\t"+dtdate);
    }



    protected void educe(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
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

        createExcel(duties,resp);
    }

    public void createExcel(List<Duty> list, HttpServletResponse resp){
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("出勤表");
        CellRangeAddress region = new CellRangeAddress(0,0,0,5);
        sheet.addMergedRegion(region);
        HSSFRow row0 = sheet.createRow(0);
        HSSFCell cell = row0.createCell(0);
        cell.setCellValue("考勤表");

        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        cell.setCellStyle(cellStyle);

        HSSFRow row1 = sheet.createRow(1);
        HSSFCell headCell = row1.createCell(0);
        headCell.setCellValue("用户名");
        headCell.setCellStyle(cellStyle);

        headCell = row1.createCell(1);
        headCell.setCellValue("员工姓名");
        headCell.setCellStyle(cellStyle);

        headCell = row1.createCell(2);
        headCell.setCellValue("所属部门");
        headCell.setCellStyle(cellStyle);

        headCell = row1.createCell(3);
        headCell.setCellValue("考勤日期");
        headCell.setCellStyle(cellStyle);

        headCell = row1.createCell(4);
        headCell.setCellValue("签到时间");
        headCell.setCellStyle(cellStyle);

        headCell = row1.createCell(5);
        headCell.setCellValue("签到时间");
        headCell.setCellStyle(cellStyle);

        HSSFRow rows ;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0 ; i < list.size();i++){
            rows = sheet.createRow(i+2);
            Duty duty = list.get(i);

            cell = rows.createCell(0);
            cell.setCellValue(duty.getEmprid());
            cell.setCellStyle(cellStyle);

            cell = rows.createCell(1);
            cell.setCellValue(duty.getRealname());
            cell.setCellStyle(cellStyle);

            cell = rows.createCell(2);
            cell.setCellValue(duty.getDeptname());
            cell.setCellStyle(cellStyle);

            cell = rows.createCell(3);
            cell.setCellValue(sdf.format(duty.getDtdate()));
            cell.setCellStyle(cellStyle);

            cell = rows.createCell(4);
            cell.setCellValue(duty.getSignintime());
            cell.setCellStyle(cellStyle);

            cell = rows.createCell(5);
            cell.setCellValue(duty.getSignouttime());
            cell.setCellStyle(cellStyle);

        }


        // 保存Excel文件
        try {
            /*设置响应内容为excel文件*/
            resp.setContentType("application/vnd.ms-excel");
            /*告知浏览器响应的数据以文件形式接收*/
            resp.setHeader("Content-Disposition","attachment;filename=duty"+sdf.format(new Date())+".xls");
            resp.resetBuffer();
            ServletOutputStream outputStream = resp.getOutputStream();

            wb.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


//        resp.setContentType("application/vnd.ms-excel");
//        resp.setHeader("Content-Disposition","attachment;filename=duty"+sdf.format(new Date())+".xls");
//        OutputStream outputStream = null;
//        try {
//            outputStream = resp.getOutputStream();
//            wb.write(outputStream);
//            outputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if (outputStream!=null){
//
//                    outputStream.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


    }
}
