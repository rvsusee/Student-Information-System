package backend;

import java.util.Scanner;

public class Dashboard {
	
	void display() {
		
		Scanner scanner = new Scanner(System.in);
		Input input = new Input();
		
		System.out.println(" Menu");
		System.out.println(" 1.View Student \n 2.New Students \n 3.Update Student \n 4.Delete Studnet \n 5.Exit \n");
		System.out.print(" Enter Option : ");
		int option = scanner.nextInt();
		
		if(option == 1 || option == 2 || option == 3 || option == 4) {
			input.Option(option);
			display();
			
		}else if(option == 5) {
			System.out.println("Exiting ...");
			System.exit(1);
		
		}else {
			System.out.println(" Please Enter Below Option !!!");
			display();
		
		}
	}
	

	public static void main(String[] args) {
		Dashboard dashboard = new Dashboard();
		dashboard.display();
		
	}
}


//			while(resultSet.next()) {
//			
//				//retrive by column name
//				int Admission_Number = resultSet.getInt("Admission Number");
//				int	Roll_Number = resultSet.getInt("Roll Number");
//				String	Name = resultSet.getString("Name");
//				String	Photo = resultSet.getString("Photo");
//				String	Gender = resultSet.getString("Gender");
//				String	Date_of_Birth = resultSet.getString("Date of Birth");
//				String	Blood_Group = resultSet.getString("Blood Group");
//				String	Nationality = resultSet.getString("Nationality");
//				String	Date_of_Joining = resultSet.getString("Date of Joining");
//				String	Address = resultSet.getString("Address");
//				String	Father_Name = resultSet.getString("Father Name");
//				String	Mother_Name = resultSet.getString("Mother Name");
//				int	Phone_Number = resultSet.getInt("Phone Number");
//				String	Email = resultSet.getString("Email");
//			
//				//Display the Values
//				System.out.println("Admission Number \t  : "+Admission_Number);
//				System.out.println("Roll Number \t  : "+Roll_Number);
//				System.out.println("Name \t  : "+Name);
//				System.out.println("Photo \t  : "+Photo);
//				System.out.println("Gender \t  : "+Gender);
//				System.out.println("Date of Birth \t  : "+Date_of_Birth);
//				System.out.println("Blood Group \t  : "+Blood_Group);
//				System.out.println("Nationality \t  : "+Nationality);
//				System.out.println("Date of Joining \t  : "+Date_of_Joining);
//				System.out.println("Address \t  : "+Address);
//				System.out.println("Father Name \t  : "+Father_Name);
//				System.out.println("Mother Name \t  : "+Mother_Name);
//				System.out.println("Phone Number \t  : "+Phone_Number);
//				System.out.println("Email \t  : "+Email);
//				
//			}
//			//clean up environment
//			resultSet.close();
//			statement.close();
//			connection.close();
//	
//		}catch (Exception e) {
//			System.out.println("Error Occuring :y"+e);
//		}
//	}
//}
