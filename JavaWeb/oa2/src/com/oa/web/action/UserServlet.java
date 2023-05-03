package com.oa.web.action;

import com.oa.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ author Egcoo
 * @ date 2023/3/20 - 19:45
 * Servlet 负责获得
 */
@WebServlet("/user/login")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证用户名和秘密是否正确
        //获取用户名和密码
        boolean success = false;
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //登录成功或失败
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            // 自动提交关闭
            conn.setAutoCommit(false);
            // 获取预编译的命令对象
            String sql = "select * from t_user where username = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                success = true;
            }
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
            DBUtil.close(conn, ps, rs);
        }
        if (success) {
            // 获取session对象(这里要求是 必须获取session，没有session也要获取新建一个)
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            response.sendRedirect(request.getContextPath() + "/dept/list");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.html");

        }

    }
}