package com.oa.web.action;

import com.oa.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ author Egcoo
 * @ date 2023/2/26 - 11:24
 *
 * 4XX 全部都是前端的问题
 * 5XX基本上都是后端服务器的问题
 *
 * 数据库开启事务以后记得最后要提交
 */
public class DeptDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //根据部门编号，删除部门
        String deptno = request.getParameter("deptno");

        // 连接数据库删除数据
        // 而且删除数据的时候最好有事务的支持，保证数据删除安全
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            // 自动提交关闭
            conn.setAutoCommit(false);
            // 获取预编译的命令对象
            String sql = "delete from dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
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

        //判断删除成功或者失败的处理
        if (count == 1) {
            //删除成功，仍然跳转部门列表页面，部门列表页面在另一个servlet中，需要转发
            request.getRequestDispatcher("/dept/list").forward(request, response);
        } else {
            // 删除失败
            request.getRequestDispatcher("/error.html").forward(request, response);;
        }
    }


}
