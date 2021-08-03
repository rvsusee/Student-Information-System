package backend;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.Query;

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
	public void Read(String Query,String inputOption[]) {
		try {
			ResultSet resultset = statement.executeQuery(Query);

			while (resultset.next()) {
				for(int i = 0; i < inputOption.length; i++) {
					System.out.println(inputOption[i]+" : "+resultset.getString(inputOption[i]));
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
	public String fetchData(String RegNo) {
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM student WHERE `Register Number`='"+RegNo+"'");
			while(resultSet.next()) {
				if(resultSet.getString("Register Number") == null) {
					System.out.println("Register Number : "+RegNo+" Not Found");
					Operation operation = new Operation();
					operation.Option(3);
				}
			}
		
		} catch (SQLException e) {
			System.out.println(" Error Occur"+e);
		}
		return "";
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