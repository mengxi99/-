package com.kunpeng.web;

import com.kunpeng.dao.FindEmpDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 木木
 * 删除
 */
@WebServlet("/delEmp")
public class delEmpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get");
        String id = req.getParameter("id");
        FindEmpDao dao=new FindEmpDao();
        int i = dao.delEmp(Integer.parseInt(id));
        if (i>0){
            resp.getWriter().write("success");
        }
    }
}
