package backend;

import java.util.Scanner;

public class Input {
	public String Admission_Number;
	public String Roll_Number;
	public String Name;
	public String Photo;
	public String Gender;
 	public String Date_of_Birth;
	public String Blood_Group;
	public String Nationality;
	public String Date_of_Joining;
	public String Address;
	public String Father_Name;
	public String Mother_Name;
	public String Phone_Number;
	public String Email;
	DataBase dataBase = new DataBase();
	Scanner input = new Scanner(System.in);
	
	void Option(int option) {
		if(option == 1) {
			String Query = "SELECT * FROM `student`";
			dataBase.Read(Query);
		}
		else if (option == 2) {
			display();
			String Query = "INSERT INTO `student`"
					+ " (`Admission Number`, `Roll Number`, `Name`, `Photo`, `Gender`, `Date of Birth`, `Blood Group`, `Nationality`, `Date of Joining`, `Address`, `Father Name`, `Mother Name`, `Phone Number`, `Email`)"
					+ "	VALUES ('"+Admission_Number+"', '"+Roll_Number+"',"+Name+","+Photo+","+Gender+","+Date_of_Birth+","+Blood_Group+","+Nationality+","+Date_of_Joining+","+Address+","+Father_Name+","+Mother_Name+","+Phone_Number+","+Email+") ";
			dataBase.add(Query);
		}else if (option == 3) {
			
			String Query = "UPDATE `student` SET `"
					+ "Admission Number` = '"+Admission_Number+"', `Name` = '"+Roll_Number+"', `Photo` = '"+Photo+"', `Gender` = '"+Gender+"', `Date of Birth` = '"+Date_of_Birth+"', `Blood Group` = '"+Blood_Group+"', `Date of Joining` = '"+Date_of_Joining+"', `Address` = '"+Address+"', `Father Name` = '"+Father_Name+"', `Mother Name` = '"+Mother_Name+"', `Phone Number` = '"+Phone_Number+"', `Email` = '"+Email+"'";
			
			Query+= " WHERE `student` . `Admission Number` = '"+Admission_Number+"', `Name` = '"+Roll_Number+"', `Photo` = '"+Photo+"', `Gender` = '"+Gender+"', `Date of Birth` = '"+Date_of_Birth+"', `Blood Group` = '"+Blood_Group+"', `Date of Joining` = '"+Date_of_Joining+"', `Address` = '"+Address+"', `Father Name` = '"+Father_Name+"', `Mother Name` = '"+Mother_Name+"', `Phone Number` = '"+Phone_Number+"', `Email` = '"+Email+"'";
			dataBase.Update(Query);
		}else if(option == 4) {
			System.out.println("Enter number");
			String temp = input.nextLine();
			String Query = "DELETE FROM `student` WHERE `student`.`Roll Number` = '"+temp+"'";
			dataBase.delete(Query);
		}
		
	}
	
	void display() {

		System.out.print("Roll Number : ");
		Roll_Number = input.nextLine();

		System.out.print("Admission Number : ");
		Admission_Number = input.nextLine();
		
		System.out.print("Name : ");
		Name = input.nextLine();
		
		System.out.print("Photo : ");
		Photo = input.nextLine();
		
		System.out.print("Gender : ");
		Gender = input.nextLine();
		
		System.out.print("Date of Birth : ");
		Date_of_Birth = input.nextLine();
		
		System.out.print("Blood Group  : ");
		Blood_Group = input.nextLine();
		
		System.out.print("Nationality  : ");
		Nationality = input.nextLine();
		
		System.out.print("Date of Joining : ");
		Date_of_Joining = input.nextLine();
		
		System.out.print("Address : ");
		Address = input.nextLine();
		
		System.out.print("Father Name : ");
		Father_Name = input.nextLine();
		
		System.out.print("Mother Name : ");
		Mother_Name = input.nextLine();
		
		System.out.print("Phone Number : ");
		Phone_Number = input.nextLine();
		
		System.out.print("Email : ");
		Email = input.nextLine();		
	}	
}