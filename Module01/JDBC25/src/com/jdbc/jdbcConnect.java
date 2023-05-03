package com.jdbc;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ author Egcoo
 * @ date 2022/10/31 - 20:07
 * 分析 java 连接 MySql的五种方式
 */
public class jdbcConnect {

    // 方式一
    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/itheima";
        // 将 用户名和密码放入到 Properties 对
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");

        // 获取连接
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    // 方式二
    @Test
    public void connect02() throws Exception {
        // 通过反射加载Driver类，动态加载，更加的灵活，减少依赖性
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/itheima";
        // 将 用户名和密码放入到 Properties 对
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");

        // 获取连接
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    // 方式三： 用 DriverManager 代替 driver 进行统一管理 ， 更灵活
    @Test
    public void connect03() throws Exception {

        // 通过反射加载Driver类，动态加载，更加的灵活，减少依赖性
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/itheima";
        String user = "root";
        String password = "123456";

        DriverManager.deregisterDriver(driver); // 注册驱动

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }


    // 使用 Class.forName 自动完成注册驱动，简化代码，
    // 推荐使用，是开发使用最多的
    @Test
    public void connect04() throws Exception {

        // 通过反射加载Driver类，动态加载，更加的灵活，减少依赖性
        /*
        1.静态代码块，在类加载时候，会执行一次
        2. DriverManager.registerDriver(new Driver());
        3. 因此注册 driver的工作已经完成

        static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException var1) {
            throw new RuntimeException("Can't register driver!");
        }
         */
        Class.forName("com.mysql.cj.jdbc.Driver");


        String url = "jdbc:mysql://localhost:3306/itheima";
        String user = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }

    @Test
    // 方式五：在方式四的基础上，增加配置文件，更加灵活
    public void connect05() throws Exception {
        // 通过 Properties 对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("E:\\Java_Project\\Module01\\JDBC25\\src\\mysql.properties"));
        // 获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver); // 建议写上

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
}
