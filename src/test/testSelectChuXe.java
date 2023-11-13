package test;

import java.util.ArrayList;

import dao.ChuXeDAO;
import model.ChuXe;

public class testSelectChuXe {
    public static void main(String[] args) {

        ArrayList<ChuXe> list1 = ChuXeDAO.getInstance().selectAll();
        for (ChuXe c : list1) {
            System.out.println(c.toString());
        }

        ChuXe chuxe = new ChuXe();
        chuxe.setCCCD("1234567890");
        ArrayList<ChuXe> list2 = ChuXeDAO.getInstance().selectById(chuxe);
        for (ChuXe c : list2) {
            System.out.println(c.toString());
        }

        ArrayList<ChuXe> list3 = ChuXeDAO.getInstance().selectByCondition("Ho = 'L0'");
        for (ChuXe c : list3) {
            System.out.println(c.toString());
        }
    }
}
