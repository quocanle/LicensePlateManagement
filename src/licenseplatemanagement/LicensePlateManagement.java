/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package licenseplatemanagement;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import view.Login;

/**
 *
 * @author lequo
 */
public class LicensePlateManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        new Login().setVisible(true);
    }
    
}
