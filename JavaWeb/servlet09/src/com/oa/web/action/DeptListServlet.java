package com.oa.web.action;

import com.oa.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ author Egcoo
 * @ date 2023/2/23 - 11:35
 *
 * 1.转发和重定向的区别
 * 转发的后台是由Tomcat 负责调配资源，只是给浏览器发送了一次请求
 * 重定向是给发送了两次请求，当然也可以多次重定向
 */
public class DeptListServlet extends HttpServlet {
    //这里处理的是一个dopost请求
    //@Override
    //protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //    doGet(request, response);
    //}

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
        out.println("    <title>列表页面</title>");

        out.println("<script type='text/javascript'>");
        out.println("    function del(deptno) {");
        out.println("    //弹出确认框，确定true，取消false");
        out.println("    if (window.confirm('删除不可恢复')) {");
        out.println("        document.location.href = '"+contextPath+"/dept/delete?deptno='+deptno");
        out.println("    }");
        out.println("} ");
        out.println("</script>");

        out.println("</head>");
        out.println("<body>");
        out.println("      <h1 align='center'>部门列表</h1>");
        out.println("       <hr>");
        out.println("       <table border='1px' align='center' width='50%'>");
        out.println("        <tr>");
        out.println("            <th>序号</th>");
        out.println("            <th>部门编号</th>");
        out.println("            <th>部门名称</th>");
        out.println("            <th>操作</th>");
        out.println("        </tr>");
        // 上面一部分是死的
        //连接数据库，查询所有的部门
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            // 获取预编译的命令对象
            String sql = "select deptno,dname,loc from dept";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                out.println("   <tr>");
                out.println("       <td>"+(++i)+"</td>");
                out.println("       <td>"+deptno+"</td>");
                out.println("       <td>"+dname+"</td>");
                out.println("       <td>");
                out.println("            <a href='javascript:void(0)' onclick='del("+deptno+")'>删除</a>");
                out.println("            <a href='"+contextPath+"/dept/edit?deptno="+deptno+"''>修改</a>");
                out.println("            <a href='"+contextPath+"/dept/detail?deptno="+deptno+"'>详情</a>");
                out.println("       </td>");
                out.println("    </tr>");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        // 下面一部分是死的
        out.println("   </table>");
        out.println("   <hr>");
        out.println("   <a href='"+contextPath+"/add.html'>新增部门</a>");
        out.println("</body>");
        out.println("</html>");

    }
}
