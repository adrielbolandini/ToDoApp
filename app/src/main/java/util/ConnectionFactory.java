/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author adriel
 */
public class ConnectionFactory {
    
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/todoapp";
    public static final String USER = "root";
    public static final String PASSWORD = "12345";
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return  DriverManager.getConnection(URL+"?" +
                                   "user="+USER+"&"+"password="+PASSWORD);
        } catch (Exception ex) {
            throw new RuntimeException("Erro na conexão com o DATABASE:", ex);
        }
    }
    
    public static void closeConnection(Connection connection){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o DATABASE:", ex);
        }
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement){
        try {
            if (connection != null) {
                connection.close();
            }
            
            if (statement != null) {
                statement.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o DATABASE:", ex);
        }
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet){
        try {
            if (connection != null) {
                connection.close();
            }
            
            if (statement != null) {
                statement.close();
            }
            
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o DATABASE:", ex);
        }
    }
    
}
