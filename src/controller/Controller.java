/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Attendant;

/**
 *
 * @author gabri
 */
public class Controller {
    //Faz contato com o model para verificar se existe esse usuário
    public String captureAccess(String user, String pass){
        Attendant attendant = new Attendant();
        return attendant.verifyAccess(user, pass);
    }
    
}
