package test;

import dao.ChuXeDAO;
import model.ChuXe;

public class testInsertChuXe {
    public static void main(String[] args) {
        // ChuXeDAO chuXeDAO = ChuXeDAO.getInstance();
        // try {
        //     ChuXe chuXe = new ChuXe("123456789012", "Le", "Quoc An", "2004-11-20" , "1234567890", "Le Van Long");
        //     chuXeDAO.insert(chuXe);
        // } catch (Exception e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }


        // int check = 0;
        // for (int i = 0; i < 10; i++) {
        //     check += ChuXeDAO.getInstance().insert(new ChuXe("123456789" + i, "L" + i, "A" + i, "m", "2004-11-2" + i, "123456789" + i, i + " Le Van Long"));
        // }
        // System.out.println("Affected row: " + check);

        ChuXeDAO.getInstance().insert(new ChuXe("123", "Le", "Quoc An", "m", "2004-11-20", "12345", "0 Le Van Long"));
        ChuXeDAO.getInstance().selectByCondition("CCCD = '123'").forEach(System.out::println);
    }
}
