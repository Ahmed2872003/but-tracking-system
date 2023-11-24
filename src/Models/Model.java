/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import database.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import User.User;

/**
 *
 * @author ahmed
 */
abstract public class Model {
    public static final Connection con = DB.connection;
    public Statement statement = null;
    protected String modelName = null;
    
    public Model(){
        try{
            this.statement = Model.con.createStatement();
        }catch(Exception e){
            System.out.println(e.getMessage());
        } 
    }
    
    
    
    public  ResultSet getById(int id) throws SQLException{
         return this.statement.executeQuery("select * from "+ this.modelName +" where id='"+id+"'");
     };

    public ResultSet get(String filter) throws SQLException{
        String condition = "";
        
        if(!filter.isEmpty()) condition+=" where " + filter;
        
        return this.statement.executeQuery("select * from "+ this.modelName + condition);
    }
    
    public  abstract ResultSet create(String[] data) throws SQLException;
    
    public void update(String newData, String filter) throws SQLException{
        this.statement.executeUpdate("UPDATE "+ this.modelName +
        "\nSET " + newData +
        "\nWHERE " + filter);
    }
    
    public void delete(String filter) throws SQLException{
        this.statement.executeUpdate("DELETE FROM "+this.modelName +
                                    "\nWHERE " + filter);
    }
}
