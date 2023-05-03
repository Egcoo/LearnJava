package com.Datasource05;

import com.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

/**
 * @ author Egcoo
 * @ date 2022/11/5 - 15:11
 */
public class ConQuestion {

    // 代码连接 5000 次 mysql

    @Test
    public void testCon(){

        // 看看关闭 connection 会耗费多久
        long start = System.currentTimeMillis();
        System.out.println("开始连接");

        Connection connection = null;
        for (int i = 0; i < 5000; i++) {
            // 使用传统方式连接 JDBC，得到连接
            connection = JDBCUtils.getConnection();
            //做一些工作，比如得到 PreparedStatement ，发送 sql
            //..........
            //关闭
            JDBCUtils.close(null, null, connection);
        }

        long end = System.currentTimeMillis();
        System.out.println("传统方式连接5000次耗时：" + (end - start));
    }
}
