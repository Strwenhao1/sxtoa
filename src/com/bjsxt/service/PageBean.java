package com.bjsxt.service;

import com.bjsxt.entity.Dept;

public interface PageBean<T> {
    public com.bjsxt.entity.PageBean<Dept> findByProduct(Integer currPage, Integer pageSize);
}
