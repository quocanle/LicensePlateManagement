package controller;

import java.util.ArrayList;

import dao.*;
import model.*;

public class Controller {
    public static Controller instance;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public CongAn login(String username, String password) {
        CongAnDAO caDAO = CongAnDAO.getInstance();
        CongAn ca = new CongAn();
        ca.setMaCongAn(username);
        for (CongAn ongCan : caDAO.selectById(ca)) {
            if (ongCan.getMaCongAn().equals(username) && ongCan.getPassword().equals(password)) {
                return ongCan;
            }
        }
        return null;
    }
}
