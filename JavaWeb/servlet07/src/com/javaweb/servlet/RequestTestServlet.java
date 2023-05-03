package com.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ author Egcoo
 * @ date 2023/2/17 - 17:00
 * 总结：request接口中四个非常重要的方法
 *  Map<String,String[]> parameterMap = request.getParameterMap();
 *  Enumeration<String> names = request.getParameterNames();
 *  String[] values = request.getParameterValues();
 *  String value = request.getParameter("name");
 */
public class RequestTestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*response.setContentType("text/html,charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>Welcome to the new world</h1>");
        */
        //    面向接口编程，HttpServletRequest 接口
        //    获取前端提交的数据
        //    前端会提交什么数据呢？以键值对的形式提交
        //    数据会被tomcat封装进request对象里去
        // 获取map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 遍历map集合（获取map里所有的key，遍历）
        Set<String> keys = parameterMap.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            //System.out.println(key);
            String[] values = parameterMap.get(key);

            //System.out.println(key + "=" + values);
            for (String value : values) {
                System.out.println(value + ",");
            }
            //换行
            System.out.println();

            // 直接通过getParameterNames() 这个方法，可以直接获取这个Map集合里所有的key
            Enumeration<String> names = request.getHeaderNames();
            while (names.hasMoreElements()){
                String name = names.nextElement();
                System.out.println(name);
            }


        }
    }

}

