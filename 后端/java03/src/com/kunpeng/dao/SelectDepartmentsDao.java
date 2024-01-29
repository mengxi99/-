package com.kunpeng.dao;

import com.kunpeng.entity.Dep;
import com.kunpeng.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 木木
 */
public class SelectDepartmentsDao {
    public List<Dep> selectDep(){
        Connection connection = JdbcUtils.getConnection();
        if(connection==null){
            return null;
        }
        String sql="SELECT * FROM departments";

        try {
            PreparedStatement statement= connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Dep> deps=new ArrayList<>();
            while (resultSet.next()){
                Dep dep=new Dep(resultSet.getInt("deptid"),resultSet.getString("deptname"));
                deps.add(dep);
            }
            return deps;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }
}
