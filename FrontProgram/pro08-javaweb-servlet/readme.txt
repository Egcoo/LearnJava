1.设置编码
    tomcat8之前，设置编码：1）get请求方式：

    get方式目前不需要设置编码（基于tomcat8）

    如果是get请求发送的中文数据，转码稍微有点麻烦（tomcat8之前）String fname = request.getParameter("fname");

    1．将字符串打散成字节数组
    byte[] bytes = fname.getBytes("ISO-8859-1");
    2．将字节数组按照设定的编码重新组装成字符串
    fname = new String(bytes,"UTF-8") ;

    2）post请求方式：
    request.setCharacterEncoding("UTF-8"); tomcat8开始，设置编码，只需要针对post方式
    request.setCharacterEncoding("UTF-8");

    注意：
    需要注意的是，设置编码这一句代码必须在所有的获取参数动作之前

2.servlet 的继承关系
3.servlet 的生命周期
4.