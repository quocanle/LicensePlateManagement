package test;

import dao.ChuXeDAO;
import model.ChuXe;

public class testUpdateChuXe {
    public static void main(String[] args) {
        ChuXeDAO.getInstance().update(new ChuXe("123456", "Pham", "Nguyen Huy Minh", "Nam", "2004-01-01", "Nam", "11 Le Loi"), "12345");
    }
}