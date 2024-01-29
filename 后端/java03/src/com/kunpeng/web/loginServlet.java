package com.kunpeng.web;


import com.alibaba.fastjson.JSON;
import com.kunpeng.dao.UserInfoDao;
import com.sun.net.httpserver.HttpServer;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 木木
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        System.out.println(username+password);
        resp.setHeader("Content-Type","text/plain;charset=utf-8");
        UserInfoDao userInfoDao=new UserInfoDao();
        int rs=userInfoDao.loginDao(username,password);
        if (rs>0){
            resp.setHeader("Content-Type","text/JOSN;charset=utf-8");
            String s = JSON.toJSONString(rs);
            resp.getWriter().write(rs);
        }else {
            resp.setHeader("Content-Type","text/JOSN;charset=utf-8");
            resp.getWriter().write("登录失败");
        }
    }
}
