package dao;

import java.sql.Connection;
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
            Connection connection = JDBCUtil.getConnection();

            Statement st = connection.createStatement();

            String sql = "INSERT INTO XeOto (SoKhung, SoMay, MaLoaiXe, MauXe, ChuXeCCCD) "
            + "VALUES "
            + "('" + t.getSoKhung() + "', '" + t.getSoMay() + "', '" + t.getMaLoaiXe() + "', '" + t.getMauXe() + "', '" + t.getChuXeCCCD() + "')";

            System.out.println("You executed this query: " + sql);
            check = st.executeUpdate(sql);
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
            Connection connection = JDBCUtil.getConnection();

            Statement st = connection.createStatement();

            String sql = "UPDATE XeOto "
            + "SET "
            + "SoKhung = '" + t.getSoKhung() + "', "
            + "SoMay = '" + t.getSoMay() + "', "
            + "MaLoaiXe = '" + t.getMaLoaiXe() + "', "
            + "MauXe = '" + t.getMauXe() + "', "
            + "ChuXeCCCD = '" + t.getChuXeCCCD() + "' "
            + "WHERE SoKhung = '" + t.getSoKhung() + "'";

            System.out.println("You executed this query: " + sql);
            check = st.executeUpdate(sql);
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
            Connection connection = JDBCUtil.getConnection();

            Statement st = connection.createStatement();

            String sql = "DELETE FROM XeOto "
            + "WHERE "
            + "SoKhung = '" + t.getSoKhung() + "'"
            + "AND SoMay = '" + t.getSoMay() + "'";

            System.out.println("You executed this query: " + sql);
            check = st.executeUpdate(sql);
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
            Connection connection = JDBCUtil.getConnection();

            Statement st = connection.createStatement();

            String sql = "SELECT * FROM XeOto;";

            System.out.println("You executed this query: " + sql);

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String SoKhung = rs.getString("SoKhung");
                String SoMay = rs.getString("SoMay");
                String MaLoaiXe = rs.getString("MaLoaiXe");
                String MauXe = rs.getString("MauXe");
                String ChuXeCCCD = rs.getString("ChuXeCCCD");

                XeOto xeOto = new XeOto(SoKhung, SoMay, MaLoaiXe, MauXe, ChuXeCCCD);
                xeOtos.add(xeOto);
            }
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
            Connection connection = JDBCUtil.getConnection();

            Statement st = connection.createStatement();

            String sql = "SELECT * FROM XeOto "
            + "WHERE 'SoKhung' = '" + t.getSoKhung() + "'"
            + "AND 'SoMay' = '" + t.getSoMay() + "';";

            System.out.println("You executed this query: " + sql);

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String SoKhung = rs.getString("SoKhung");
                String SoMay = rs.getString("SoMay");
                String MaLoaiXe = rs.getString("MaLoaiXe");
                String MauXe = rs.getString("MauXe");
                String ChuXeCCCD = rs.getString("ChuXeCCCD");

                XeOto xeOto = new XeOto(SoKhung, SoMay, MaLoaiXe, MauXe, ChuXeCCCD);
                xeOtos.add(xeOto);
            }
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
            Connection connection = JDBCUtil.getConnection();

            Statement st = connection.createStatement();

            String sql = "SELECT * FROM XeOto "
            + "WHERE " + condition + ";" ;

            System.out.println("You executed this query: " + sql);

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String SoKhung = rs.getString("SoKhung");
                String SoMay = rs.getString("SoMay");
                String MaLoaiXe = rs.getString("MaLoaiXe");
                String MauXe = rs.getString("MauXe");
                String ChuXeCCCD = rs.getString("ChuXeCCCD");

                XeOto xeOto = new XeOto(SoKhung, SoMay, MaLoaiXe, MauXe, ChuXeCCCD);
                xeOtos.add(xeOto);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return xeOtos;
    }
    
}
