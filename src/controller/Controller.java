package controller;

import java.util.ArrayList;

import dao.*;
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

    public void addChuXe(ChuXe cx) {
        ChuXeDAO cxDAO = ChuXeDAO.getInstance();
        cxDAO.insert(cx);
    }

    public void addXeOto(XeOto xo) {
        XeOtoDAO xoDAO = XeOtoDAO.getInstance();
        xoDAO.insert(xo);
    }

    public void addBienSo(BienSo bs) {
        BienSoDAO bsDAO = BienSoDAO.getInstance();
        bsDAO.insert(bs);
    }

    public void addLoaiXe(LoaiXeOto lx) {
        LoaiXeOtoDAO lxDAO = LoaiXeOtoDAO.getInstance();
        lxDAO.insert(lx);
    }

    public void addLichSu(LichSu ls) {
        LichSuDAO lsDAO = LichSuDAO.getInstance();
        lsDAO.insert(ls);
    }

    public void addCongAn(CongAn ca) {
        CongAnDAO caDAO = CongAnDAO.getInstance();
        caDAO.insert(ca);
    }

    public void addDonVi(DonVi dv) {
        DonViDAO dvDAO = DonViDAO.getInstance();
        dvDAO.insert(dv);
    }

    public void addKhuVuc(KhuVuc kv) {
        KhuVucDAO kvDAO = KhuVucDAO.getInstance();
        kvDAO.insert(kv);
    }
            
}
