/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Me
 */
public class DBConnect {
    Connection con;
    ResultSet res;
    //Connection con;     //connection object
    Statement stmt;     //statement object
    //ResultSet rs;       //ResultSet object

    public Connection getConnection(){
        String url = "jdbc:mysql://kunet:3306/db_k1653239";
        String uname = "k1653239";
        String pwd = "black88piano";
        try {
            //setup the driver
            con = DriverManager.getConnection(url, uname, pwd);
            System.out.println("Connected");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
