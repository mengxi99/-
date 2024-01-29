package com.kunpeng.web;

import com.alibaba.fastjson.JSON;
import com.kunpeng.dao.FindEmpDao;
import com.kunpeng.entity.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 木木
 */
@WebServlet("/find")
public class FindEmpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type","text/plain;charset=utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        FindEmpDao findEmpDao=new FindEmpDao();
        Emp emp=findEmpDao.findEmpById(id);
        if (emp!=null){
            resp.setHeader("Content-Type","text/JOSN;charset=utf-8");
            String s = JSON.toJSONString(emp);
            resp.getWriter().write(s);
        }else {
            resp.setHeader("Content-Type","text/plain;charset=utf-8");
            resp.getWriter().write("不存在");
        }
    }
}
