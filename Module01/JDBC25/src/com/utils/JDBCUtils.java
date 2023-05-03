package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @ author Egcoo
 * @ date 2022/11/2 - 21:28
 * <p>
 * 在jdbc 操作中，获取链接和释放资源是经常使用到，可以将其封装 JDBC 连接的工具类 JDBCUtils
 */
public class JDBCUtils {

    // 定义相关属性(4) ，因为只需要一份，所以做成static
    private static String user; //用户名
    private static String password; //密码
    private static String url; // url
    private static String driver; // 驱动名

    // 在 static 代码块去初始化

    static {
        try {
            // 使用properties 获取配置文件信息
            Properties properties = new Properties();
            properties.load(new FileInputStream("E:\\Java_Project\\Module01\\JDBC25\\src\\mysql.properties"));

            // 获取相关的值
            // 获取相关的值
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
        } catch (IOException e) {
            //e.printStackTrace();
            //在实际开发中，我们可以这样处理
            //1. 将编译异常转成 运行异常
            //2. 调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便.
            throw new RuntimeException(e);
        }
    }

    // 连接数据库，返回 connection
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            //e.printStackTrace();
            //1. 将编译异常转成 运行异常
            //2. 调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便.
            throw new RuntimeException(e);
        }
    }

    // 关闭相关资源
    /*
        ResultSet 结果集
        statement 或者 PrepareStatement
        connection
        如果需要关闭资源就需要传入参数
     */

    public static void close(ResultSet set, Statement statement, Connection connection) {
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            //1. 将编译异常转成 运行异常
            //2. 调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便.
            throw new RuntimeException(e);
        }
    }
}
