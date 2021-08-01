package Backend;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.Connection;

public class DataBase {

	public Connection connection;
	public Statement statement;
	public ResultSet resultset;
	
	//connect database
	private void Connect() {
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
			resultset = statement.executeQuery(Query);
			while (resultset.next()) {
				
				//retrive by column name
				String Roll_Number = resultset.getString("Roll Number");
				String Admission_Number = resultset.getString("Admission Number");
				String Name = resultset.getString("Name");
				String Photo = resultset.getString("Photo");
				String Gender = resultset.getString("Gender");
				String Date_of_Birth = resultset.getString("Date of Birth");
				String Blood_Group = resultset.getString("Blood Group");
				String Nationality = resultset.getString("Nationality");
				String Date_of_Joining = resultset.getString("Date of Joining");
				String Address = resultset.getString("Address");
				String Father_Name = resultset.getString("Father Name");
				String Mother_Name = resultset.getString("Mother Name");
				String Phone_Number = resultset.getString("Phone Number");
				String Email = resultset.getString("Email");
			
				//Display the Values
				System.out.println("Roll Number \t  : "+Roll_Number);
				System.out.println("Admission Number \t  : "+Admission_Number);
				System.out.println("Name \t  : "+Name);
				System.out.println("Photo \t  : "+Photo);
				System.out.println("Gender \t  : "+Gender);
				System.out.println("Date of Birth \t  : "+Date_of_Birth);
				System.out.println("Blood Group \t  : "+Blood_Group);
				System.out.println("Nationality \t  : "+Nationality);
				System.out.println("Date of Joining \t  : "+Date_of_Joining);
				System.out.println("Address \t  : "+Address);
				System.out.println("Father Name \t  : "+Father_Name);
				System.out.println("Mother Name \t  : "+Mother_Name);
				System.out.println("Phone Number \t  : "+Phone_Number);
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
			resultset = statement.executeQuery(Query);
			System.out.println("Add Successfully");
		} catch (SQLException e) {
			System.out.println(" Unable to Add ");
		}
	
	}
	
	
	//update data
	public void Update(String Query) {
		try {
			resultset = statement.executeQuery(Query);
			System.out.println("Update Successfully");
			while(resultset.next()) {
//				System.out.println("Roll Number : "+resultset.getInt("Roll Number"));
			}
		} catch (SQLException e) {
			System.out.println("Unable to Update");
		}
	}
	
	
	//Delete data
	public void delete(String Query) {
		try {
			resultset = statement.executeQuery(Query);
			System.out.println(" Delete Successfully");
		} catch (SQLException e) {
			System.out.println(" Unable to Delete ");
		}
	}

}