package com.transation04;

import com.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ author Egcoo
 * @ date 2022/11/4 - 22:02
 */
public class Transaction_ {

    public void noTransaction() {
        // 没有使用事务
        // 1.得到链接
        Connection connection = null;

        // 2.组织一个sql
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;

        //3.创建 PrepareStatement 对象
        try {
            connection = JDBCUtils.getConnection();// 在默认情况下，connection 是默认自动提交的
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            int i = 1 / 0;
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }


    // 事务来解决
    public void useTransaction() {
        // 没有使用事务
        // 1.得到链接
        Connection connection = null;

        // 2.组织一个sql
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;

        //3.创建 PrepareStatement 对象
        try {
            connection = JDBCUtils.getConnection();// 在默认情况下，connection 是默认自动提交的
            //将 connection 设置为不自动提交
            connection.setAutoCommit(false); // 开启了事务
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); //执行第 1 条 sql

            int i = 1 / 0;
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

            // 这里提交事务

        } catch (SQLException e) {

            //这里我们可以进行回滚，即撤销执行的 SQL
            //默认回滚到事务开始的状态.
            System.out.println("执行发生了异常，撤销执行的sql");
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

}
