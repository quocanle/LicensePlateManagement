package model;

public class XeOto {
    private String SoKhung;
    private String SoMay;
    private String MaLoaiXe;
    private String MauXe;
    private String ChuXeCCCD;

    public XeOto() {
    }

    public XeOto(String soKhung, String soMay, String maLoaiXe, String mauXe, String chuXeCCCD) {
        SoKhung = soKhung;
        SoMay = soMay;
        MaLoaiXe = maLoaiXe;
        MauXe = mauXe;
        ChuXeCCCD = chuXeCCCD;
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

    public String getMaLoaiXe() {
        return MaLoaiXe;
    }

    public void setMaLoaiXe(String maLoaiXe) {
        MaLoaiXe = maLoaiXe;
    }

    public String getMauXe() {
        return MauXe;
    }

    public void setMauXe(String mauXe) {
        MauXe = mauXe;
    }

    public String getChuXeCCCD() {
        return ChuXeCCCD;
    }

    public void setChuXeCCCD(String chuXeCCCD) {
        ChuXeCCCD = chuXeCCCD;
    }

    @Override
    public String toString() {
        return "XeOto [SoKhung=" + SoKhung + ", SoMay=" + SoMay + ", MaLoaiXe=" + MaLoaiXe + ", MauXe=" + MauXe
                + ", ChuXeCCCD=" + ChuXeCCCD + "]";
    }

    
}
