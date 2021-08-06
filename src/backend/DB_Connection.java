/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import backend.DB_Connection;
import frontend.AddNew;
import frontend.Dashboard;
import java.awt.Component;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JOptionPane;
import javax.swing.plaf.RootPaneUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author suc
 */
public class DB_Connection {

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    public DB_Connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
            statement = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found "+ex);
        }catch(SQLException ex){
            System.out.println(" Unable to Connect Database ");
            System.out.println("SQL Exception "+ex);
            System.exit(1);
        }
    }
    public ResultSet tabledatas(){
        try {
            resultSet = statement.executeQuery("select * from `student`");
            return resultSet;
        } catch (SQLException ex) {
            System.err.println("SQL Exception Error");
        }
        return resultSet;
    }
    
    public int AddNewStudent(String Query){
        try {
            statement.executeUpdate(Query);
            return 1;
        } catch (SQLException ex) {
            System.out.println(" Unable to Add Student "+ex);
        return 0;
        }
    }
    
    
    public int DeleteStudent(String Query){
        int isComplete = 0;
        try {
            isComplete = statement.executeUpdate(Query);
        } catch (SQLException ex) {
            System.out.println(" Unable to Delete Student ");
        }
        if(isComplete == 1){
            System.out.println("Added Successfully");
            return 1;
        }else{
            return 0;
        }    
    }
    
    
    public int EditStudent(String Query){
        boolean isComplete = false;
        try {
            isComplete = statement.execute(Query);
        } catch (SQLException ex) {
            System.out.println(" Unable to Edit Student ");
        }
        if(isComplete == true){
            System.out.println("Edit Successfully");
            return 1;
        }else{
            return 0;
        }
    
    }
 
}
