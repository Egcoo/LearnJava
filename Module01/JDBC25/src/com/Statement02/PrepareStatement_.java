package com.Statement02;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2022/11/2 - 15:07
 */
public class PrepareStatement_ {
    public static void main(String[] args) throws Exception {

        // 看PrepareStatement 类图

        Scanner myScanner = new Scanner(System.in);

        //让用户输入管理员的名和密码
        System.out.println("请输入管理员的名字："); // next() 当接收到空格 或者 ‘ 就是表示结束
        String admin_name = myScanner.nextLine();
        System.out.println("请输入管理员的密码：");
        String admin_pwd = myScanner.nextLine();


        // 通过 Properties 对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("E:\\Java_Project\\Module01\\JDBC25\\src\\mysql.properties"));
        // 2.获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        // 1.注册驱动
        Class.forName(driver);

        // 2.得到连接
        Connection connection = DriverManager.getConnection(url, user, password);

        // 3.得到PrepareStatement
        // 3.1 组织Sql，Sql 语句的 ？ 就相当于占位符
        String sql = "select * from admin where name = ? and password = ?";
        // 3.2 preparedStatement 对象实现了 PrepareStatement 接口的实现类的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 3.3 给 ？ 赋值
        preparedStatement.setString(1,admin_name);
        preparedStatement.setString(2,admin_pwd);

        // 4.执行 select 语句使用 executeQuery
        // 如果执行的是 dml(update, insert ,delete) executeUpdate()
        // 这里执行 executeQuery,不用再写 sql
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            System.out.println("恭喜，登录成功");
        } else {
            System.out.println("对不起，登陆失败");
        }

        // 关闭连接
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
