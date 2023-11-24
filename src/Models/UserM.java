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
import Models.Model;



public class UserM extends Model{
    
    public UserM(){
        super();
        this.modelName = "user";
    }
    
    @Override
    public  ResultSet create(String[] data) throws SQLException{
        
        String dataEdit = String.join("','", data);
        
        
        this.statement.executeUpdate("INSERT INTO user (name, email, password, role)\n" +
        "VALUES ('" + dataEdit +"')");
        
        return this.statement.executeQuery("SELECT last_insert_id() AS id");
    
    }
    
    public ResultSet getProjects(int id) throws SQLException{
        return this.statement.executeQuery(
                "SELECT id, name\n" +
                "FROM project_member\n" +
                "INNER JOIN project\n" +
                "ON project.id = project_member.project_id\n" +
                "WHERE member_id = " + id);
    }
    
    
    public void addToProject(String[] data) throws SQLException{
        
        String dataEdit = String.join("','", data);
        
        this.statement.executeUpdate("INSERT INTO project_member\n" +
                                     "VALUES ('" + dataEdit + "')");
    }
    
    
    public void deleteFromProject(int id, int projectId)throws SQLException{
        this.statement.executeUpdate("DELETE FROM project_member\n" + 
                                    "WHERE project_id= "+ projectId + " AND member_id = "+id 
                );
    }
}
