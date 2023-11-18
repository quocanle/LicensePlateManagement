package test;

import dao.LoaiXeOtoDAO;
import model.LoaiXeOto;

public class testInsertLoaiXeOto {
    public static void main(String[] args) {
        LoaiXeOto loai = new LoaiXeOto("678", "Toyota", "Camry", "2019");
        LoaiXeOtoDAO.getInstance().insert(loai);
    }
}
