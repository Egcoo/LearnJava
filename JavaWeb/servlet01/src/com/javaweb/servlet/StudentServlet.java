package com.javaweb.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @ author Egcoo
 * @ date 2023/2/5 - 10:38
 使用JDBC的七个步骤包括
 1.加载驱动
 2.通过驱动管理器获取连接对象
 3.编写SQL语句
 4.创建预处理命令对象
 5.填充参数
 6.执行更新(增删改），返回影响行数
 7.释放资源（关闭结果集 , 先关闭预处理命令对象，后关闭连接对象）
 */
public class StudentServlet implements Servlet {

    //多线程共享一个对象，真正的单例对象是构造方法私有化的
    public StudentServlet() {
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    // servlet对象是单实例的：说明Servlet对象只创建一次

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // 设置相应类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //连接数据库（JDBC）
        ResultSet resultSet = null;
        PreparedStatement psmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itheima", "root", "123456");
            String sql = "select * from t_fruit";
            psmt = conn.prepareStatement(sql);
            resultSet = psmt.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("fname");
                String no = resultSet.getString("price");
                out.println(name + " " + no + "<br>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                psmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
