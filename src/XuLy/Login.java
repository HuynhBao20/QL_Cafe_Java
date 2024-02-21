/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XuLy;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Bao
 */
public class Login {
    public String User, Pass;
    private Boolean fasle;

    public void setUser(String User) {
        this.User = User;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public Login() {
        User = Pass = "";
    }

    public String getUser() {
        return User;
    }

    public String getPass() {
        return Pass;
    }

    public Login(String User, String Pass) {
        this.User = User;
        this.Pass = Pass;
    }
    public Boolean IsLogin(String User, String Pass)
            {
                Connection cn;
                try {
                    String url = "jdbc:sqlserver://DESKTOP-8ABG3TS:1433;databaseName=QL_CAFE";
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    cn = DriverManager.getConnection(url, User, Pass);
                    return true;
                } catch (Exception e) {
                    return fasle;
                }
            }
    
}
