package dao;

import java.sql.Connection;
import java.sql.ResultSet;
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
            Connection connection = JDBCUtil.getConnection();

            Statement st = connection.createStatement();

            String sql = "INSERT INTO ChuXe (CCCD, Ho, Ten, GioiTinh, NgaySinh, SoDT, DiaChi)"
                + "VALUES"
                + "('" + t.getCCCD() + "', '" + t.getHo() + "', '" + t.getTen() + "', '" + t.getGioiTinh() + "', '" + t.getNgaySinh() + "', '" + t.getSoDT() + "', '" + t.getDiaChi() + "');";
            
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
            Connection connection = JDBCUtil.getConnection();

            Statement st = connection.createStatement();

            String sql = "UPDATE ChuXe SET "
                + "Ho = '" + t.getHo() + "', "
                + "Ten = '" + t.getTen() + "', "
                + "GioiTinh = '" + t.getGioiTinh() + "', "
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
            Connection connection = JDBCUtil.getConnection();

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
    public ArrayList<ChuXe> selectAll() {
        ArrayList<ChuXe> chuXeList = new ArrayList<ChuXe>();
        try {
            Connection connection = JDBCUtil.getConnection();

            Statement st = connection.createStatement();

            String sql = "SELECT * FROM ChuXe;";

            System.out.println("You executed this query: " + sql);

            ResultSet rs = st.executeQuery(sql);

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
            Connection connection = JDBCUtil.getConnection();

            Statement st = connection.createStatement();

            String sql = "SELECT * FROM ChuXe "
                + "WHERE CCCD = '" + t.getCCCD() + "';";

            System.out.println("You executed this query: " + sql);

            ResultSet rs = st.executeQuery(sql);

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
            Connection connection = JDBCUtil.getConnection();

            Statement st = connection.createStatement();

            String sql = "SELECT * FROM ChuXe "
                + "WHERE " + condition + ";";

            System.out.println("You executed this query: " + sql);

            ResultSet rs = st.executeQuery(sql);

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
