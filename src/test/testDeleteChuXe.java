package test;

import dao.ChuXeDAO;
import model.ChuXe;

public class testDeleteChuXe {
    public static void main(String[] args) {
        ChuXe chuxe = new ChuXe();
        chuxe.setCCCD("1234567890");
        int check = ChuXeDAO.getInstance().delete(chuxe);
        System.out.println(check);
    }
}
