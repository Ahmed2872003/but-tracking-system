/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ahmed
 */
public class BugM extends Model {
 
    public BugM(){
        super();
        this.modelName = "bug";
    }
    
    @Override
    public ResultSet create(String[] data) throws SQLException{
        String dataEdit = String.join("','", data);
        
        
        this.statement.executeUpdate("INSERT INTO bug (name, type, priority, level, project_id, developer_id, tester_id, img)\n" +
        "VALUES ('" + dataEdit +"')");
        
        return this.statement.executeQuery("SELECT last_insert_id() AS id");
    }
    
}