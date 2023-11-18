package test;

import controller.Controller;
import dao.*;
import model.*;

public class test {
    public static void main(String[] args) {
        Controller contronller = Controller.getInstance();
        System.out.println(contronller.login("CA001", "123456"));
    }
}
