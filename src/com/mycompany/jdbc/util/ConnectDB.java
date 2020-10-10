/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Admin
 */
public class ConnectDB {
     public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName = DBEmployee";
            String user = "sa";
            String passwork = "saker0905971230";
            return DriverManager.getConnection(url, user, passwork);
        } catch (ClassNotFoundException | SQLException ex) {
           ex.printStackTrace();
        }
        return null;
    }
}
