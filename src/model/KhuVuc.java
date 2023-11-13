package model;

public class KhuVuc {
    private String MaKhuVuc;
    private String TenKhuVuc;

    public KhuVuc() {
    }

    public KhuVuc(String maKhuVuc, String tenKhuVuc) {
        MaKhuVuc = maKhuVuc;
        TenKhuVuc = tenKhuVuc;
    }

    public String getMaKhuVuc() {
        return MaKhuVuc;
    }

    public void setMaKhuVuc(String maKhuVuc) {
        MaKhuVuc = maKhuVuc;
    }

    public String getTenKhuVuc() {
        return TenKhuVuc;
    }

    public void setTenKhuVuc(String tenKhuVuc) {
        TenKhuVuc = tenKhuVuc;
    }

    @Override
    public String toString() {
        return "KhuVuc [MaKhuVuc=" + MaKhuVuc + ", TenKhuVuc=" + TenKhuVuc + "]";
    }

    
}
