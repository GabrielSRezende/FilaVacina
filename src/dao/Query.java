/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author gabri
 */
public class Query {
    //Employee
    public String selectLogin(){
        var sql = "SELECT * FROM `vaccine`.`employees` WHERE Username=? AND Password=?;";
        return sql;
    }
    public String insertEmployee(){
        var sql = "INSERT INTO `vaccine`.`employees` (Username, Password, Adm) VALUES (?,?,?)";
        return sql;
    }
    public String selectEmployee(){
        var sql = "SELECT * FROM `vaccine`.`employees` WHERE CodEmp=?";
        return sql;
    }
    public String updateEmployee(){
        var sql = "UPDATE `vaccine`.`employees` SET Username=?, Password=?, Adm=? WHERE CodEmp=?";
        return sql;
    }
    public String deleteEmployee(){
        var sql = "DELETE FROM `vaccine`.`employees` WHERE CodEmp=?";
        return sql;
    }
    
    //People
    public String insertPeople(){
        var sql = "INSERT INTO `vaccine`.`people` (name, birth_date, state,city, country,street,number,vaccine_date,health_area,vaccinated,priority,cep) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        return sql;
    }
    
    public String deletePeople(){
        var sql = "DELETE FROM `vaccine`.`people` WHERE CodPeo=?";
        return sql;
    }
    
    public String selectPeople(){
        var sql = "SELECT * FROM `vaccine`.`people` WHERE CodPeo=?";
        return sql;
    }
    
    public String updatePeople(){
        var sql = "UPDATE `vaccine`.`people` SET name=?, birth_date=?, state=?, city=?, country=?, street=?, number=?, health_area=?, priority=?, cep=? WHERE CodPeo=?";
        return sql;
    }
}
