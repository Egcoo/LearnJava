package com.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @ author Egcoo
 * @ date 2022/10/30 - 10:52
 */
public class jdbc01 {
    public static void main(String[] args) throws SQLException {

        // 将 mysql.jar 拷贝到该目录下，点击 add to project ..加入到项目

        // 1.注册驱动
        Driver driver = new Driver();// 创建driver驱动

        // 2.得到链接
        // (1)jdbc:mysql:// 规定号表示协议，也即通过 jdbc 的方式连接 mysql
        // (2)localhost 主机，可以是 ip 地址
        //(3) 3306 表示 mysql 监听的端口
        //(4) hsp_db02 连接到 mysql dbms 的哪个数据库
        //(5) mysql 的连接本质就是前面学过的 socket 连接
        String url = "jdbc:mysql://localhost:3306/itheima";

        // 将 用户名和密码放入到 Properties 对
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");

        // 获取连接
        Connection connect = driver.connect(url, properties);


        // 3.执行 sql 语句
        // String sql = "insert into tb_user_test values(6,'周润发',60,'男')";
        // sql = "delete form tb_user_test where id = 6";
        // String sql = "update tb_user_test set name='周星驰' where id = 1";
        String sql = "delete from tb_user_test where id = 6";
        //statement 用于执行静态 SQL 语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql); // 如果是 dml 语句，返回的就是影响行

        System.out.println(rows > 0 ? "成功" : "失败");

        //4. 关闭连接资源
        statement.close();
        connect.close();

    }
}
