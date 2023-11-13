/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;

/**
 *
 * @author lequo
 */
public class JDBCUtil {

    public static Connection getConnection() {
        Connection c = null;

        c = getConnectionMSSQL();

        return c;
    }
    
    public static Connection getConnection(String s) {
        Connection c = null;

        if (s.equalsIgnoreCase("MSSQL")) {
            c = getConnectionMSSQL();
        }
        else if (s.equalsIgnoreCase("MYSQL")) {
            c = getConnectionMYSQL();
        }
        
        return c;
    }

    public static Connection getConnectionMSSQL() {
        Connection c = null;
        try {
            // String connectionUrl =
            //     "jdbc:sqlserver://localhost\\MAY1:1433;"
            //             + "database=dbLicensePlateManagement;"
            //             + "user=adminLicense;"
            //             + "password=123;"
            //             + "encrypt=false;"
            //             + "trustServerCertificate=true;"
            //             + "loginTimeout=30;";

            String connectionUrl =
                "jdbc:sqlserver://localhost\\MAY1:1433;"
                        + "database=dbLearnSQL;"
                        + "user=learnSQL;"
                        + "password=12345678;"
                        + "encrypt=false;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
            
            c = DriverManager.getConnection(connectionUrl);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }

    public static Connection getConnectionMYSQL() {
        Connection c = null;

        // String URL = "jdbc:mysql://5ll.h.filess.io:3307/dbLicensePlate_spirithair";
        // String USER = "dbLicensePlate_spirithair;
        // String PASSWORD = "1234";

        String URL = "jdbc:mysql://pcs.h.filess.io:3307/learnSQL_sangbroken";
        String USER = "learnSQL_sangbroken";
        String PASSWORD = "12345678";
        if (c == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                c = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return c;
    }

    public static void closeConnection(Connection c) {
        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printInfo(Connection c) {
        try {
            DatabaseMetaData dbmd = (DatabaseMetaData) c.getMetaData();
            System.out.println(dbmd.getDatabaseProductName());
            System.out.println(dbmd.getDatabaseProductVersion());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
