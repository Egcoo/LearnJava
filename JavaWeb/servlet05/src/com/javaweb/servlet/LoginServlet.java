package com.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ author Egcoo
 * @ date 2023/2/16 - 13:44
 * servlet 的最终开发步骤
 * 1.编写一个servlet类，直接继承HttpServlet
 * 2.重写doGet方法或者重写doPost方法，到底重写谁，javaWeb程序员说了算
 * 3.将servlet类配置到web.xml文件当中
 * 4.准备前端页面（form表单），form表单中指定请求路径即可。
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>Login...success</h1>");

    }
}
