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
			String[] outputOption = {"Register Number","Name","Photo","Gender","Date of Birth","Blood Group","Nationality","Date of Joining","Address","Father Name","Mother Name","Phone Number","Email"};

			while (resultset.next()) {
				for(int i = 0; i < outputOption.length; i++) {
					System.out.println(outputOption[i]+" : "+resultset.getString(outputOption[i]));
				}
			}
			System.out.println("Read Successfully Completed");
		} catch (SQLException e) {
			System.out.println(" Unabe to Read "+e);
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
			System.out.println(" Unable to Add "+e);
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
			System.out.println("Unable to Update"+e);
		}
	}
	
	//fetch data
	public void fetchData(String data) {
		try {
			ResultSet temp = statement.executeQuery("SELECT * FROM `student` where 'Register Number ="+data+"'");
		} catch (SQLException e) {
		
			e.printStackTrace();
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