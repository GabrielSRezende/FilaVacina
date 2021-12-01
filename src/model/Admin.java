/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import dao.ConnectionDB;
import dao.Query;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */

public class Admin extends Attendant{
    
    //Methods
    public String insertEmployee(){
        Query sql = new Query();
        Connection conn = (Connection) ConnectionDB.conector();
        
        if(super.getCod() == 0){
            try {
                JOptionPane.showMessageDialog(null, "Cadastrando o novo colaborador: "+super.getUsername());
                PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql.insertEmployee());
                pstm.setString(1, super.getUsername());
                pstm.setString(2, super.getPassword());
                pstm.setString(3, String.valueOf(super.getAdm()));
                pstm.execute();
                pstm.close();
                return "OK";
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return "Error";
            }
        } else {
            try {
                PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql.updateEmployee());
                pstm.setString(1, super.getUsername());
                pstm.setString(2, super.getPassword());
                pstm.setString(3, String.valueOf(super.getAdm()));
                pstm.setInt(4, super.getCod());
                pstm.execute();
                pstm.close();
                return "OK";
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return "Error";
            }
        }    
    } 
  
    public ArrayList selectEmployee(){
        Query sql = new Query();
        ArrayList arr = new ArrayList();
        Connection conn = (Connection) ConnectionDB.conector();
        try {
            PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql.selectEmployee());
            pstm.setInt(1, super.getCod());
            ResultSet rs = pstm.executeQuery();

            while(rs.next()){
                 String selectCod = rs.getString("CodEmp"); 
                 String selectUser = rs.getString("Username"); 
                 String selectPass = rs.getString("Password"); 
                 String selectAdm = rs.getString("Adm");     
                 arr.add(selectUser);
                 arr.add(selectPass);
                 arr.add(selectAdm);
                 arr.add(selectCod);
                }
            
            pstm.close();
            return arr;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return arr;
        }
    }
    
    public void deleteEmployee(){
        Query sql = new Query();
        Connection conn = (Connection) ConnectionDB.conector();
        try {
                PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql.deleteEmployee());
                pstm.setInt(1, super.getCod());
                pstm.execute();
                String selectUser = null;
 
                pstm.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }
}
