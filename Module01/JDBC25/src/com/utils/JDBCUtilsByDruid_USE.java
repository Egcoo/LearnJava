package com.utils;

import com.Datasource05.Actor;
import org.junit.jupiter.api.Test;
import java.sql.*;
import java.util.ArrayList;

/**
 * @ author Egcoo
 * @ date 2022/11/6 - 14:30
 */
public class JDBCUtilsByDruid_USE {

    @Test
    public void testSelectToArrayList() {
        System.out.println("使用 druid 方式完成");
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个 sql
        // 这里是你连接数据库操作的地方
        String sql = "select * from actor where id >= ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;

        ArrayList<Actor> list = new ArrayList<>();//创建 ArrayList 对象,存放 actor 对
        //3. 创建 PreparedStatement 对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass());//运行类型 com.alibaba.druid.pool.DruidPooledConnection
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);//给?号赋值
            //执行, 得到结果集
            set = preparedStatement.executeQuery();
            //遍历该结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");//getName()
                String sex = set.getString("sex");//getSex()
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");

                //把得到的 resultset 的记录，封装到 Actor 对象，放入到 list 集合
                list.add(new Actor(id, name, sex, borndate, phone));

                System.out.println("list 集合数据=" + list);
//                for(Actor actor : list) {
//                    System.out.println("id=" + actor.getId() + "\t" + actor.getName());
//                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }
    }


    @Test
    public void testSelect() {
        System.out.println("使用 druid 方式完成");
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个 sql
        // 这里是你连接数据库操作的地方
        String sql = "select * from actor where id >= ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        //3. 创建 PreparedStatement 对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass());//运行类型 com.alibaba.druid.pool.DruidPooledConnection
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);//给?号赋值
            //执行, 得到结果集
            set = preparedStatement.executeQuery();
            //遍历该结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");//getName()
                String sex = set.getString("sex");//getSex()
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }
    }
}
