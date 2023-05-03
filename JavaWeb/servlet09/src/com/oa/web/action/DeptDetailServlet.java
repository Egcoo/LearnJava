package com.oa.web.action;

import com.oa.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

/**
 * @ author Egcoo
 * @ date 2023/2/25 - 13:16
 * <p
 * 但凡前端发送请求，一定要带上项目名
 * <p>
 * 中文思路（思路来源于你要做什么，查看部门的详细信息）
 * 1.获取部门编号
 * 2.查看部门的详细信息，获取该部门对应的详细信息
 * 3.将部门信息显示到浏览器上，（最好写一步验证一步）
 * 4. 40X的错误都是前端浏览器的错误，50X都是后端服务器端错误
 */
public class DeptDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>部门详情</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>部门详情</h1>");
        out.println("<hr>");

        // 获取部门编号
        // 虽然获取的是30，但是获取到的是30这个字符串
        String deptno = request.getParameter("deptno");

        // 根据部门编号，查询部门信息
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            // 获取预编译的命令对象
            String sql = "select dname,loc from dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            rs = ps.executeQuery();
            if (rs.next()) {
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                out.println("部门编号："+deptno+" <br>");
                out.println("部门名称："+dname+" <br>");
                out.println("部门地址："+loc+" <br>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        out.println("<input type='button' value='后退' onclick='window.history.back()'/>");
        out.println("</body>");
        out.println("</html>");
    }
}
