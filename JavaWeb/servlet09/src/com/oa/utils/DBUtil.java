package com.oa.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @ author Egcoo
 * @ date 2023/2/22 - 16:14
 * 1.加载驱动
 * 2.通过驱动管理器获取连接对象
 * 3.编写SQL语句
 * 4.创建预处理命令对象
 * 5.填充参数
 * 6.执行更新(增删改），返回影响行数
 * 7.释放资源（关闭连接 , 先关闭psmt，后关闭conn）
 * <p>
 * 当你想要在图书馆里添加新书时，你需要执行以下步骤：
 * 1.找到你需要的工具（JDBC驱动程序），并加载到你的工具箱中。
 * 2.连接到数据库，就像拨打电话一样。
 * 3.告诉数据库你要添加什么书，就像留言一样。
 * 4.指示你的同事执行添加书的任务，并告诉他们书的详细信息。
 * 5.如果需要，在任务中提供其他必要的信息。
 * 6.当你的同事完成任务时，他们会告诉你添加了多少本书。
 * 7.将所有使用的工具放回工具箱，以便下次使用。
 */
public class DBUtil {

    // 静态变量：在类加载时执行
    // 并且是有顺序的，自上而下的顺序
    // 属性资源文件绑定,根据key获取value
    private static ResourceBundle bundle = ResourceBundle.getBundle("resources.jdbc");
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String user = bundle.getString("user");
    private static String password = bundle.getString("password");

    static {
        // 注册驱动（注册驱动只需要注册一次，放在静态代码块中，DBUtil类加载的时候执行）
        try {
            //"com.mysql.jdbc.Driver" 是连接数据库的驱动，不能写死，因为以后可能还会出现连接Oracle数据库
            //如果连接oracle 数据库的时候，还需要修改java代码显然违背了OCP开闭原则
            //OCP开闭原则：对扩展开放，对修改关闭（什么是符合OCP呢？在进行功能扩展的时候，不需要修改java代码）
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象
     *
     * @throws java.sql.SQLException
     * @retrun conn
     */

    public static Connection getConnection() throws SQLException {
        //获取链接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }


    /**
     * 释放资源
     *
     * @param conn
     * @param ps
     * @param rs
     * @throws SQLException
     */
    public static void close(Connection conn, Statement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
