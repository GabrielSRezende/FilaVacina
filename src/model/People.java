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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class People {
    //Attributes
    private int cod;
    private String name;
    private String cpf;
    private String birthDate;
    private String cep;
    private String state;
    private String country;
    private String city;
    private String street;
    private String number;
    private String vaccineDate;
    private String healthArea;
    private String vaccinated;
    private int priority;
	
        //Contructor
        public People(){
            this.vaccinated = "false";
        }
    
    //getters and setters 
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws Exception {
        if(isCPF(cpf)==true){
            this.cpf = cpf;
        } else {
            JOptionPane.showMessageDialog(null, "CPF inválido!");
            throw new Exception("CPF inválido!");
        }

    }
    
    public String getBirthDate() {
            return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
 
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(String vaccineDate) {
        this.vaccineDate = vaccineDate;
    }

    public String getHealthArea() {
        return healthArea;
    }

    public void setHealthArea(String healthArea) {
        this.healthArea = healthArea;
    }

    public String getVaccined() {
        return vaccinated;
    }

    public void setVaccined(String vaccined) {
        this.vaccinated = vaccined;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
       
    //Methods
    public String insertPeople(){
        Query sql = new Query();
        Connection conn = (Connection) ConnectionDB.conector();
        if(this.getCod() == 0){
            try {
                JOptionPane.showMessageDialog(null, "Cadastrando o(a): "+this.getName());
                PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql.insertPeople());
                pstm.setString(1, this.getName());
                pstm.setString(2, this.getBirthDate());
                pstm.setString(3, this.getState());
                pstm.setString(4, this.getCity());
                pstm.setString(5, this.getCountry());
                pstm.setString(6, this.getStreet());
                pstm.setString(7, this.getNumber());
                pstm.setString(8, this.getVaccineDate());
                pstm.setString(9, this.getHealthArea());
                pstm.setString(10, this.getVaccined());
                pstm.setInt(11, this.getPriority());
                pstm.setString(12, this.getCep());
                pstm.setString(13, this.getCpf());
                pstm.execute();
                pstm.close();
                return "OK";
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return "Error";
            }
        } else {
            try {
                PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql.updatePeople());
                pstm.setString(1, this.getName());
                pstm.setString(2, this.getBirthDate());
                pstm.setString(3, this.getState());
                pstm.setString(4, this.getCity());
                pstm.setString(5, this.getCountry());
                pstm.setString(6, this.getStreet());
                pstm.setString(7, this.getNumber());
                pstm.setString(8, this.getHealthArea());
                pstm.setInt(9, this.getPriority());
                pstm.setString(10, this.getCep());
                pstm.setString(11, this.getCpf());
                pstm.setInt(12, this.getCod());
                pstm.execute();
                pstm.close();
                return "OK";
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return "Error";
            }
        }
    }
    public void deletePeople(){
        Query sql = new Query();
        Connection conn = (Connection) ConnectionDB.conector();
        try {
                PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql.deletePeople());
                pstm.setInt(1, this.getCod());
                pstm.execute();
                pstm.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }

    public ArrayList selectPeople(){
        Query sql = new Query();
        ArrayList arr = new ArrayList();
        Connection conn = (Connection) ConnectionDB.conector();
        try {
            PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql.selectPeople());
            pstm.setInt(1, this.getCod());
            ResultSet rs = pstm.executeQuery();

            while(rs.next()){
                 String selectCod = rs.getString("CodPeo"); 
                 String selectName = rs.getString("name"); 
                 String selectBirth = rs.getString("birth_date"); 
                 String selectCep = rs.getString("cep"); 
                 String selectState = rs.getString("state"); 
                 String selectCity = rs.getString("city"); 
                 String selectCountry = rs.getString("country"); 
                 String selectStreet = rs.getString("street"); 
                 String selectNumber = rs.getString("number"); 
                 String selectHealth = rs.getString("health_area");  
                 String selectCPF = rs.getString("cpf");
                 arr.add(selectCod);
                 arr.add(selectName);
                 arr.add(selectBirth);
                 arr.add(selectCep);
                 arr.add(selectState);
                 arr.add(selectCity);
                 arr.add(selectCountry);
                 arr.add(selectStreet);
                 arr.add(selectNumber);
                 arr.add(selectHealth);
                 arr.add(selectCPF);
                }
            
            pstm.close();
            return arr;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return arr;
        }
    }

    public void reportPat(){

    }

    public ArrayList vaccinePeo1(){
        Connection conn = (Connection) ConnectionDB.conector();
        ArrayList arr = new ArrayList();
//            String t = "true";
//            this.setVaccinated(t);
           
            
        try {
            PreparedStatement pstm = (PreparedStatement) conn.prepareStatement("SELECT * FROM `vaccine`.`people` WHERE vaccinated = 'false' ORDER BY priority LIMIT 1");
            ResultSet rs = pstm.executeQuery();

            while(rs.next()){
                int code = rs.getInt("CodPeo");
                String fullName = rs.getString("name"); 
                arr.add(code);
                arr.add(fullName);
            }
            return arr;
        } catch (Exception e) {
            System.out.println(e);
            return arr;
        }
    }
    
    public static int age(String dataNasc, String pattern){

        DateFormat sdf = new SimpleDateFormat(pattern);

        Date dataNascInput = null;

        try {

        dataNascInput= sdf.parse(dataNasc);

        } catch (Exception e) {}



        Calendar dateOfBirth = new GregorianCalendar();

        dateOfBirth.setTime(dataNascInput);

        // Cria um objeto calendar com a data atual

        Calendar today = Calendar.getInstance();

        // Obtém a idade baseado no ano

        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);



        dateOfBirth.add(Calendar.YEAR, age);

        if (today.before(dateOfBirth)) {

        age--;

        }

        return age;

        }
        
    public static boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
        }
    
         
    public void setVaccinated(String afalse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

