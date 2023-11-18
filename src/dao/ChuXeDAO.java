package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

            String sql = "INSERT INTO ChuXe (CCCD, Ho, Ten, GioiTinh, NgaySinh, SoDT, DiaChi)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getCCCD());
            pst.setString(2, t.getHo());
            pst.setString(3, t.getTen());
            pst.setString(4, t.getGioiTinh());
            pst.setDate(5, t.getNgaySinh());
            pst.setString(6, t.getSoDT());
            pst.setString(7, t.getDiaChi());

            System.out.println("You executed this query: " + sql);
            check = pst.executeUpdate();
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

            String sql = "UPDATE ChuXe "
                + "SET "
                + "CCCD = ?, "
                + "Ho = ?, "
                + "Ten = ?, "
                + "GioiTinh = ?, "
                + "NgaySinh = ?, "
                + "SoDT = ?, "
                + "DiaChi = ? "
                + "WHERE CCCD = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getCCCD());
            pst.setString(2, t.getHo());
            pst.setString(3, t.getTen());
            pst.setString(4, t.getGioiTinh());
            pst.setDate(5, t.getNgaySinh());
            pst.setString(6, t.getSoDT());
            pst.setString(7, t.getDiaChi());
            pst.setString(8, t.getCCCD());

            System.out.println("You executed this query: " + sql);
            check = pst.executeUpdate();
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

            String sql = "DELETE FROM ChuXe "
                + "WHERE CCCD = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getCCCD());

            System.out.println("You executed this query: " + sql);
            check = pst.executeUpdate();
            System.out.println("Affected row: " + check);

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public ArrayList<ChuXe> selectAll() {
        ArrayList<ChuXe> chuXeList = new ArrayList<ChuXe>();
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            String sql = "SELECT * FROM ChuXe;";

            PreparedStatement pst = connection.prepareStatement(sql);

            System.out.println("You executed this query: " + sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String CCCD = rs.getString("CCCD");
                String Ho = rs.getString("Ho");
                String Ten = rs.getString("Ten");
                String GioiTinh = rs.getString("GioiTinh");
                String NgaySinh = rs.getString("NgaySinh");
                String SoDT = rs.getString("SoDT");
                String DiaChi = rs.getString("DiaChi");
                ChuXe chuXe = new ChuXe(CCCD, Ho, Ten, GioiTinh, NgaySinh, SoDT, DiaChi);
                chuXeList.add(chuXe);
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return chuXeList;
    }

    @Override
    public ArrayList<ChuXe> selectById(ChuXe t) {
        ArrayList<ChuXe> chuXeList = new ArrayList<ChuXe>();
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            String sql = "SELECT * FROM ChuXe "
                + "WHERE CCCD = ?;";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getCCCD());

            System.out.println("You executed this query: " + sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String CCCD = rs.getString("CCCD");
                String Ho = rs.getString("Ho");
                String Ten = rs.getString("Ten");
                String GioiTinh = rs.getString("GioiTinh");
                String NgaySinh = rs.getString("NgaySinh");
                String SoDT = rs.getString("SoDT");
                String DiaChi = rs.getString("DiaChi");
                ChuXe chuXe = new ChuXe(CCCD, Ho, Ten, GioiTinh, NgaySinh, SoDT, DiaChi);
                chuXeList.add(chuXe);
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return chuXeList;
    }

    @Override
    public ArrayList<ChuXe> selectByCondition(String condition) {
        ArrayList<ChuXe> chuXeList = new ArrayList<ChuXe>();
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            String sql = "SELECT * FROM ChuXe "
                + "WHERE " + condition + ";";

            PreparedStatement pst = connection.prepareStatement(sql);

            System.out.println("You executed this query: " + sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String CCCD = rs.getString("CCCD");
                String Ho = rs.getString("Ho");
                String Ten = rs.getString("Ten");
                String GioiTinh = rs.getString("GioiTinh");
                String NgaySinh = rs.getString("NgaySinh");
                String SoDT = rs.getString("SoDT");
                String DiaChi = rs.getString("DiaChi");
                ChuXe chuXe = new ChuXe(CCCD, Ho, Ten, GioiTinh, NgaySinh, SoDT, DiaChi);
                chuXeList.add(chuXe);
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return chuXeList;
    }
    
}
