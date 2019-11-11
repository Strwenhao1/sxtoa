package com.bjsxt.service.impl;

import com.bjsxt.entity.Dept;
import com.bjsxt.service.PageBean;

import java.util.List;

public class PageBeanImpl implements PageBean {
    @Override
    public com.bjsxt.entity.PageBean<Dept> findByProduct(Integer currPage, Integer pageSize) {
        //1、创建PageBean对象
        com.bjsxt.entity.PageBean<Dept> pageBean = new com.bjsxt.entity.PageBean<>();
        //2、获取当前页面（页面传参过来）
        pageBean.setCurrPage(currPage);
        //3、每页条数
        pageBean.setPageSize(pageSize);
        //4、总条数
        DeptServiceImpl d = new DeptServiceImpl();
        Integer totalCount = d.countDept();
//        Integer totalCount = productDao.findByTotalCount();
        pageBean.setTotalCount(totalCount);
        //5、总页数
        double ceil = Math.ceil(totalCount * 1.0 / pageSize);
        pageBean.setTotalPage((int) ceil);
        //6、当前页面数据，从数据库查询
        int start = pageSize * (currPage - 1) + 1;
        int end = pageSize * currPage;
//        List<Dept> productList = productDao.findByProduct(start, end);
//        pageBean.setList(productList);
        return pageBean;

    }
}
