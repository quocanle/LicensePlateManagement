package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import model.CongAn;

public class CongAnDAO implements DAOInterface<CongAn> {

    @Override
    public int insert(CongAn t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");
            
            String sql = "INSERT INTO CongAn (MaCongAn, Ho, Ten, GioiTinh, NgaySinh, SoDT, DiaChi, CapBac, MaDonVi, Password) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaCongAn());
            pst.setString(2, t.getHo());
            pst.setString(3, t.getTen());
            pst.setString(4, t.getGioiTinh());
            pst.setDate(5, t.getNgaySinh());
            pst.setString(6, t.getSoDT());
            pst.setString(7, t.getDiaChi());
            pst.setString(8, t.getCapBac());
            pst.setString(9, t.getMaDonVi());
            pst.setString(10, t.getPassword());

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
    public int update(CongAn t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");
            
            String sql = "UPDATE CongAn "
                + "SET "
                + "MaCongAn = ?, "
                + "Ho = ?, "
                + "Ten = ?, "
                + "GioiTinh = ?, "
                + "NgaySinh = ?, "
                + "SoDT = ?, "
                + "DiaChi = ?, "
                + "CapBac = ?, "
                + "MaDonVi = ?, "
                + "Password = ? "
                + "WHERE MaCongAn = ?";
            
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaCongAn());
            pst.setString(2, t.getHo());
            pst.setString(3, t.getTen());
            pst.setString(4, t.getGioiTinh());
            pst.setDate(5, t.getNgaySinh());
            pst.setString(6, t.getSoDT());
            pst.setString(7, t.getDiaChi());
            pst.setString(8, t.getCapBac());
            pst.setString(9, t.getMaDonVi());
            pst.setString(10, t.getPassword());
            pst.setString(11, t.getMaCongAn());

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
    public int delete(CongAn t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");
            
            String sql = "DELETE FROM CongAn "
                + "WHERE MaCongAn = ?";
            
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaCongAn());

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
    public ArrayList<CongAn> selectAll() {
        ArrayList<CongAn> congAns = new ArrayList<CongAn>();
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");
            
            String sql = "SELECT * FROM CongAn;";
            
            PreparedStatement pst = connection.prepareStatement(sql);

            System.out.println("You executed this query: " + sql);
            
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaCongAn = rs.getString("MaCongAn");
                String Ho = rs.getString("Ho");
                String Ten = rs.getString("Ten");
                String GioiTinh = rs.getString("GioiTinh");
                String NgaySinh = rs.getString("NgaySinh");
                String SoDT = rs.getString("SoDT");
                String DiaChi = rs.getString("DiaChi");
                String CapBac = rs.getString("CapBac");
                String MaDonVi = rs.getString("MaDonVi");
                String Password = rs.getString("Password");
                congAns.add(new CongAn(MaCongAn, Ho, Ten, GioiTinh, NgaySinh, SoDT, DiaChi, CapBac, MaDonVi, Password));
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return congAns;
    }

    @Override
    public ArrayList<CongAn> selectById(CongAn t) {
        ArrayList<CongAn> congAns = new ArrayList<CongAn>();
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");
            
            String sql = "SELECT * FROM CongAn "
                + "WHERE MaCongAn = ? ;";
            
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaCongAn());

            System.out.println("You executed this query: " + sql);
            
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaCongAn = rs.getString("MaCongAn");
                String Ho = rs.getString("Ho");
                String Ten = rs.getString("Ten");
                String GioiTinh = rs.getString("GioiTinh");
                String NgaySinh = rs.getString("NgaySinh");
                String SoDT = rs.getString("SoDT");
                String DiaChi = rs.getString("DiaChi");
                String CapBac = rs.getString("CapBac");
                String MaDonVi = rs.getString("MaDonVi");
                String Password = rs.getString("Password");
                congAns.add(new CongAn(MaCongAn, Ho, Ten, GioiTinh, NgaySinh, SoDT, DiaChi, CapBac, MaDonVi, Password));
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return congAns;
    }

    @Override
    public ArrayList<CongAn> selectByCondition(String condition) {
        ArrayList<CongAn> congAns = new ArrayList<CongAn>();
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");
            
            String sql = "SELECT * FROM CongAn "
                + "WHERE " + condition + ";";
            
            PreparedStatement pst = connection.prepareStatement(sql);

            System.out.println("You executed this query: " + sql);
            
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaCongAn = rs.getString("MaCongAn");
                String Ho = rs.getString("Ho");
                String Ten = rs.getString("Ten");
                String GioiTinh = rs.getString("GioiTinh");
                String NgaySinh = rs.getString("NgaySinh");
                String SoDT = rs.getString("SoDT");
                String DiaChi = rs.getString("DiaChi");
                String CapBac = rs.getString("CapBac");
                String MaDonVi = rs.getString("MaDonVi");
                String Password = rs.getString("Password");
                congAns.add(new CongAn(MaCongAn, Ho, Ten, GioiTinh, NgaySinh, SoDT, DiaChi, CapBac, MaDonVi, Password));
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return congAns;
    }
    
}
