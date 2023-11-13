package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.ChuXe;

public class ChuXeDAO implements DAOInterface<ChuXe> {

    public static ChuXeDAO getInstance() {
        return new ChuXeDAO();
    }

    @Override
    public int insert(ChuXe t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            Statement st = connection.createStatement();

            String sql = "INSERT INTO ChuXe (CCCD, Ho, Ten, NgaySinh, SoDT, DiaChi)"
                + "VALUES"
                + "('" + t.getCCCD() + "', '" + t.getHo() + "', '" + t.getTen() + "', '" + t.getNgaySinh() + "', '" + t.getSoDT() + "', '" + t.getDiaChi() + "');";
            
            System.out.println("You executed this query: " + sql);
            check = st.executeUpdate(sql);
            System.out.println("Affected row: " + check);

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int update(ChuXe t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            Statement st = connection.createStatement();

            String sql = "UPDATE ChuXe SET "
                + "Ho = '" + t.getHo() + "', "
                + "Ten = '" + t.getTen() + "', "
                + "NgaySinh = '" + t.getNgaySinh() + "', "
                + "SoDT = '" + t.getSoDT() + "', "
                + "DiaChi = '" + t.getDiaChi() + "' "
                + "WHERE CCCD = '" + t.getCCCD() + "';";

            System.out.println("You executed this query: " + sql);
            check = st.executeUpdate(sql);
            System.out.println("Affected row: " + check);

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int delete(ChuXe t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            Statement st = connection.createStatement();

            String sql = "DELETE FROM ChuXe "
                + "WHERE CCCD = '" + t.getCCCD() + "';";

            System.out.println("You executed this query: " + sql);
            check = st.executeUpdate(sql);
            System.out.println("Affected row: " + check);

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int select(ChuXe t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'select'");
    }

    @Override
    public ArrayList<ChuXe> selectAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectAll'");
    }

    @Override
    public ArrayList<ChuXe> selectById(ChuXe t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }

    @Override
    public ArrayList<ChuXe> selectByCondition(String condition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectByCondition'");
    }
    
}
