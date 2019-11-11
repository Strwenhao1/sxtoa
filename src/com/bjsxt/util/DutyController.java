package com.bjsxt.util;

import com.bjsxt.entity.Dept;
import com.bjsxt.entity.Duty;
import com.bjsxt.service.DutyService;
import com.bjsxt.service.impl.DutyServiceImpl;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/dutyDownController")
public class DutyController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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


//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(sdf.format(date));
//        File file = new File("d:/" + sdf.format(date)+".txt");
//        PrintWriter pw = new PrintWriter(file);
//        pw.println("员工编号" + "\t"
//                + "员工姓名" + "\t"
//                + "签到日期"+ "\t\t"
//                + "签到时间" + "\t"
//                + "签退时间" + "\t");
//        for (Duty duty : duties) {
//
//            pw.println(duty.getEmprid() + "\t"
//                    + duty.getRealname() + "\t"
//                    + sdf.format(duty.getDtdate())+ "\t"
//                    + duty.getSignintime() + "\t"
//                    + duty.getSignouttime() + "\t");
//        }
//        pw.flush();
//        pw.close();
//        resp.getWriter().write("d:/" + sdf.format(date)+".txt");
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

        resp.setContentType("applecation/cnd,ms-excel");
        resp.setHeader("Content-Disposition","attachment;filename=duty"+sdf.format(new Date())+".xls");
        OutputStream outputStream = null;
        try {
            outputStream = resp.getOutputStream();
            wb.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (outputStream!=null){

                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
