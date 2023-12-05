package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import model.KhuVuc;

public class KhuVucDAO implements DAOInterface<KhuVuc> {

    public static KhuVucDAO getInstance() {
        return new KhuVucDAO();
    }

    @Override
    public int insert(KhuVuc t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "INSERT INTO KhuVuc (MaKhuVuc, TenKhuVuc) "
                + "VALUES (?,?)";

            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, t.getMaKhuVuc());
            pst.setString(2, t.getTenKhuVuc());

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
    public int update(KhuVuc t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "UPDATE KhuVuc "
                + "SET "
                + "MaKhuVuc = ?, "
                + "TenKhuVuc = ? "
                + "WHERE MaKhuVuc = ?";

            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, t.getMaKhuVuc());
            pst.setString(2, t.getTenKhuVuc());
            pst.setString(3, t.getMaKhuVuc());

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

    public int update(KhuVuc t, String oldID) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "UPDATE KhuVuc "
                + "SET "
                + "MaKhuVuc = ?, "
                + "TenKhuVuc = ? "
                + "WHERE MaKhuVuc = ?";

            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, t.getMaKhuVuc());
            pst.setString(2, t.getTenKhuVuc());
            pst.setString(3, oldID);

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
    public int delete(KhuVuc t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "DELETE FROM KhuVuc "
                + "WHERE MaKhuVuc = ?";

            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, t.getMaKhuVuc());

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
    public ArrayList<KhuVuc> selectAll() {
        ArrayList<KhuVuc> khuVucs = new ArrayList<KhuVuc>();
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM KhuVuc";

            PreparedStatement pst = connection.prepareStatement(sql);

            System.out.println("You executed this query: " + sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaKhuVuc = rs.getString("MaKhuVuc");
                String TenKhuVuc = rs.getString("TenKhuVuc");

                khuVucs.add(new KhuVuc(MaKhuVuc, TenKhuVuc));
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return khuVucs;
    }

    @Override
    public ArrayList<KhuVuc> selectById(KhuVuc t) {
        ArrayList<KhuVuc> khuVucs = new ArrayList<KhuVuc>();
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM KhuVuc"
                + "WHERE MaKhuVuc = ?";

            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, t.getMaKhuVuc());

            System.out.println("You executed this query: " + sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaKhuVuc = rs.getString("MaKhuVuc");
                String TenKhuVuc = rs.getString("TenKhuVuc");

                khuVucs.add(new KhuVuc(MaKhuVuc, TenKhuVuc));
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return khuVucs;
    }

    @Override
    public ArrayList<KhuVuc> selectByCondition(String condition) {
        ArrayList<KhuVuc> khuVucs = new ArrayList<KhuVuc>();
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM KhuVuc"
                + "WHERE " + condition + ";" ;

            PreparedStatement pst = connection.prepareStatement(sql);

            System.out.println("You executed this query: " + sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaKhuVuc = rs.getString("MaKhuVuc");
                String TenKhuVuc = rs.getString("TenKhuVuc");

                khuVucs.add(new KhuVuc(MaKhuVuc, TenKhuVuc));
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return khuVucs;
    }
    
}
