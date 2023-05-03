package com.javaweb.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ author Egcoo
 * @ date 2023/2/7 - 10:11
 */
public class AServlet implements Servlet {

    //无参构造方法
    public AServlet() {
    }

    // init被翻译为初始化
    // init方法只执行一次
    // 在AServlet 对象第一次创建以后执行
    // init方法通常是完成初始化操作的
    // init 方法在执行的时候AServlet 对象已经被创建出来了
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    //service方法，是处理用户请求的核心方法
    // 只要用户发送一次请求，service方法必然会执行一次
    // 发送100此请求，service就会执行100次
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    // destory 方法也是只执行一次
    // tomcat 服务器在销毁 AServlet对象以前会调用destory方法
    // destory 方法在执行的时候，对象的内存还没有被销毁，即将被销毁
    // destroy 方法种可以编写销毁前的准备
    // 比如说，服务器关闭的时候，AServlet对象开启了一些资源，这些资源可能是流，可能是数据库连接
    // 那么关闭服务器的时候，要关闭这些数据框连接，那么关闭资源的方法可以写到destroy方法中
    @Override
    public void destroy() {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

}
