package com.bjsxt.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    public static SqlSession getSqlSession(){
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
             sqlSession = build.openSession();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
