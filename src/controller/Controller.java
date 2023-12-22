package controller;

import java.sql.Connection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import dao.*;
import database.JDBCUtil;
import model.*;

public class Controller {
    public static Controller instance;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public CongAn login(String username, String password) {
        CongAnDAO caDAO = CongAnDAO.getInstance();
        CongAn ca = new CongAn();
        ca.setMaCongAn(username);
        for (CongAn ongCan : caDAO.selectById(ca)) {
            if (ongCan.getMaCongAn().equals(username) && ongCan.getPassword().equals(password)) {
                return ongCan;
            }
        }
        return null;
    }

    public ArrayList<ChuXe> getAllChuXe() {
        ChuXeDAO cxDAO = ChuXeDAO.getInstance();
        return cxDAO.selectAll();
    }

    public ArrayList<XeOto> getAllXeOto() {
        XeOtoDAO xoDAO = XeOtoDAO.getInstance();
        return xoDAO.selectAll();
    }

    public ArrayList<BienSo> getAllBienSo() {
        BienSoDAO bsDAO = BienSoDAO.getInstance();
        return bsDAO.selectAll();
    }

    public ArrayList<LoaiXeOto> getAllLoaiXe() {
        LoaiXeOtoDAO lxDAO = LoaiXeOtoDAO.getInstance();
        return lxDAO.selectAll();
    }

    public ArrayList<LichSu> getAllLichSu() {
        LichSuDAO lsDAO = LichSuDAO.getInstance();
        return lsDAO.selectAll();
    }

    public ArrayList<CongAn> getAllCongAn() {
        CongAnDAO caDAO = CongAnDAO.getInstance();
        ArrayList<CongAn> list = caDAO.selectAll();
        for (CongAn ca : list) {
            ca.setPassword(null);
        }
        for (CongAn ca : list) {
            if (ca.getMaCongAn().equals("admin")) {
                list.remove(ca);
                break;
            }
        }
        return list;
    }

    public ArrayList<DonVi> getAllDonVi() {
        DonViDAO dvDAO = DonViDAO.getInstance();
        return dvDAO.selectAll();
    }

    public ArrayList<KhuVuc> getAllKhuVuc() {
        KhuVucDAO kvDAO = KhuVucDAO.getInstance();
        return kvDAO.selectAll();
    }

    public ArrayList<ChuXe> searchCongDan(String keyWord) {
        ArrayList<ChuXe> list = new ArrayList<>();
        keyWord = keyWord.toLowerCase();
        for (ChuXe cx : getAllChuXe()) {
            if (cx.getHo().toLowerCase().contains(keyWord) 
            || cx.getTen().toLowerCase().contains(keyWord) 
            || cx.getCCCD().toLowerCase().contains(keyWord) 
            || cx.getSoDT().toLowerCase().contains(keyWord) 
            || cx.getDiaChi().toLowerCase().contains(keyWord)) {
                list.add(cx);
            }
        }
        return list;
    }

    public ArrayList<XeOto> searchXeOto(String keyWord) {
        ArrayList<XeOto> list = new ArrayList<>();
        keyWord = keyWord.toLowerCase();
        for (XeOto xo : getAllXeOto()) {
            if (xo.getSoMay().toLowerCase().contains(keyWord) 
            || xo.getSoKhung().toLowerCase().contains(keyWord) 
            || xo.getMauXe().toLowerCase().contains(keyWord) 
            || xo.getChuXeCCCD().toLowerCase().contains(keyWord)) {
                list.add(xo);
            }
        }
        return list;
    }

    public ArrayList<BienSo> searchBienSo(String keyWord) {
        keyWord = keyWord.toLowerCase();
        ArrayList<BienSo> list = new ArrayList<>();
        for (BienSo bs : getAllBienSo()) {
            if (bs.getMaSo().toLowerCase().contains(keyWord) 
            || bs.getMaKhuVuc().toLowerCase().contains(keyWord) 
            || bs.getSoKhung().toLowerCase().contains(keyWord) 
            || bs.getSoMay().toLowerCase().contains(keyWord) 
            || bs.getMaCongAnPhuTrach().toLowerCase().contains(keyWord)) {
                list.add(bs);
            }
        }
        return list;
    }

