package com.HCMS.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ author Egcoo
 * @ date 2022/11/22 - 17:03
 *
 *  这是一个测试文件
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        // 测试Utility 工具类
        System.out.println("请输入一个整数：");
        int i = Utility.readInt();
        System.out.println("i= " + i);

        // 测试 JDBCUtilsByDruid
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println(connection);

    }
}
