package test;

import dao.ChuXeDAO;
import model.ChuXe;

public class testUpdateChuXe {
    public static void main(String[] args) {
        int check = ChuXeDAO.getInstance().update(new ChuXe("1234567890", "Le", "Quoc An", "m", "2004-11-20" , "1234567890", "Le Van Long"));
        System.out.println("Affected row: " + check);
    }
}