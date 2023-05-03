package com.oa.web.action;

import com.oa.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ author Egcoo
 * @ date 2023/3/11 - 20:56
 * <p>
 * 使用模板方法设计模式改造 deptServlet
 * jsp: 基于java语言实现的的服务器端的页面, 是一个翻译引擎
 * EL表达式：存在的目的是为了优化 jsp代码，EL表达式能做的只有取数据和输出
 * EL表达式中输出的变量底层调用的是javabean的get方法
 * 1.对空对象会进行预处理，不会出现相应异常
 * <p>
 * session
 * 1.session 对象是存储在服务器端的。
 * 2.session对象对应一个会话
 * 3.一次会话包含多次请求
 * 4.session 如何获取？
 * HttpSession session = request.getSession();
 * 从服务器中获取当前的session对象
 * 如果没有获取到任何session对象，则新建
 * <p>
 * 过滤器：责任链设计模式：动态的组合程序的调用顺序
 * OCP原则：对扩展开放，对修改关闭。
 *
 * <p>
 * HttpSession session = request.getSession(false);
 * 从服务器中获取当前的session对象
 * 如果没有获取到任何session对象，则不会新建，返回一个null
 *
 * 不使用MVC架构模式的问题？
 *  缺点1> 代码的复用性太低。
 *  导致缺点1的原因> 因为没有进行“职能分工”，没有独立组件的概念，所以没有办法进行代码复用
 *  缺点2> 耦合度高，导致代码很难扩展
 *  缺点3> 操作数据库的代码和业务逻辑混杂在一起，很容易出错，编写代码无法专注在业务逻辑的扩展
 *
 *
 *  1.什么是DAO？ Data Access Object （数据访问对象）
 *  2. DAO 实际上是一种设计模式，属于JavaEE 的设计模式之一（不是23种设计模式）
 *  3. DAO 只负责数据库表的增删改查，没有任何的业务逻辑
 *  4. 没有任何的业务逻辑，只是负责表中数据增删改查的对象，有一个特殊称谓：DAO对象
 *  5. 为什么叫做AccountDao 呢？
 *      这是因为这个DAO是专门处理t_act这张表的。
 *      如果处理t_user表的话，可以叫做UserDao
 *      如果处理t_student 表的话，可以叫做StudentDao
*   6.一般情况下，一张表会对应一个DAO对象
 *
 */
//模糊匹配
//@WebServlet("/dept/*")
@WebServlet({"/dept/list", "/dept/save", "/dept/edit", "/dept/detail", "/dept/modify", "/dept/delete"})
public class DeptServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //这个session 是不需要新建的
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            //获取servlet path
            String servletPath = request.getServletPath();
            if ("/dept/list".equals(servletPath)) {
                doList(request, response);
            } else if ("/dept/save".equals(servletPath)) {
                doSave(request, response);
            } else if ("/dept/edit".equals(servletPath)) {
                doEdit(request, response);
            } else if ("/dept/detail".equals(servletPath)) {
                doDetail(request, response);
            } else if ("/dept/modify".equals(servletPath)) {
                doModify(request, response);
            } else if ("/dept/delete".equals(servletPath)) {
                doDel(request, response);
            }
        } else {
            response.sendRedirect(request.getContextPath());
        }

    }

    private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        out.println("        document.location.href = '" + contextPath + "/dept/delete?deptno='+deptno");
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
                out.println("       <td>" + (++i) + "</td>");
                out.println("       <td>" + deptno + "</td>");
                out.println("       <td>" + dname + "</td>");
                out.println("       <td>");
                out.println("            <a href='javascript:void(0)' onclick='del(" + deptno + ")'>删除</a>");
                out.println("            <a href='" + contextPath + "/dept/edit?deptno=" + deptno + "''>修改</a>");
                out.println("            <a href='" + contextPath + "/dept/detail?deptno=" + deptno + "'>详情</a>");
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
        out.println("   <a href='" + contextPath + "/add.html'>新增部门</a>");
        out.println("</body>");
        out.println("</html>");


    }

    private void doSave(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
            response.sendRedirect(request.getContextPath() + "/dept/list");
        } else {
            // 删除失败
            //request.getRequestDispatcher("/error.html").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/error.html");

        }

    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        out.println("<form action='" + contextPath + "/dept/modify' method='post'>");

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
                out.println("                部门编号<input type='text' name='deptno' value='" + deptno + "' readonly/> <br>");
                out.println("                部门名称<input type='text' name='dname' value='" + dname + "'/> <br>");
                out.println("                部门位置<input type='text' name='loc' value='" + loc + "'/> <br>");
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

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

                out.println("部门编号：" + deptno + " <br>");
                out.println("部门名称：" + dname + " <br>");
                out.println("部门地址：" + loc + " <br>");
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

    private void doModify(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
            response.sendRedirect(request.getContextPath() + "/dept/list");
        } else {
            // 删除失败
            //request.getRequestDispatcher("/error.html").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/error.html");

        }

    }

    private void doDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            request.getRequestDispatcher("/error.html").forward(request, response);
            ;
        }
    }


}
