package com.kunpeng.web;

import com.kunpeng.utils.JdbcUtils;
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
//@WebServlet("/regit")
public class RegitServlet2  extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        try {
            Connection connection = JdbcUtils.getConnection();
            String sql="INSERT into login VALUES(null,?,?)";
            String sql2="SELECT COUNT(1) FROM login where usename=?";
            PreparedStatement statement =connection.prepareStatement(sql);
            PreparedStatement statement2 =connection.prepareStatement(sql2);


            statement2.setString(1,username);
            ResultSet t = statement2.executeQuery();
//            ResultSet rs = statement.executeUpdate();

            resp.setHeader("Content-Type","text/plain;charset=utf-8");
            t.next();
            if(t.getInt(1)>0){
                resp.getWriter().write("账号已存在");
            }else {
                statement.setString(1,username);
                statement.setString(2, DigestUtils.md5Hex(password));
                int i = statement.executeUpdate();
                if (i>0){
                    resp.getWriter().write("注册成功");
                }else {
                    resp.getWriter().write("注册失败");
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println(e.getMessage());
        }

    }
}
