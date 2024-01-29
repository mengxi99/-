package com.kunpeng.web;

import com.alibaba.fastjson.JSON;
import com.kunpeng.dao.SelectDepartmentsDao;
import com.kunpeng.entity.Dep;
import com.kunpeng.entity.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 木木
 */
@WebServlet("/selectDep")
public class DepSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SelectDepartmentsDao selectDepartmentsDao=new SelectDepartmentsDao();
        List<Dep> deps = selectDepartmentsDao.selectDep();
        if (deps!=null){
            resp.setHeader("Content-Type","text/JOSN;charset=utf-8");
            String s = JSON.toJSONString(deps);
            resp.getWriter().write(s);
        }

    }
}
