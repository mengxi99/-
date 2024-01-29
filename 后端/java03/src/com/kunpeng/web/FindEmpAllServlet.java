package com.kunpeng.web;

import com.alibaba.fastjson.JSON;
import com.kunpeng.dao.FindEmpDao;
import com.kunpeng.entity.Emp;
import com.kunpeng.entity.PageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 木木
 * 分页查询
 */
@WebServlet("/findAll")
public class FindEmpAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNum = Integer.parseInt(req.getParameter("pageNum"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        FindEmpDao empDao=new FindEmpDao();
        List<Emp> empAll = empDao.findEmpBypage(pageNum,pageSize);
        int count = empDao.selectCount();
        int pagecount=count%pageSize==0?count/pageSize:count/pageSize+1;
        PageModel pageModel=new PageModel(pagecount,empAll,pageNum);


        if (pageModel!=null){
            resp.setHeader("Content-Type","text/JOSN;charset=utf-8");
            String s = JSON.toJSONString(pageModel);
            resp.getWriter().write(s);
        }
    }
}
