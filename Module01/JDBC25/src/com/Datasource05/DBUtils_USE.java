package com.Datasource05;

import com.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ author Egcoo
 * @ date 2022/11/9 - 13:27
 */
public class DBUtils_USE {

    //使用 apache-DBUtils 工具类 + druid 完成对表的 crud 操作
    @Test
    public void testQueryMany() throws SQLException { //返回结果是多行的情况
        //1. 得到 连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. 使用 DBUtils 类和接口 , 先引入 DBUtils 相关的 jar , 加入到本 Project
        //3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4. 就可以执行相关的方法，返回 ArrayList 结果集
        //String sql = "select * from actor where id >= ?";
        // 注意: sql 语句也可以查询部分列
        String sql = "select id, name from actor where id >= ?";
        // 老韩解读
        //(1) query 方法就是执行 sql 语句，得到 resultset ---封装到 --> ArrayList 集合
        //(2) 返回集合
        //(3) connection: 连接
        //(4) sql : 执行的 sql 语句
        //(5) new BeanListHandler<>(Actor.class): 在将 resultset -> Actor 对象 -> 封装到 ArrayList
        // 底层使用反射机制 去获取 Actor 类的属性，然后进行封装
        //(6) 1 就是给 sql 语句中的? 赋值，可以有多个值，因为是可变参数 Object...

        List<Actor> list =
                queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
        System.out.println("输出集合的信息");
        for (Actor actor : list) {
            System.out.print(actor);
        }

        //释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }


    //演示 apache-dbutils + druid 完成 返回的结果是单行记录(单个对象)
    @Test
    public void testQuerySingle() throws SQLException {
        //1. 得到 连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. 使用 DBUtils 类和接口 , 先引入 DBUtils 相关的 jar , 加入到本 Project
        //3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4. 就可以执行相关的方法，返回单个对象
        String sql = "select * from actor where id = ?";
        // 老韩解读
        // 因为我们返回的单行记录<--->单个对象 , 使用的 Hander 是 BeanHandler
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 10);
        System.out.println(actor);
        // 释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    //演示 apache-dbutils + druid 完成查询结果是单行单列-返回的就是 object
    @Test
    public void testScalar() throws SQLException {
        //1. 得到 连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. 使用 DBUtils 类和接口 , 先引入 DBUtils 相关的 jar , 加入到本 Project
        //3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4. 就可以执行相关的方法，返回单行单列 , 返回的就是 Object
        String sql = "select name from actor where id = ?";
        //老师解读： 因为返回的是一个对象, 使用的 handler 就是 ScalarHandler
        Object obj = queryRunner.query(connection, sql, new ScalarHandler(), 4);
        System.out.println(obj);
        // 释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

}
