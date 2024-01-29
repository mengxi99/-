package com.kunpeng.utils;

import java.sql.*;

/**
 * 木木
 */
public class JdbcUtils {
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/examdb?useSSL=false&characterEncoding=utf8","root","123456");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void reale(Connection connection, PreparedStatement statement, ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }


    }
}
