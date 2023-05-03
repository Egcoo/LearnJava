package com.oa.web.action;

import com.oa.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @ author Egcoo
 * @ date 2023/3/8 - 19:21
 */
public class DeptEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取应用的根路径
        String contextPath = request.getContextPath();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>修改部门</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>修改部门</h1>");
        out.println("<hr>");
        out.println("<form action='"+contextPath+"/dept/modify' method='post'>");

        //获取部门编号
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
                out.println("                部门编号<input type='text' name='deptno' value='"+deptno+"' readonly/> <br>");
                out.println("                部门名称<input type='text' name='dname' value='"+dname+"'/> <br>");
                out.println("                部门位置<input type='text' name='loc' value='"+loc+"'/> <br>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }


        out.println("    <input type='submit' value='保存'/><br>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
