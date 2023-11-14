package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            Connection connection = JDBCUtil.getConnection();

            Statement st = connection.createStatement();

            String sql = "INSERT INTO LoaiXeOto(MaLoaiXe, HangXe, DongXe, NamSanXuat) "
            + "VALUES "
            + "('" + t.getMaLoaiXe() + "', '" + t.getHangXe() + "', '" + t.getDongXe() + "', '" + t.getNamSanXuat() + "')";

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
    public int update(LoaiXeOto t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            Statement st = connection.createStatement();

            String sql = "UPDATE LoaiXeOto "
            + "SET "
            + "MaLoaiXe = '" + t.getMaLoaiXe() + "', "
            + "HangXe = '" + t.getHangXe() + "', "
            + "DongXe = '" + t.getDongXe() + "', "
            + "NamSanXuat = '" + t.getNamSanXuat() + "' "
            + "WHERE MaLoaiXe = '" + t.getMaLoaiXe() + "'";

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
    public int delete(LoaiXeOto t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            Statement st = connection.createStatement();

            String sql = "DELETE FROM LoaiXeOto "
            + "WHERE MaLoaiXe = '" + t.getMaLoaiXe() + "'";

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
    public ArrayList<LoaiXeOto> selectAll() {
        ArrayList<LoaiXeOto> loaiXeOtos = new ArrayList<LoaiXeOto>();
        try {
            Connection connection = JDBCUtil.getConnection();

            Statement st = connection.createStatement();

            String sql = "SELECT * FROM LoaiXeOto";

            System.out.println("You executed this query: " + sql);

            ResultSet rs = st.executeQuery(sql);

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
            Connection connection = JDBCUtil.getConnection();

            Statement st = connection.createStatement();

            String sql = "SELECT * FROM LoaiXeOto "
                + "WHERE MaLoaiXe = '" + t.getMaLoaiXe() + "';";

            System.out.println("You executed this query: " + sql);

            ResultSet rs = st.executeQuery(sql);

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
            Connection connection = JDBCUtil.getConnection();

            Statement st = connection.createStatement();

            String sql = "SELECT * FROM LoaiXeOto "
                + "WHERE " + condition + ";" ;

            System.out.println("You executed this query: " + sql);

            ResultSet rs = st.executeQuery(sql);

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
