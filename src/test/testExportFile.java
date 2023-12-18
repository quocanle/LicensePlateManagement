package test;

import controller.Controller;

public class testExportFile {
    public static void main(String[] args) {
        Controller controller = Controller.getInstance();
        // controller.fileSaveSeleceted();
        controller.exportDbCongDanToTXT(controller.fileSaveSeleceted());
        controller.exportDbCongAnToTXT(controller.fileSaveSeleceted());
    }
}
