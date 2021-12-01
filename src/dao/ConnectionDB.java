package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionDB {
    private final static String URL = "jdbc:mysql://localhost:3306/vaccine";
    private final static String USUARIO = "root";
    private final static String SENHA = "root";

    public static Connection conector(){
        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            return conexao;
        }catch(SQLException e1){
            JOptionPane.showMessageDialog(null, "Falha na conexão com o banco de dados: "+e1);
            return null;
        }
    }

    ConnectionDB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
