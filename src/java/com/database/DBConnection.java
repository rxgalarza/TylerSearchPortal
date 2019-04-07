/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rodolfo
 */
public class DBConnection implements Serializable{
    
    private final String db_url         = "jdbc:mysql://127.0.0.1:9306";
    private final String db_username    = "";
    private final String db_password    = "";
            
    private Connection connection       = null;
    protected PreparedStatement ps        = null;
    protected ResultSet         rs        = null;
    
    
    public Connection connect() throws SQLException{
        
        DriverManager.registerDriver(new Driver());
        connection = (Connection) DriverManager.getConnection(db_url, db_username, db_password);
        return connection;
    }
    
    
    public void disconnect(){
        try{
            connection.close();
            ps.close();
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
   }
    
}
