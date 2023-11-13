package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBCUtil;

public class testDelete {
    public static void main(String[] args) {
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");
            
            Statement st = connection.createStatement();

            String sql = "DELETE FROM ChuXe;";

            int check = st.executeUpdate(sql);
            System.out.println("Affected row: " + check);

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
