package com.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @ author Egcoo
 * @ date 2022/11/3 - 21:50
 */
public class JDBCUtils_Use {

    public static void testSelect() {

        //1.得到连接
        Connection connection = null;
        // 2.组织一个sql
        String sql = "select *  表 ";
        PreparedStatement preparedStatement = null;
        ResultSet set;

        // 3.创建 PrepareStatement 对象
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //执行, 得到结果集
            set = preparedStatement.executeQuery();

            //遍历该结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            // 关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }


    public static void testDML() {

        //1.得到连接
        Connection connection = null;
        // 2.组织一个sql
        String sql = "update actor set name = ? where id = ?";
        PreparedStatement preparedStatement = null;

        // 3.创建 PrepareStatement 对象
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            // 给占位符赋值
            preparedStatement.setString(1, "周星驰");
            preparedStatement.setInt(2, 4);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            // 关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
