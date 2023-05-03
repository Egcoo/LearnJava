package servlets;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

/**
 * @ author Egcoo
 * @ date 2023/1/21 - 9:49
 *
 * 通过连接池可以证明两点
 * 1. 被close的链接对象没有真正关闭，而是将状态重新设置为空闲状态，然后放回池子，这样下次获取链接对象，这个也更方便
 * 2. 没有close的链接对象会被一直占用，那么下次继续获取链接对象，是不会获取这个对象的（hashcode没有重复）
 */
public class Demo03Druid {
    public static void main(String[] args) {

        DataSource dataSource = new DruidDataSource();
    }
}
