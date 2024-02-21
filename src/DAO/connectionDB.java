/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author Bao
 */
public class connectionDB {
    private Connection cn;
     public Connection getCn(String User, String Pass) {
        try {
            String url = "jdbc:sqlserver://DESKTOP-8ABG3TS:1433;databaseName=QL_CAFE";
            String user = User;
            String pass = Pass;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection(url, user, pass);
            //System.out.println("Kết nối csdl thành công");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Kết nối csdl không thành công");
        }
        return cn;
    }
     public void close(){
        try {
            this.cn.close();
        } catch (SQLException e) {
        }
    }
    
    public ResultSet executeQuery(String sql){
        ResultSet rs = null;
        try {
            Statement stm = cn.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
        }
        return rs;
    }
    
    public int executeUpdate(String sql){
        int i = -1;
        try {
            Statement stm = cn.createStatement();
            i = stm.executeUpdate(sql);
        } catch (SQLException e) {
        }
        return i;
    }

    public PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
