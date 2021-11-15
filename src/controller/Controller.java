/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Attendant;
import view.LoginScreen;
import view.MenuScreen;

/**
 *
 * @author gabri
 */
public class Controller {
    //Faz contato com o model para verificar se existe esse usuário
    public String captureAccess(String user, String pass){
        Attendant attendant = new Attendant();
        attendant.setUsername(user);
        attendant.setPassword(pass);
        
        String very = attendant.attendantConsultation();
        if("OK".equals(very)){
            MenuScreen main = new MenuScreen();
            main.setVisible(true); 
            return "";
        } else {
            return very;
        }  
    }   
}
