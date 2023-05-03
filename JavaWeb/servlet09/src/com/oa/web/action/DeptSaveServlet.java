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
 * @ date 2023/3/7 - 13:23
 */
public class DeptSaveServlet extends HttpServlet {

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
            String sql = "insert into dept values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            ps.setString(2, dname);
            ps.setString(3, loc);
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

            /* 最后保存成功以后，转发到/dept/list 的时候，会出现405 为什么
            1.保存用到的是post请求，底层要执行dopost方法
            2.转发是一次请求，之前是post，之后还是post，因为它是一次请求
            3./dept/list  Servlet当中只有一个doGet方法
            怎么解决？
            1.在/dept/list  中添加doPost方法，然后在其中调用doGet
            这里非常重要，这里的请求依旧是post请求，转到list以后是list是get请求，无法对应
            */
            //request.getRequestDispatcher("/dept/list").forward(request, response);

            //这里最好使用重定向，（向浏览器发送一次新的请求）
            // 浏览器在地址栏上发送请求 属于get请求
            // 跳转的资源只要
            response.sendRedirect(request.getContextPath()+"/dept/list");
        } else {
            // 删除失败
            //request.getRequestDispatcher("/error.html").forward(request, response);
            response.sendRedirect(request.getContextPath()+"/error.html");

        }

    }
}
