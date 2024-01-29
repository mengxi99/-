package com.kunpeng.web;

import com.alibaba.fastjson.JSON;
import com.kunpeng.dao.UserInfoDao;
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
@WebServlet("/regit")
public class RegitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        System.out.println("username = " + username);
//        System.out.println("password = " + password);
        resp.setHeader("Content-Type","text/plain;charset=utf-8");
        UserInfoDao userInfoDao=new UserInfoDao();
        int i=userInfoDao.insertDao(username,password);
        if (i>0){
            resp.setHeader("Content-Type","text/JOSN;charset=utf-8");
            String s = JSON.toJSONString(i);
            resp.getWriter().write(s);
        }else {
            resp.setHeader("Content-Type","text/JOSN;charset=utf-8");
            resp.getWriter().write("注册失败");
        }
    }
}