    public ArrayList<LoaiXeOto> searchLoaiXe(String keyWord) {
        keyWord = keyWord.toLowerCase();
        ArrayList<LoaiXeOto> list = new ArrayList<>();
        for (LoaiXeOto lx : getAllLoaiXe()) {
            if (lx.getMaLoaiXe().toLowerCase().contains(keyWord)
            || lx.getHangXe().toLowerCase().contains(keyWord)
            || lx.getDongXe().toLowerCase().contains(keyWord)
            || lx.getNamSanXuat().toLowerCase().contains(keyWord)) {
                list.add(lx);
            }
        }
        return list;
    }

    public ArrayList<CongAn> searchCongAn(String keyWord) {
        keyWord = keyWord.toLowerCase();
        ArrayList<CongAn> list = new ArrayList<>();
        for (CongAn ca : getAllCongAn()) {
            if (ca.getMaCongAn().toLowerCase().contains(keyWord)
            || ca.getHo().toLowerCase().contains(keyWord)
            || ca.getTen().toLowerCase().contains(keyWord)
            || ca.getSoDT().toLowerCase().contains(keyWord)
            || ca.getDiaChi().toLowerCase().contains(keyWord)
            || ca.getCapBac().toLowerCase().contains(keyWord)
            || ca.getMaDonVi().toLowerCase().contains(keyWord)) {
                list.add(ca);
            }
        }
        return list;
    }

    public ArrayList<DonVi> searchDonVi(String keyWord) {
        keyWord = keyWord.toLowerCase();
        ArrayList<DonVi> list = new ArrayList<>();
        for (DonVi dv : getAllDonVi()) {
            if (dv.getMaDonVi().toLowerCase().contains(keyWord)
            || dv.getTenDonVi().toLowerCase().contains(keyWord)) {
                list.add(dv);
            }
        }
        return list;
    }

    public ArrayList<KhuVuc> searchKhuVuc(String keyWord) {
        keyWord = keyWord.toLowerCase();
        ArrayList<KhuVuc> list = new ArrayList<>();
        for (KhuVuc kv : getAllKhuVuc()) {
            if (kv.getMaKhuVuc().toLowerCase().contains(keyWord)
            || kv.getTenKhuVuc().toLowerCase().contains(keyWord)) {
                list.add(kv);
            }
        }
        return list;
    }
    
