package model;

public class DonVi {
    private String MaDonVi;
    private String TenDonVi;

    public DonVi() {
    }

    public DonVi(String maDonVi, String tenDonVi) {
        MaDonVi = maDonVi;
        TenDonVi = tenDonVi;
    }

    public String getMaDonVi() {
        return MaDonVi;
    }

    public void setMaDonVi(String maDonVi) {
        MaDonVi = maDonVi;
    }

    public String getTenDonVi() {
        return TenDonVi;
    }

    public void setTenDonVi(String tenDonVi) {
        TenDonVi = tenDonVi;
    }

    @Override
    public String toString() {
        return "DonVi [MaDonVi=" + MaDonVi + ", TenDonVi=" + TenDonVi + "]";
    }

    
}
