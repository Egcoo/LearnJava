package com.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @ author Egcoo
 * @ date 2022/11/1 - 20:26
 */
public class ResultSet_ {
    public static void main(String[] args) throws Exception {

        // 1.通过 Properties 对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("E:\\Java_Project\\Module01\\JDBC25\\src\\mysql.properties"));
        // 2.获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        // 3.获取驱动，虽然是自动获取，但是建议写上
        Class.forName(driver);

        // 4.得到连接
        Connection connection = DriverManager.getConnection(url, user, password);

        // 5.得到 Statement, 但是在开发中是不能使用的，存在 sql 注入的问题
        // sql 注入是利用某些系统没有对用户输入的数据进行充分的检查，而在用户输入的数据中注入非法的sql语句或命令，恶意攻击数据库

        Statement statement = connection.createStatement();
        // 6.组织 Sql
        String sql = "select * from tb_user_test";

        ResultSet resultSet = statement.executeQuery(sql);

        // 7.最后使用 while 读取数据
        while (resultSet.next()){ // 让光标向后移动，如果没有更多行，则返回 false
            //int id = resultSet.getInt(1); // 获取第一行
            int id = resultSet.getInt("id"); // 获取第一行,通过列名来获取
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String gender = resultSet.getString("gender");

            System.out.println(id + "\t" + name + "\t" + age +"\t" + gender );
        }

        // 最后一步，关闭连接
        resultSet.close();
        statement.close();
        connection.close();


    }
}