    public boolean isChuXeExist(String cccd) {
        try {
            Connection connection = JDBCUtil.getConnection();
            
            String sql = "SELECT CCCD FROM ChuXe WHERE CCCD = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, cccd);
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return true;
            }

            JDBCUtil.closeConnection(connection);
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addChuXe(ChuXe cx) {
        ChuXeDAO cxDAO = ChuXeDAO.getInstance();
        cxDAO.insert(cx);
    }

    public boolean isXeOtoExist(String soKung, String soMay) {
        try {
            Connection connection = JDBCUtil.getConnection();
            
            String sql = "SELECT SoKhung, SoMay FROM XeOto WHERE SoKhung = ? AND SoMay = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, soKung);
            pst.setString(2, soMay);
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return true;
            }

            JDBCUtil.closeConnection(connection);
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addXeOto(XeOto xo) {
        XeOtoDAO xoDAO = XeOtoDAO.getInstance();
        xoDAO.insert(xo);
    }

    public boolean isBienSoExist(String maSo) {
        try {
            Connection connection = JDBCUtil.getConnection();
            
            String sql = "SELECT MaSo FROM BienSo WHERE MaSo = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, maSo);
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return true;
            }

            JDBCUtil.closeConnection(connection);
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addBienSo(BienSo bs) {
        BienSoDAO bsDAO = BienSoDAO.getInstance();
        bsDAO.insert(bs);
    }

    public boolean isMaLoaiXeExist(String maLoaiXe) {
        try {
            Connection connection = JDBCUtil.getConnection();
            
            String sql = "SELECT MaLoaiXe FROM LoaiXeOto WHERE MaLoaiXe = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, maLoaiXe);
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return true;
            }

            JDBCUtil.closeConnection(connection);
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addLoaiXe(LoaiXeOto lx) {
        LoaiXeOtoDAO lxDAO = LoaiXeOtoDAO.getInstance();
        lxDAO.insert(lx);
    }

    public void addLichSu(LichSu ls) {
        LichSuDAO lsDAO = LichSuDAO.getInstance();
        lsDAO.insert(ls);
    }

    public boolean isCongAnExist(String maCongAn) {
        try {
            Connection connection = JDBCUtil.getConnection();
            
            String sql = "SELECT MaCongAn FROM CongAn WHERE MaCongAn = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, maCongAn);
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return true;
            }

            JDBCUtil.closeConnection(connection);
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addCongAn(CongAn ca) {
        CongAnDAO caDAO = CongAnDAO.getInstance();
        caDAO.insert(ca);
    }

    public boolean isDonViExist(String maDonVi) {
        try {
            Connection connection = JDBCUtil.getConnection();
            
            String sql = "SELECT MaDonVi FROM DonVi WHERE MaDonVi = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, maDonVi);
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return true;
            }

            JDBCUtil.closeConnection(connection);
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addDonVi(DonVi dv) {
        DonViDAO dvDAO = DonViDAO.getInstance();
        dvDAO.insert(dv);
    }

    public boolean isKhuVucExist(String maKhuVuc) {
        try {
            Connection connection = JDBCUtil.getConnection();
            
            String sql = "SELECT MaKhuVuc FROM KhuVuc WHERE MaKhuVuc = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, maKhuVuc);
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return true;
            }

            JDBCUtil.closeConnection(connection);
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addKhuVuc(KhuVuc kv) {
        KhuVucDAO kvDAO = KhuVucDAO.getInstance();
        kvDAO.insert(kv);
    }

    public void updateChuXe(ChuXe cx, String oldID) {
        ChuXeDAO cxDAO = ChuXeDAO.getInstance();
        cxDAO.update(cx, oldID);
    }

    public void deleteChuXe(ChuXe cx) {
        ChuXeDAO cxDAO = ChuXeDAO.getInstance();
        cxDAO.delete(cx);
    }

    public void updateXeOto(XeOto xo, String oldID1, String oldID2) {
        XeOtoDAO xoDAO = XeOtoDAO.getInstance();
        xoDAO.update(xo, oldID1, oldID2);
    }

    public void deleteXeOto(XeOto xo) {
        XeOtoDAO xoDAO = XeOtoDAO.getInstance();
        xoDAO.delete(xo);
    }

    public void updateBienSo(BienSo bs, String oldID) {
        BienSoDAO bsDAO = BienSoDAO.getInstance();
        bsDAO.update(bs, oldID);
    }

    public void deleteBienSo(BienSo bs) {
        BienSoDAO bsDAO = BienSoDAO.getInstance();
        bsDAO.delete(bs);
    }

    public void updateLoaiXe(LoaiXeOto lx, String oldID) {
        LoaiXeOtoDAO lxDAO = LoaiXeOtoDAO.getInstance();
        lxDAO.update(lx, oldID);
    }

    public void deleteLoaiXe(LoaiXeOto lx) {
        LoaiXeOtoDAO lxDAO = LoaiXeOtoDAO.getInstance();
        lxDAO.delete(lx);
    }

    public void updateLichSu(LichSu ls, int oldID) {
        LichSuDAO lsDAO = LichSuDAO.getInstance();
        lsDAO.update(ls, oldID);
    }

    public void deleteLichSu(LichSu ls) {
        LichSuDAO lsDAO = LichSuDAO.getInstance();
        lsDAO.delete(ls);
    }

    public void updateCongAn(CongAn ca, String oldID) {
        CongAnDAO caDAO = CongAnDAO.getInstance();
        caDAO.update(ca, oldID);
    }

    public void deleteCongAn(CongAn ca) {
        CongAnDAO caDAO = CongAnDAO.getInstance();
        caDAO.delete(ca);
    }

    public void updateDonVi(DonVi dv, String oldID) {
        DonViDAO dvDAO = DonViDAO.getInstance();
        dvDAO.update(dv, oldID);
    }

    public void deleteDonVi(DonVi dv) {
        DonViDAO dvDAO = DonViDAO.getInstance();
        dvDAO.delete(dv);
    }

    public void updateKhuVuc(KhuVuc kv, String oldID) {
        KhuVucDAO kvDAO = KhuVucDAO.getInstance();
        kvDAO.update(kv, oldID);
    }

    public void deleteKhuVuc(KhuVuc kv) {
        KhuVucDAO kvDAO = KhuVucDAO.getInstance();
        kvDAO.delete(kv);
    }

    public String fileSaveSeleceted() {
        JFrame parentFrame = new JFrame();
 
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Export to TXT");

        // set default extension to txt
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("TXT file", "txt"));
        // set default name to export file
        fileChooser.setSelectedFile(new File("export.txt"));
        
        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
        }
        parentFrame.dispose();
        return fileChooser.getSelectedFile().getAbsolutePath();
    }

    public void exportDbCongDanToTXT(String path) {
        try {
            FileWriter fileWriter = new FileWriter(path, StandardCharsets.UTF_8);
            ArrayList<ChuXe> cxList = getAllChuXe();
            String cxData = "";
            for (ChuXe cx : cxList) {
                cxData += String.format("%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\n", cx.getCCCD(), cx.getHo(), cx.getTen(), cx.getGioiTinh(), cx.getNgaySinh(), cx.getSoDT(), cx.getDiaChi());
            }
            String nameTagCongDan = "CongDan\n";
            String columnNameCongDan = String.format("%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\n", "CCCD", "Ho", "Ten", "GioiTinh", "NgaySinh", "SoDT", "DiaChi");
            fileWriter.write(nameTagCongDan);
            fileWriter.write(columnNameCongDan);
            fileWriter.write(cxData);

            ArrayList<XeOto> xoList = getAllXeOto();
            String xoData = "";
            for (XeOto xo : xoList) {
                xoData += String.format("%-15s\t%-15s\t%-15s\t%-15s\t%-15s\n", xo.getSoKhung(), xo.getSoMay(), xo.getMaLoaiXe(), xo.getMauXe(), xo.getChuXeCCCD());
            }
            String nameTagXeOto = "\nXeOto\n";
            String columnNameXeOto = String.format("%-15s\t%-15s\t%-15s\t%-15s\t%-15s\n", "SoKhung", "SoMay", "MaLoaiXe", "MauXe", "ChuXeCCCD");
            fileWriter.write(nameTagXeOto);
            fileWriter.write(columnNameXeOto);
            fileWriter.write(xoData);

            ArrayList<BienSo> bsList = getAllBienSo();
            String bsData = "";
            for (BienSo bs : bsList) {
                bsData += String.format("%-15s\t%-15s\t%-15s\t%-15s\t%-15s\n", bs.getMaSo(), bs.getMaKhuVuc(), bs.getSoKhung(), bs.getSoMay(), bs.getMaCongAnPhuTrach());
            }
            String nameTagBienSo = "\nBienSo\n";
            String columnNameBienSo = String.format("%-15s\t%-15s\t%-15s\t%-15s\t%-15s\n", "MaSo", "MaKhuVuc", "SoKhung", "SoMay", "MaCongAnPhuTrach");
            fileWriter.write(nameTagBienSo);
            fileWriter.write(columnNameBienSo);
            fileWriter.write(bsData);

            ArrayList<LoaiXeOto> lxList = getAllLoaiXe();
            String lxData = "";
            for (LoaiXeOto lx : lxList) {
                lxData += String.format("%-15s\t%-15s\t%-15s\t%-15s\n", lx.getMaLoaiXe(), lx.getHangXe(), lx.getDongXe(), lx.getNamSanXuat());
            }
            String nameTagLoaiXe = "\nLoaiXe\n";
            String columnNameLoaiXe = String.format("%-15s\t%-15s\t%-15s\t%-15s\n", "MaLoaiXe", "HangXe", "DongXe", "NamSanXuat");
            fileWriter.write(nameTagLoaiXe);
            fileWriter.write(columnNameLoaiXe);
            fileWriter.write(lxData);

            ArrayList<LichSu> lsList = getAllLichSu();
            String lsData = "";
            for (LichSu ls : lsList) {
                lsData += String.format("%-15s\t%-15s\t%-15s\t%-15s\t%-15s\n", ls.getSTT(), ls.getNgayDangKy(), ls.getMaKhuVuc(), ls.getMaSo(), ls.getMaCongAnPhuTrach());
            }
            String nameTagLichSu = "\nLichSu\n";
            String columnNameLichSu = String.format("%-15s\t%-15s\t%-15s\t%-15s\t%-15s\n", "STT", "NgayDangKy", "MaKhuVuc", "MaSo", "MaCongAnPhuTrach");
            fileWriter.write(nameTagLichSu);
            fileWriter.write(columnNameLichSu);
            fileWriter.write(lsData);

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void exportDbCongAnToTXT(String path) {
        try {
            FileWriter fileWriter = new FileWriter(path, StandardCharsets.UTF_8);
            ArrayList<CongAn> caList = getAllCongAn();
            String caData = "";
            for (CongAn ca : caList) {
                caData += String.format("%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\n", ca.getMaCongAn(), ca.getHo(), ca.getTen(), ca.getNgaySinh(), ca.getGioiTinh(), ca.getSoDT(), ca.getCapBac(), ca.getDiaChi());
            }
            String nameTagCongAn = "CongAn\n";
            String columnNameCongAn = String.format("%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\n", "MaCongAn", "Ho", "Ten", "NgaySinh", "GioiTinh", "SoDT", "CapBac", "DiaChi");
            fileWriter.write(nameTagCongAn);
            fileWriter.write(columnNameCongAn);
            fileWriter.write(caData);

            ArrayList<DonVi> dvList = getAllDonVi();
            String dvData = "";
            for (DonVi dv : dvList) {
                dvData += String.format("%-15s\t%-15s\n", dv.getMaDonVi(), dv.getTenDonVi());
            }
            String nameTagDonVi = "\nDonVi\n";
            String columnNameDonVi = String.format("%-15s\t%-15s\n", "MaDonVi", "TenDonVi");
            fileWriter.write(nameTagDonVi);
            fileWriter.write(columnNameDonVi);
            fileWriter.write(dvData);

            ArrayList<KhuVuc> kvList = getAllKhuVuc();
            String kvData = "";
            for (KhuVuc kv : kvList) {
                kvData += String.format("%-15s\t%-15s\n", kv.getMaKhuVuc(), kv.getTenKhuVuc());
            }
            String nameTagKhuVuc = "\nKhuVuc\n";
            String columnNameKhuVuc = String.format("%-15s\t%-15s\n", "MaKhuVuc", "TenKhuVuc");
            fileWriter.write(nameTagKhuVuc);
            fileWriter.write(columnNameKhuVuc);
            fileWriter.write(kvData);

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
