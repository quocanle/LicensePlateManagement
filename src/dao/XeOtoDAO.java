package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.XeOto;

public class XeOtoDAO implements DAOInterface<XeOto>{

    public static XeOtoDAO getInstance() {
        return new XeOtoDAO();
    }

    @Override
    public int insert(XeOto t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            String sql = "INSERT INTO XeOto (SoKhung, SoMay, MaLoaiXe, MauXe, ChuXeCCCD) "
            + "VALUES (?,?,?,?,?)";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getSoKhung());
            pst.setString(2, t.getSoMay());
            pst.setString(3, t.getMaLoaiXe());
            pst.setString(4, t.getMauXe());
            pst.setString(5, t.getChuXeCCCD());

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
    public int update(XeOto t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            String sql = "UPDATE XeOto "
            + "SET "
            + "SoKhung = ?, "
            + "SoMay = ?, "
            + "MaLoaiXe = ?, "
            + "MauXe = ?, "
            + "ChuXeCCCD = ? "
            + "WHERE SoKhung = ? "
            + "AND SoMay = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getSoKhung());
            pst.setString(2, t.getSoMay());
            pst.setString(3, t.getMaLoaiXe());
            pst.setString(4, t.getMauXe());
            pst.setString(5, t.getChuXeCCCD());
            pst.setString(6, t.getSoKhung());
            pst.setString(7, t.getSoMay());

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
    public int delete(XeOto t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            String sql = "DELETE FROM XeOto "
            + "WHERE SoKhung = ? "
            + "AND SoMay = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getSoKhung());
            pst.setString(2, t.getSoMay());

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
    public ArrayList<XeOto> selectAll() {
        ArrayList<XeOto> xeOtos = new ArrayList<XeOto>();

        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");
            
            String sql = "SELECT * FROM XeOto;";

            PreparedStatement pst = connection.prepareStatement(sql);

            System.out.println("You executed this query: " + sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String SoKhung = rs.getString("SoKhung");
                String SoMay = rs.getString("SoMay");
                String MaLoaiXe = rs.getString("MaLoaiXe");
                String MauXe = rs.getString("MauXe");
                String ChuXeCCCD = rs.getString("ChuXeCCCD");

                XeOto xeOto = new XeOto(SoKhung, SoMay, MaLoaiXe, MauXe, ChuXeCCCD);
                xeOtos.add(xeOto);
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return xeOtos;
    }

    @Override
    public ArrayList<XeOto> selectById(XeOto t) {
        ArrayList<XeOto> xeOtos = new ArrayList<XeOto>();

        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            String sql = "SELECT * FROM XeOto "
            + "WHERE SoKhung = ? "
            + "AND SoMay = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getSoKhung());
            pst.setString(2, t.getSoMay());

            System.out.println("You executed this query: " + sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String SoKhung = rs.getString("SoKhung");
                String SoMay = rs.getString("SoMay");
                String MaLoaiXe = rs.getString("MaLoaiXe");
                String MauXe = rs.getString("MauXe");
                String ChuXeCCCD = rs.getString("ChuXeCCCD");

                XeOto xeOto = new XeOto(SoKhung, SoMay, MaLoaiXe, MauXe, ChuXeCCCD);
                xeOtos.add(xeOto);
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return xeOtos;
    }

    @Override
    public ArrayList<XeOto> selectByCondition(String condition) {
        ArrayList<XeOto> xeOtos = new ArrayList<XeOto>();

        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            String sql = "SELECT * FROM XeOto "
            + "WHERE " + condition + ";";

            PreparedStatement pst = connection.prepareStatement(sql);

            System.out.println("You executed this query: " + sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String SoKhung = rs.getString("SoKhung");
                String SoMay = rs.getString("SoMay");
                String MaLoaiXe = rs.getString("MaLoaiXe");
                String MauXe = rs.getString("MauXe");
                String ChuXeCCCD = rs.getString("ChuXeCCCD");

                XeOto xeOto = new XeOto(SoKhung, SoMay, MaLoaiXe, MauXe, ChuXeCCCD);
                xeOtos.add(xeOto);
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return xeOtos;
    }
    
}
