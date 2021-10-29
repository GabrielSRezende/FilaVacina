/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import view.LoginScreen;

/**
 *
 * @author gabri
 */

public class Aplication {
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(() -> {
            new LoginScreen().setVisible(true);
        });
    }
}
