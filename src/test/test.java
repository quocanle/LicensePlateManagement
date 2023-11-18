package test;

import dao.ChuXeDAO;
import model.ChuXe;

public class test {
    public static void main(String[] args) {
        for (ChuXe cx : ChuXeDAO.getInstance().selectAll()) {
            System.out.println(cx.toString());
        }
    }
}
