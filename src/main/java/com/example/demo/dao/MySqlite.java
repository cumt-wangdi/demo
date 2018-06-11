package com.example.demo.dao;

import com.example.demo.entity.Guitar;
import com.example.demo.entity.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlite {
    private static Connection conn = SqliteUtil.getConnection();
    private PreparedStatement ps;

    public void createTable() {

        try {

            //创建表
            String sql = "create table person(id INTEGER primary key autoincrement, name TEXT)";
            ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("*********create table person OK*********");
            //插入数据

/*

            //删除
            String deleteSql = "delete from person where id=?";
            ps = conn.prepareStatement(deleteSql);
            ps.setInt(1, 1);
            ps.execute();
            System.out.println("*********delete from person OK*********");*/
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Person> findAllGuitar() {
        String sql = "select * from person";
        return getPeople(sql);
    }

    private List<Person> getPeople(String sql) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Person> arrayList = new ArrayList<>();
            while (rs.next()) {
                //得到游标中的字段值，索引也是从1开始的
                Person person = new Person();
                Integer id = Integer.parseInt(rs.getString(1));
                String name = rs.getString(2);
                person.setId(id);
                person.setName(name);
                arrayList.add(person);
            }
            return arrayList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertData(String name) {
        String insertSql = "insert into person(name) values(?)";
        try {
            ps = conn.prepareStatement(insertSql);
            ps.setString(1,name);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //注意第一个参数从1开始而不是0
        System.out.println("*********insert into person OK*********");

    }

    
}
