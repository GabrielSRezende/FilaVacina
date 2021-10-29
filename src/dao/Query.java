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
    public String selectLogin(){
        var sql = "SELECT * FROM `vaccine`.`employees` WHERE Username=? AND Password=?;";
        return sql;
    }
}
