/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ConnectionDB;
import dao.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class Attendant {
    //Attributes
    private String username;
    private String password;
    
    //Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String cpf) {
        this.username = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //Methods
    public void insertAtt(){
    
    }
    
    public String attendantConsultation(){

        Connection conexao = ConnectionDB.conector();
        System.out.println(conexao);
        
        //Cria objeto sql
        Query sql = new Query();
        
        try {
            PreparedStatement pst = conexao.prepareStatement(sql.selectLogin());
            pst.setString(1, this.username);
            pst.setString(2, this.password);
            ResultSet rs = pst.executeQuery();
            String test = null;
            
            //Verifica se é adm ou não
            while(rs.next()){
                 test = rs.getString("Adm"); 
                 System.out.println(test);
                }
               
            //Adiciona variáveis no sitema
            System.setProperty("login", this.username); 
            System.setProperty("password", this.password);
            System.setProperty("power", test);
            
            //se existir a pessoa
            if (test!=null){
                return "OK";
            }else{
                return "Usuário ou senha incorreto(s)!";
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return "Lascou";
        }
    }
}
