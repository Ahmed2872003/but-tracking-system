/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import java.sql.*;
import database.DB;
import java.io.Serializable;
/**
 *
 * @author ahmed
 */
public class User implements Serializable{
    
    private Integer id = null;
    private String name = null;
    private String email = null;
    private String password = null;
    private String role = null;
    
    
    public User(final Integer id, final String name, final String email, final String password, final String role){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    public static User toUser(final ResultSet userDataSet){
        try{
            return new User(
          userDataSet.getInt("id"),
             userDataSet.getString("name"), 
             userDataSet.getString("email"),
             userDataSet.getString("password"), 
             userDataSet.getString("role"));
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean is(String role){
        return this.role.equals(role);
        
    }
    
    
    // getters
    public Integer getID(){ return this.id; }
    public String getName(){ return this.name; }
    public String getEmail(){ return this.email; }
    public String getPassword(){ return this.password; }
    public String getRole(){ return this.role; }
    
    


}
