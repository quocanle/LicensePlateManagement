package test;

import controller.Controller;
import dao.*;
import model.*;

public class test {
    public static void main(String[] args) {
        for (ChuXe cx : Controller.getInstance().searchCongDan("0")) {
            System.out.println(cx.getHo() + " " + cx.getTen());
        }
    }
}
