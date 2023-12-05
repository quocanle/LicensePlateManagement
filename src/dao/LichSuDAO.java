package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import model.LichSu;

public class LichSuDAO implements DAOInterface<LichSu> {

    public static LichSuDAO getInstance() {
        return new LichSuDAO();
    }

    @Override
    public int insert(LichSu t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "INSERT INTO LichSu (NgayDangKy, MaKhuVuc, MaSo, MaCongAnPhuTrach) "
                + "VALUES (?,?,?,?)";

            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setDate(1, t.getNgayDangKy());
            pst.setString(2, t.getMaKhuVuc());
            pst.setString(3, t.getMaSo());
            pst.setString(4, t.getMaCongAnPhuTrach());

            System.out.println("You executed this query: " + sql);

            check = pst.executeUpdate();
            System.out.println("Affected rows: " + check);

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int update(LichSu t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "UPDATE LichSu "
                + "SET "
                + "NgayDangKy = ?, "
                + "MaKhuVuc = ?, "
                + "MaSo = ?, "
                + "MaCongAnPhuTrach = ? "
                + "WHERE STT = ?";

            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setDate(1, t.getNgayDangKy());
            pst.setString(2, t.getMaKhuVuc());
            pst.setString(3, t.getMaSo());
            pst.setString(4, t.getMaCongAnPhuTrach());
            pst.setInt(5, t.getSTT());

            System.out.println("You executed this query: " + sql);

            check = pst.executeUpdate();
            System.out.println("Affected rows: " + check);

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public int update(LichSu t, int oldID) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "UPDATE LichSu "
                + "SET "
                + "NgayDangKy = ?, "
                + "MaKhuVuc = ?, "
                + "MaSo = ?, "
                + "MaCongAnPhuTrach = ? "
                + "WHERE STT = ?";

            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setDate(1, t.getNgayDangKy());
            pst.setString(2, t.getMaKhuVuc());
            pst.setString(3, t.getMaSo());
            pst.setString(4, t.getMaCongAnPhuTrach());
            pst.setInt(5, oldID);

            System.out.println("You executed this query: " + sql);

            check = pst.executeUpdate();
            System.out.println("Affected rows: " + check);

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int delete(LichSu t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "DELETE FROM LichSu "
                + "WHERE STT = ?";

            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, t.getSTT());

            System.out.println("You executed this query: " + sql);

            check = pst.executeUpdate();
            System.out.println("Affected rows: " + check);

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public ArrayList<LichSu> selectAll() {
        ArrayList<LichSu> lichSus = new ArrayList<LichSu>();
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM LichSu";

            PreparedStatement pst = connection.prepareStatement(sql);

            System.out.println("You executed this query: " + sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int stt = rs.getInt("STT");
                Date ngayDangKy = rs.getDate("NgayDangKy");
                String maKhuVuc = rs.getString("MaKhuVuc");
                String maSo = rs.getString("MaSo");
                String maCongAnPhuTrach = rs.getString("MaCongAnPhuTrach");
                lichSus.add(new LichSu(stt, ngayDangKy.toString(), maKhuVuc, maSo, maCongAnPhuTrach));
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lichSus;
    }

    @Override
    public ArrayList<LichSu> selectById(LichSu t) {
        ArrayList<LichSu> lichSus = new ArrayList<LichSu>();
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM LichSu "
                + "WHERE STT = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, t.getSTT());

            System.out.println("You executed this query: " + sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int stt = rs.getInt("STT");
                Date ngayDangKy = rs.getDate("NgayDangKy");
                String maKhuVuc = rs.getString("MaKhuVuc");
                String maSo = rs.getString("MaSo");
                String maCongAnPhuTrach = rs.getString("MaCongAnPhuTrach");
                lichSus.add(new LichSu(stt, ngayDangKy.toString(), maKhuVuc, maSo, maCongAnPhuTrach));
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lichSus;
    }

    @Override
    public ArrayList<LichSu> selectByCondition(String condition) {
        ArrayList<LichSu> lichSus = new ArrayList<LichSu>();
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM LichSu "
                + "WHERE " + condition;

            PreparedStatement pst = connection.prepareStatement(sql);

            System.out.println("You executed this query: " + sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int stt = rs.getInt("STT");
                Date ngayDangKy = rs.getDate("NgayDangKy");
                String maKhuVuc = rs.getString("MaKhuVuc");
                String maSo = rs.getString("MaSo");
                String maCongAnPhuTrach = rs.getString("MaCongAnPhuTrach");
                lichSus.add(new LichSu(stt, ngayDangKy.toString(), maKhuVuc, maSo, maCongAnPhuTrach));
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lichSus;
    }
}
