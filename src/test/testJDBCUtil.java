/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.sql.Connection;
import database.JDBCUtil;

/**
 *
 * @author lequo
 */
public class testJDBCUtil {
    public static void main(String[] args) {
        Connection connection = JDBCUtil.getConnection("MSSQL");
        System.out.println(connection);
        
        JDBCUtil.printInfo(connection);
    }
}
