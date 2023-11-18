package test;

import dao.LoaiXeOtoDAO;
import dao.XeOtoDAO;
import model.LoaiXeOto;
import model.XeOto;

public class testInsertLoaiXeOto {
    public static void main(String[] args) {
        LoaiXeOto loai = new LoaiXeOto("678", "Toyota", "Camry", "2019");
        LoaiXeOtoDAO.getInstance().insert(loai);
    }
}
