package com.kunpeng.dao;

import com.kunpeng.entity.Emp;
import com.kunpeng.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 木木
 */
public class FindEmpDao {
    public int delEmp(int id){
        Connection connection = JdbcUtils.getConnection();
        if(connection==null){
            return -1;
        }
        String sql="delete from members where id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int i = statement.executeUpdate();
            return i;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }
    public int saveEmp(Emp emp){
        Connection connection = JdbcUtils.getConnection();
        if(connection==null){
            return -1;
        }
        String sql="insert into members values(null,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,emp.getName());
            statement.setString(2,emp.getGender());
            statement.setString(3,emp.getBirth());
            statement.setString(4,emp.getLevel());
//            statement.setString(5,emp.getMobile());
            int resultSet = statement.executeUpdate();
            return resultSet;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }



    public List<Emp> findEmpBypage(int pageNum,int pageSize){
        Connection connection = JdbcUtils.getConnection();
        if(connection==null){
            return null;
        }
        String sql="select * from members limit ?,?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,(pageNum-1)*pageSize);
            statement.setInt(2,pageSize);
            ResultSet resultSet = statement.executeQuery();
            List<Emp> emps=new ArrayList<>();
            while (resultSet.next()){
                Emp emp1=new Emp(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("gender"),resultSet.getString("birth"),resultSet.getString("level"),resultSet.getString("mobile"));
                emps.add(emp1);
            }
            return emps;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public int selectCount(){
        Connection connection = JdbcUtils.getConnection();
        if(connection==null){
            return -1;
        }
        String sql="select count(1) from members";
        try {
            PreparedStatement statement =connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int rs = resultSet.getInt(1);
            JdbcUtils.reale(connection,statement,resultSet);
            return rs;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }

    }




    public Emp findEmpById(int id){
        Connection connection = JdbcUtils.getConnection();
        if(connection==null){
            return null;
        }
        String sql="select * from members where id=?";
        try {
            PreparedStatement statement =connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

           if (resultSet.next()){
               Emp emp=new Emp(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("gender"),resultSet.getString("birth"),resultSet.getString("level"),resultSet.getString("mobile"));
               return emp;
           }else {
                return null;
           }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
