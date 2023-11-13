package model;

public class BienSo {
    private String MaSo;
    private String MaKhuVuc;
    private String NgayDangKy;
    private String SoKhung;
    private String SoMay;
    private String MaCongAnPhuTrach;

    public BienSo() {
    }

    public BienSo(String maSo, String maKhuVuc, String ngayDangKy, String soKhung, String soMay,
            String maCongAnPhuTrach) {
        MaSo = maSo;
        MaKhuVuc = maKhuVuc;
        NgayDangKy = ngayDangKy;
        SoKhung = soKhung;
        SoMay = soMay;
        MaCongAnPhuTrach = maCongAnPhuTrach;
    }

    public String getMaSo() {
        return MaSo;
    }

    public void setMaSo(String maSo) {
        MaSo = maSo;
    }

    public String getMaKhuVuc() {
        return MaKhuVuc;
    }

    public void setMaKhuVuc(String maKhuVuc) {
        MaKhuVuc = maKhuVuc;
    }

    public String getNgayDangKy() {
        return NgayDangKy;
    }

    public void setNgayDangKy(String ngayDangKy) {
        NgayDangKy = ngayDangKy;
    }

    public String getSoKhung() {
        return SoKhung;
    }

    public void setSoKhung(String soKhung) {
        SoKhung = soKhung;
    }

    public String getSoMay() {
        return SoMay;
    }

    public void setSoMay(String soMay) {
        SoMay = soMay;
    }

    public String getMaCongAnPhuTrach() {
        return MaCongAnPhuTrach;
    }

    public void setMaCongAnPhuTrach(String maCongAnPhuTrach) {
        MaCongAnPhuTrach = maCongAnPhuTrach;
    }

    @Override
    public String toString() {
        return "BienSo [MaSo=" + MaSo + ", MaKhuVuc=" + MaKhuVuc + ", NgayDangKy=" + NgayDangKy + ", SoKhung=" + SoKhung
                + ", SoMay=" + SoMay + ", MaCongAnPhuTrach=" + MaCongAnPhuTrach + "]";
    }

    
}
