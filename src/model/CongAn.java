package model;

import java.sql.Date;

public class CongAn {
    private String MaCongAn;
    private String Ho;
    private String Ten;
    private Date NgaySinh;
    private String GioiTinh;
    private String SoDT;
    private String DiaChi;
    private String CapBac;
    private String MaDonVi;
    private String Password;

    public CongAn() {
    }

    public CongAn(String maCongAn, String ho, String ten, String ngaySinh, String gioiTinh, String soDT, String diaChi,
            String capBac, String maDonVi, String password) {
        MaCongAn = maCongAn;
        Ho = ho;
        Ten = ten;
        NgaySinh = Date.valueOf(ngaySinh);
        GioiTinh = gioiTinh;
        SoDT = soDT;
        DiaChi = diaChi;
        CapBac = capBac;
        MaDonVi = maDonVi;
        Password = password;
    }

    public String getMaCongAn() {
        return MaCongAn;
    }

    public void setMaCongAn(String maCongAn) {
        MaCongAn = maCongAn;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String ho) {
        Ho = ho;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = Date.valueOf(ngaySinh);
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String soDT) {
        SoDT = soDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getCapBac() {
        return CapBac;
    }

    public void setCapBac(String capBac) {
        CapBac = capBac;
    }

    public String getMaDonVi() {
        return MaDonVi;
    }

    public void setMaDonVi(String maDonVi) {
        MaDonVi = maDonVi;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "CongAn [MaCongAn=" + MaCongAn + ", Ho=" + Ho + ", Ten=" + Ten + ", NgaySinh=" + NgaySinh + ", GioiTinh="
                + GioiTinh + ", SoDT=" + SoDT + ", DiaChi=" + DiaChi + ", CapBac=" + CapBac + ", MaDonVi=" + MaDonVi
                + ", Password=" + Password + "]";
    }

    
}
