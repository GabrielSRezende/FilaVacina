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
    private int cod;
    private String username;
    private String password;
    private boolean adm;
    
    public Attendant(){
        this.cod = 0;
    }
    
    //Getters and setters
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

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
    
    public boolean getAdm() {
        return adm;
    }
    
    public void setAdm(boolean adm) {
        this.adm = adm;
    }
    
    //Methods
    public void insertAtt(){
    
    }
    
    public String checkAccess(){
        //Chamando a classe de conexão 
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = ConnectionDB.conector();
        System.out.println(conexao);
        
        //Cria objeto sql
        Query sql = new Query();
        
        try {
            pst = conexao.prepareStatement(sql.selectLogin());
            pst.setString(1, this.username);
            pst.setString(2, this.password);
            rs = pst.executeQuery();
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
            
            return "OK";
            
        } catch (Exception e) {
            System.out.println(e);
            return "Usuário ou senha incorreto(s)!";
        }
    }
}
