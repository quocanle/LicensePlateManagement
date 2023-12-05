package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import model.DonVi;

public class DonViDAO implements DAOInterface<DonVi> {

    public static DonViDAO getInstance() {
        return new DonViDAO();
    }

    @Override
    public int insert(DonVi t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "INSERT INTO DonVi (MaDonVi, TenDonVi) "
                + "VALUES (?,?)";

            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, t.getMaDonVi());
            pst.setString(2, t.getTenDonVi());

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
    public int update(DonVi t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "UPDATE DonVi "
                + "SET "
                + "MaDonVi = ?, "
                + "TenDonVi = ? "
                + "WHERE MaDonVi = ?";

            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, t.getMaDonVi());
            pst.setString(2, t.getTenDonVi());
            pst.setString(3, t.getMaDonVi());

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

    public int update(DonVi t, String oldID) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "UPDATE DonVi "
                + "SET "
                + "MaDonVi = ?, "
                + "TenDonVi = ? "
                + "WHERE MaDonVi = ?";

            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, t.getMaDonVi());
            pst.setString(2, t.getTenDonVi());
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
    public int delete(DonVi t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "DELETE FROM DonVi "
                + "WHERE MaDonVi = ?";

            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, t.getMaDonVi());

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
    public ArrayList<DonVi> selectAll() {
        ArrayList<DonVi> donVis = new ArrayList<DonVi>();
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM DonVi";

            PreparedStatement pst = connection.prepareStatement(sql);

            System.out.println("You executed this query: " + sql);
            
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaDonVi = rs.getString("MaDonVi");
                String TenDonVi = rs.getString("TenDonVi");
                donVis.add(new DonVi(MaDonVi, TenDonVi));
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return donVis;
    }

    @Override
    public ArrayList<DonVi> selectById(DonVi t) {
        ArrayList<DonVi> donVis = new ArrayList<DonVi>();
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM DonVi "
                + "WHERE MaDonVi = ? ";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaDonVi());

            System.out.println("You executed this query: " + sql);
            
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaDonVi = rs.getString("MaDonVi");
                String TenDonVi = rs.getString("TenDonVi");
                donVis.add(new DonVi(MaDonVi, TenDonVi));
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return donVis;
    }

    @Override
    public ArrayList<DonVi> selectByCondition(String condition) {
        ArrayList<DonVi> donVis = new ArrayList<DonVi>();
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM DonVi "
                + "WHERE " + condition + ";";

            PreparedStatement pst = connection.prepareStatement(sql);

            System.out.println("You executed this query: " + sql);
            
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaDonVi = rs.getString("MaDonVi");
                String TenDonVi = rs.getString("TenDonVi");
                donVis.add(new DonVi(MaDonVi, TenDonVi));
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return donVis;
    }
    
}
