package model;

public class LoaiXeOto {
    private String MaLoaiXe;
    private String HangXe;
    private String DongXe;
    private String NamSanXuat;
    
    public LoaiXeOto(String maLoaiXe, String hangXe, String dongXe, String namSanXuat) {
        MaLoaiXe = maLoaiXe;
        HangXe = hangXe;
        DongXe = dongXe;
        NamSanXuat = namSanXuat;
    }

    public String getMaLoaiXe() {
        return MaLoaiXe;
    }

    public void setMaLoaiXe(String maLoaiXe) {
        MaLoaiXe = maLoaiXe;
    }

    public String getHangXe() {
        return HangXe;
    }

    public void setHangXe(String hangXe) {
        HangXe = hangXe;
    }

    public String getDongXe() {
        return DongXe;
    }

    public void setDongXe(String dongXe) {
        DongXe = dongXe;
    }

    public String getNamSanXuat() {
        return NamSanXuat;
    }

    public void setNamSanXuat(String namSanXuat) {
        NamSanXuat = namSanXuat;
    }
}
