package test;

import java.sql.Connection;

import database.JDBCUtil;

public class testJDBC {
    public static void main(String[] args) {
        Connection connection = JDBCUtil.getConnection("MSSQL");
        System.out.println(connection);

        JDBCUtil.printInfo(connection);

    }
}
