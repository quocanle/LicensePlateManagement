package test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import database.JDBCUtil;

public class testInsert {
    public static void main(String[] args) {
        Connection connection = JDBCUtil.getConnection("MSSQL");

        JDBCUtil.printInfo(connection);

        Statement st = null;
        try {
            st = connection.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String sql = "INSERT INTO LoaiXeOto (MaLoaiXe, HangXe, DongXe, NamSanXuat)"
            + "VALUES"
            + "('LX001', 'Toyota', 'Vios', '2021'),"
            + "('LX002', 'Honda', 'Civic', '2020'),"
            + "('LX003', 'Ford', 'Ranger', '2019'),"
            + "('LX004', 'Hyundai', 'Accent', '2018'),"
            + "('LX005', 'Mazda', 'CX-5', '2017');";

        int check = 0;
        try {
            check = st.executeUpdate(sql);
            System.out.println("Affect row: " + check);
            if (check > 0) {
                System.out.println("Add data successfully");
            } else {
                System.out.println("Add data fail");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JDBCUtil.closeConnection(connection);
    }
}
