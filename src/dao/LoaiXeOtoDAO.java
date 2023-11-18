package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import model.LoaiXeOto;

public class LoaiXeOtoDAO implements DAOInterface<LoaiXeOto> {

    public static LoaiXeOtoDAO getInstance() {
        return new LoaiXeOtoDAO();
    }

    @Override
    public int insert(LoaiXeOto t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            String sql = "INSERT INTO LoaiXeOto (MaLoaiXe, HangXe, DongXe, NamSanXuat) "
                + "VALUES (?,?,?,?)";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaLoaiXe());
            pst.setString(2, t.getHangXe());
            pst.setString(3, t.getDongXe());
            pst.setString(4, t.getNamSanXuat());

            System.out.println("You executed this query: " + sql);
            check = pst.executeUpdate();
            System.out.println("Affected rows: " + check);

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int update(LoaiXeOto t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            String sql = "UPDATE LoaiXeOto "
                + "SET "
                + "MaLoaiXe = ?, "
                + "HangXe = ?, "
                + "DongXe = ?, "
                + "NamSanXuat = ? "
                + "WHERE MaLoaiXe = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaLoaiXe());
            pst.setString(2, t.getHangXe());
            pst.setString(3, t.getDongXe());
            pst.setString(4, t.getNamSanXuat());
            pst.setString(5, t.getMaLoaiXe());

            System.out.println("You executed this query: " + sql);
            check = pst.executeUpdate();
            System.out.println("Affected rows: " + check);

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int delete(LoaiXeOto t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            String sql = "DELETE FROM LoaiXeOto "
                + "WHERE MaLoaiXe = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaLoaiXe());

            System.out.println("You executed this query: " + sql);
            check = pst.executeUpdate();
            System.out.println("Affected rows: " + check);

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public ArrayList<LoaiXeOto> selectAll() {
        ArrayList<LoaiXeOto> loaiXeOtos = new ArrayList<LoaiXeOto>();
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");
            
            String sql = "SELECT * FROM LoaiXeOto";

            PreparedStatement pst = connection.prepareStatement(sql);

            System.out.println("You executed this query: " + sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaLoaiXe = rs.getString("MaLoaiXe");
                String HangXe = rs.getString("HangXe");
                String DongXe = rs.getString("DongXe");
                String NamSanXuat = rs.getString("NamSanXuat");

                LoaiXeOto loaiXeOto = new LoaiXeOto(MaLoaiXe, HangXe, DongXe, NamSanXuat);
                loaiXeOtos.add(loaiXeOto);
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return loaiXeOtos;
    }

    @Override
    public ArrayList<LoaiXeOto> selectById(LoaiXeOto t) {
        ArrayList<LoaiXeOto> loaiXeOtos = new ArrayList<LoaiXeOto>();
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            String sql = "SELECT * FROM LoaiXeOto "
                + "WHERE MaLoaiXe = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaLoaiXe());

            System.out.println("You executed this query: " + sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                String MaLoaiXe = rs.getString("MaLoaiXe");
                String HangXe = rs.getString("HangXe");
                String DongXe = rs.getString("DongXe");
                String NamSanXuat = rs.getString("NamSanXuat");
                
                LoaiXeOto loaiXeOto = new LoaiXeOto(MaLoaiXe, HangXe, DongXe, NamSanXuat);
                loaiXeOtos.add(loaiXeOto);
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return loaiXeOtos;
    }

    @Override
    public ArrayList<LoaiXeOto> selectByCondition(String condition) {
        ArrayList<LoaiXeOto> loaiXeOtos = new ArrayList<LoaiXeOto>();
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            String sql = "SELECT * FROM LoaiXeOto "
                + "WHERE " + condition + ";";

            PreparedStatement pst = connection.prepareStatement(sql);

            System.out.println("You executed this query: " + sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                String MaLoaiXe = rs.getString("MaLoaiXe");
                String HangXe = rs.getString("HangXe");
                String DongXe = rs.getString("DongXe");
                String NamSanXuat = rs.getString("NamSanXuat");
                
                LoaiXeOto loaiXeOto = new LoaiXeOto(MaLoaiXe, HangXe, DongXe, NamSanXuat);
                loaiXeOtos.add(loaiXeOto);
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return loaiXeOtos;
    }
    
}
