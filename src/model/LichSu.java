package model;

import java.sql.Date;

public class LichSu {
    private int STT;
    private Date NgayDangKy;
    private String MaKhuVuc;
    private String MaSo;
    private String MaCongAnPhuTrach;
    
    public LichSu() {
    }
    
    public LichSu(String NgayDangKy, String MaKhuVuc, String MaSo, String MaCongAnPhuTrach) {
        this.NgayDangKy = Date.valueOf(NgayDangKy);
        this.MaKhuVuc = MaKhuVuc;
        this.MaSo = MaSo;
        this.MaCongAnPhuTrach = MaCongAnPhuTrach;
    }

    public LichSu(int STT, String NgayDangKy, String MaKhuVuc, String MaSo, String MaCongAnPhuTrach) {
        this.STT = STT;
        this.NgayDangKy = Date.valueOf(NgayDangKy);
        this.MaKhuVuc = MaKhuVuc;
        this.MaSo = MaSo;
        this.MaCongAnPhuTrach = MaCongAnPhuTrach;
    }
    
    public int getSTT() {
        return STT;
    }
    
    public void setSTT(int STT) {
        this.STT = STT;
    }
    
    public Date getNgayDangKy() {
        return NgayDangKy;
    }
    
    public void setNgayDangKy(String NgayDangKy) {
        this.NgayDangKy = Date.valueOf(NgayDangKy);
    }
    
    public String getMaKhuVuc() {
        return MaKhuVuc;
    }
    
    public void setMaKhuVuc(String MaKhuVuc) {
        this.MaKhuVuc = MaKhuVuc;
    }
    
    public String getMaSo() {
        return MaSo;
    }
    
    public void setMaSo(String MaSo) {
        this.MaSo = MaSo;
    }
    
    public String getMaCongAnPhuTrach() {
        return MaCongAnPhuTrach;
    }
    
    public void setMaCongAnPhuTrach(String MaCongAnPhuTrach) {
        this.MaCongAnPhuTrach = MaCongAnPhuTrach;
    }
}
