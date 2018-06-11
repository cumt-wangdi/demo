package com.example.demo.dao;

import java.sql.*;

public class SqliteUtil {

    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:C:/Desktop/test.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(ResultSet rs, Statement statement, Connection connection) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

