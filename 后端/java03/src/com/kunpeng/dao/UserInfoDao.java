package com.kunpeng.dao;

import com.kunpeng.utils.JdbcUtils;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 木木
 */
public class UserInfoDao {
    public int insertDao(String username,String password){
        ResultSet resultSet=null;
        try {
            Connection connection=JdbcUtils.getConnection();
            if(connection==null){
                return -1;
            }
            String sql="INSERT into login VALUES(null,?,?)";
            PreparedStatement statement =connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2, DigestUtils.md5Hex(password));
            int i = statement.executeUpdate();
            JdbcUtils.reale(connection,statement,resultSet);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int loginDao(String username,String password){
        ResultSet resultSet=null;
        try {
            Connection connection = JdbcUtils.getConnection();
            if(connection==null){
                return -1;
            }
            String sql="SELECT COUNT(1) FROM login where usename=? AND password=?";
            PreparedStatement statement =connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2, DigestUtils.md5Hex(password));
            ResultSet rs = statement.executeQuery();
            rs.next();
            int account=rs.getInt(1);
            JdbcUtils.reale(connection,statement,resultSet);
            return account;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
