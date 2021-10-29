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
    private String cpf;
    private String password;
    
    //Getters and setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
    
    public String verifyAccess(String user, String pass){
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
            pst.setString(1, user);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            String test = null;
            
            //Verifica se é adm ou não
            while(rs.next()){
                 test = rs.getString("Adm"); 
                }

            //Adiciona variáveis no sitema
            System.setProperty("login", user); 
            System.setProperty("password", pass);
            System.setProperty("power", test);
            
            //se existir a pessoa
            if (test!=null){
                return "Entrou!";
            }else{
                return "Usuário ou senha incorreto(s)!";
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return "Lascou";
        }
    }
}
