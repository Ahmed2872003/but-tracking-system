/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.*;
/**
 *
 * @author ahmed
 */
public class ProjectM extends Model{
    public ProjectM(){
        super();
        this.modelName = "project";
    }
    
    @Override
    public  ResultSet create(String[] data) throws SQLException{
        
        String dataEdit = String.join("','", data);
        
        
        this.statement.executeUpdate("INSERT INTO project (name, admin_id)\n" +
        "VALUES ('" + dataEdit +"') ");
        
        
        
        return this.statement.executeQuery("SELECT last_insert_id() AS id");
    
    }

    public ResultSet getMembers(int id, String filter)throws SQLException{
        
        String subCondition = "";
        if(!filter.isEmpty()) subCondition+=" AND " + filter;
                
        return this.statement.executeQuery(
                "SELECT id, name, email, role\n" +
                "FROM project_member\n" +
                "INNER JOIN user\n" +
                "ON project_member.member_id = user.id\n" +
                "WHERE project_id = " + id + subCondition);
    }
    
}
