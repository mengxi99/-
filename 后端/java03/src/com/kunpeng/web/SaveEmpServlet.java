package com.kunpeng.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
 * 添加
 */
@WebServlet("/saveEmp")
public class SaveEmpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Emp emp = JSON.parseObject(req.getInputStream(),Emp.class);
        FindEmpDao findEmpDao=new FindEmpDao();
        int i = findEmpDao.saveEmp(emp);
        if (i>0){
            resp.getWriter().write("success");
        }

    }
}
