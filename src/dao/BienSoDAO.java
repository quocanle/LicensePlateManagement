package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import model.BienSo;

public class BienSoDAO implements DAOInterface<BienSo> {

    public static BienSoDAO getInstance () {
        return new BienSoDAO();
    }

    @Override
    public int insert(BienSo t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            String sql = "INSERT INTO BienSo (MaSo, MaKhuVuc, NgayDangKy, SoKhung, SoMay, MaCongAnPhuTrach)"
                + "VALUES (?,?,?,?,?,?)";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaSo());
            pst.setString(2, t.getMaKhuVuc());
            pst.setDate(3, t.getNgayDangKy());
            pst.setString(4, t.getSoKhung());
            pst.setString(5, t.getSoMay());
            pst.setString(6, t.getMaCongAnPhuTrach());

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
    public int update(BienSo t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            String sql = "UPDATE BienSo "
                + "SET "
                + "MaSo = ?, "
                + "MaKhuVuc = ?, "
                + "NgayDangKy = ?, "
                + "SoKhung = ?, "
                + "SoMay = ?, "
                + "MaCongAnPhuTrach = ? "
                + "WHERE MaSo = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaSo());
            pst.setString(2, t.getMaKhuVuc());
            pst.setDate(3, t.getNgayDangKy());
            pst.setString(4, t.getSoKhung());
            pst.setString(5, t.getSoMay());
            pst.setString(6, t.getMaCongAnPhuTrach());
            pst.setString(7, t.getMaSo());

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
    public int delete(BienSo t) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            String sql = "DELETE FROM BienSo "
                + "WHERE MaSo = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaSo());

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
    public ArrayList<BienSo> selectAll() {
        ArrayList<BienSo> bienSos = new ArrayList<BienSo>();
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            String sql = "SELECT * FROM BienSo";

            PreparedStatement pst = connection.prepareStatement(sql);

            System.out.println("You executed this query: " + sql);
            
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaSo = rs.getString("MaSo");
                String MaKhuVuc = rs.getString("MaKhuVuc");
                String NgayDangKy = rs.getString("NgayDangKy");
                String SoKhung = rs.getString("SoKhung");
                String SoMay = rs.getString("SoMay");
                String MaCongAnPhuTrach = rs.getString("MaCongAnPhuTrach");

                BienSo bienSo = new BienSo(MaSo, MaKhuVuc, NgayDangKy, SoKhung, SoMay, MaCongAnPhuTrach);
                bienSos.add(bienSo);
            }

            JDBCUtil.closeConnection(connection);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bienSos;
    }

    @Override
    public ArrayList<BienSo> selectById(BienSo t) {
        ArrayList<BienSo> bienSos = new ArrayList<BienSo>();
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            String sql = "SELECT * FROM BienSo "
                + "WHERE MaSo = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaSo());

            System.out.println("You executed this query: " + sql);
            
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaSo = rs.getString("MaSo");
                String MaKhuVuc = rs.getString("MaKhuVuc");
                String NgayDangKy = rs.getString("NgayDangKy");
                String SoKhung = rs.getString("SoKhung");
                String SoMay = rs.getString("SoMay");
                String MaCongAnPhuTrach = rs.getString("MaCongAnPhuTrach");

                BienSo bienSo = new BienSo(MaSo, MaKhuVuc, NgayDangKy, SoKhung, SoMay, MaCongAnPhuTrach);
                bienSos.add(bienSo);
            }

            JDBCUtil.closeConnection(connection);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bienSos;
    }

    @Override
    public ArrayList<BienSo> selectByCondition(String condition) {
        ArrayList<BienSo> bienSos = new ArrayList<BienSo>();
        try {
            Connection connection = JDBCUtil.getConnection("MSSQL");

            String sql = "SELECT * FROM BienSo "
                + "WHERE " + condition + ";" ;

            PreparedStatement pst = connection.prepareStatement(sql);

            System.out.println("You executed this query: " + sql);
            
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaSo = rs.getString("MaSo");
                String MaKhuVuc = rs.getString("MaKhuVuc");
                String NgayDangKy = rs.getString("NgayDangKy");
                String SoKhung = rs.getString("SoKhung");
                String SoMay = rs.getString("SoMay");
                String MaCongAnPhuTrach = rs.getString("MaCongAnPhuTrach");

                BienSo bienSo = new BienSo(MaSo, MaKhuVuc, NgayDangKy, SoKhung, SoMay, MaCongAnPhuTrach);
                bienSos.add(bienSo);
            }

            JDBCUtil.closeConnection(connection);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bienSos;
    }
}
