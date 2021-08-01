package backend;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.Connection;

public class DataBase {
	public Connection connection;
	public Statement statement;
	
	public DataBase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
			statement = connection.createStatement();
			
		} catch (SQLException e) {
			System.out.println(" Database Not Connected");
		} catch (ClassNotFoundException e) {
			System.out.println(" Class Not Found");
		}	
	}
	
	//read data
	public void Read(String Query) {
		try {
			ResultSet resultset = statement.executeQuery(Query);
			System.out.println(resultset+"fewfe");
			while (resultset.next()) {
				
				//retrive by column name
				String Roll_Number = resultset.getString("Roll Number");
				System.out.println("Roll Number \t  : "+Roll_Number);
				
				String Register_Number = resultset.getString("Register Number");
				System.out.println("Register Number \t  : "+Register_Number);
				
				String Name = resultset.getString("Name");
				System.out.println("Name \t  : "+Name);
				
				String Photo = resultset.getString("Photo");
				System.out.println("Photo \t  : "+Photo);
				
				String Gender = resultset.getString("Gender");
				System.out.println("Gender \t  : "+Gender);
				
				String Date_of_Birth = resultset.getString("Date of Birth");
				System.out.println("Date of Birth \t  : "+Date_of_Birth);
				
				String Blood_Group = resultset.getString("Blood Group");
				System.out.println("Blood Group \t  : "+Blood_Group);
				
				String Nationality = resultset.getString("Nationality");
				System.out.println("Nationality \t  : "+Nationality);
				
				String Date_of_Joining = resultset.getString("Date of Joining");
				System.out.println("Date of Joining \t  : "+Date_of_Joining);
				
				String Address = resultset.getString("Address");
				System.out.println("Address \t  : "+Address);
				
				String Father_Name = resultset.getString("Father Name");
				System.out.println("Father Name \t  : "+Father_Name);
				
				String Mother_Name = resultset.getString("Mother Name");
				System.out.println("Mother Name \t  : "+Mother_Name);
				
				String Phone_Number = resultset.getString("Phone Number");
				System.out.println("Phone Number \t  : "+Phone_Number);
				
				String Email = resultset.getString("Email");
				System.out.println("Email \t  : "+Email);
				
			}
			System.out.println("Read Successfully Completed");
		} catch (SQLException e) {
			System.out.println(" Unabe to Read ");
		}
	}
	

	//add data
	public void add(String Query) {
		try {
			int temp = statement.executeUpdate(Query);
			if(temp == 1)
				System.out.println("Add Successfully");
			else
				System.out.println("Unable to Add New Student");
		} catch (SQLException e) {
			System.out.println(" Unable to Add ");
		}
	
	}
	
	
	//update data
	public void Update(String Query) {
		try {
			int temp = statement.executeUpdate(Query);
			if (temp == 1)
				System.out.println("Update Successfully");
			else
				System.err.println("Unable to Update !!! . Please delete and Create new Student");
		} catch (SQLException e) {
			System.out.println("Unable to Update");
		}
	}
	
	
	//Delete data
	public void delete(String Query) {
		try {
			int temp = statement.executeUpdate(Query);
			if(temp == 1)
				System.out.println(" Delete Successfully");
			else 
				System.out.println("Student Not Found !!!");
		} catch (SQLException e) {
			System.out.println(" Unable to Delete ");
		}
	}

}