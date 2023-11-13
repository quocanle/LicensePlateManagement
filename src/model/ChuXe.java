package model;

public class ChuXe {
    private String CCCD;
    private String Ho;
    private String Ten;
    private String NgaySinh;
    private String SoDT;
    private String DiaChi;

    public ChuXe() {
    }

    public ChuXe(String cCCD, String ho, String ten, String ngaySinh, String soDT, String diaChi) {
        CCCD = cCCD;
        Ho = ho;
        Ten = ten;
        NgaySinh = ngaySinh;
        SoDT = soDT;
        DiaChi = diaChi;
    }
    public String getCCCD() {
        return CCCD;
    }
    public void setCCCD(String cCCD) {
        CCCD = cCCD;
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
    public String getNgaySinh() {
        return NgaySinh;
    }
    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
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
}
