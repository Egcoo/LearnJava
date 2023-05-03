package com.oa.web.action;

import com.oa.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ author Egcoo
 * @ date 2023/3/8 - 20:03
 */
@WebServlet()
public class DeptModifyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取部门信息，注意乱码问题
        request.setCharacterEncoding("UTF-8");
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        //连接数据库执行 insert 语句
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            // 自动提交关闭
            conn.setAutoCommit(false);
            // 获取预编译的命令对象
            String sql = "update dept set dname = ? , loc = ? where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dname);
            ps.setString(2, loc);
            ps.setString(3, deptno);
            // 返回值是删除了数据库中的多少条记录
            count = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, null);
        }
        //保存成功跳转到列表页面
        //保存失败跳转到错误页面
        //判断删除成功或者失败的处理
        if (count == 1) {
            //删除成功，仍然跳转部门列表页面，部门列表页面在另一个servlet中，需要转发
            //request.getRequestDispatcher("/dept/list").forward(request, response);
            response.sendRedirect(request.getContextPath()+"/dept/list");
        } else {
            // 删除失败
            //request.getRequestDispatcher("/error.html").forward(request, response);
            response.sendRedirect(request.getContextPath()+"/error.html");

        }

    }
}
