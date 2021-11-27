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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class Line {
    private People people;
    private int quantity;
    
    public Line(){
        this.people = new People();
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
     
    public ArrayList report(String dateIni, String dateFin){
        //this.people.setVaccineDate(dateIni);
        Query sql = new Query();
        ArrayList arr = new ArrayList();
        ArrayList arr2 = new ArrayList();
        ArrayList arr3 = new ArrayList();
        
        com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) ConnectionDB.conector();
//        arr3.add("SELECT * FROM `vaccine`.`people` WHERE vaccine_date = ? AND birth_date>");
//        for (int i = 0; i < 3; i++) {
            
            try {
                Calendar cal = Calendar.getInstance();
                DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
                Date dt1 = df.parse (dateIni);
                Date dt2 = df.parse (dateFin);
                Date hoje = new Date();
                cal.setTime (dt1);
                int cont = 0;
                int cont2 = 0;
                int cont3 = 0;
                int Data01cont = 0 , Data02cont = 0, Data03cont = 0, Data04cont = 0;
                int age = 0;
                for (Date dt = dt1; dt.compareTo (dt2) <= 0; ) {
                    String dateText = df.format (dt);

                    com.mysql.jdbc.PreparedStatement pstm = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("SELECT * FROM `vaccine`.`people` WHERE vaccine_date = ?");
                    pstm.setString(1, dateText);
                    ResultSet rs = pstm.executeQuery();

                    //int dias = Days.daysBetween(dateIni, dateFin).getDays();
                    while(rs.next()){
                        this.people.setCod(rs.getInt("CodPeo")); 
                        age = this.people.age(rs.getString("birth_date"), "yyyy-MM-dd");
                        this.people.setVaccineDate(rs.getString("vaccine_date")); 
                        if(age>=90){
                          Data01cont++;  
                        } else if(age>=70) {
                          Data02cont++;
                        } else if(age>=50){
                          Data03cont++;
                        } else { 
                          Data04cont++;  
                        }

                        }
                    
                    arr2.add("Data: "+dateText+"\n"+"A cima de noventa: "+Data01cont+"\n"+"A cima de setenta: "+Data02cont+"\n"+"A cima de cinquenta: "+Data03cont+"\n"+"Os demais: "+Data04cont+"\n"+"-------------------------------------------");
                    Data01cont = 0;
                    Data02cont = 0;
                    Data03cont = 0;
                    Data04cont = 0;
                    cal.add (Calendar.DATE, +1);
                    dt = cal.getTime();
                }




                //pstm.close();
                return arr2;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return arr;
            }
    }
}