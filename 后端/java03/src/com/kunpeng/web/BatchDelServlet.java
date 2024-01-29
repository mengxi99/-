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
 * 批量删除
 */
@WebServlet("/batchDel")
public class BatchDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("bacth");
        String ids = req.getParameter("ids");
        String[] split = ids.split(",");
        FindEmpDao dao = new FindEmpDao();
        for(int i=0;i<split.length;i++){
            dao.delEmp(Integer.parseInt(split[i]));
        }
        resp.getWriter().write("success");
    }
}
