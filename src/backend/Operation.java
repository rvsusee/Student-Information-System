package backend;

import java.util.Scanner;

public class Operation {
	String[] inputData = new String[13];
	String[] inputOption = {"Register Number", "Name", "Photo", "Gender", "Date of Birth", "Blood Group", "Nationality", "Date of Joining", "Address", "Father Name", "Mother Name", "Phone Number", "Email"};

	DataBase dataBase = new DataBase();
	Scanner input = new Scanner(System.in);

	void Option(int option) {
		if(option == 1) {
			String Query = "SELECT * FROM `student`";
			dataBase.Read(Query);
		}
		else if (option == 2) {
			display();

			String Query = "INSERT INTO `student` (`"+inputOption[0]+"`, `"+inputOption[1]+"`, `"+inputOption[2]+"`, `"+inputOption[3]+"`, `"+inputOption[4]+"`, `"+inputOption[5]+"`, `"+inputOption[6]+"`, `"+inputOption[7]+"`, `"+inputOption[8]+"`, `"+inputOption[9]+"`, `"+inputOption[10]+"`, `"+inputOption[11]+"`, `"+inputOption[12]+"`) VALUES ('"+inputData[0]+"', '"+inputData[1]+"', '"+inputData[2]+"', '"+inputData[3]+"', '"+inputData[4]+"', '"+inputData[5]+"', '"+inputData[6]+"', '"+inputData[7]+"', '"+inputData[8]+"', '"+inputData[9]+"', '"+inputData[10]+"', '"+inputData[11]+"', '"+inputData[12]+"');";

			System.out.println(Query);
			dataBase.add(Query);
			
		}else if (option == 3) {
			System.out.println("Enter Register Number : ");
			String temp = input.nextLine(); 
			display();
			
			//check query
			String Query = "UPDATE `student` SET "
					+ "`"+inputOption[0]+"` = '"+temp+"', `"+inputOption[1]+"` = '"+inputData[1]+"',`"+inputOption[2]+"` = '"+inputData[2]+"', `"+inputOption[3]+"` = '"+inputData[3]+"', `"+inputOption[4]+"` = '"+inputData[4]+"', `"+inputOption[5]+"` = '"+inputData[5]+"', `"+inputOption[6]+"` = '"+inputData[6]+"',`"+inputOption[7]+"` ='"+inputData[7]+"' ,`"+inputOption[8]+"` = '"+inputData[8]+"', `"+inputOption[9]+"` = '"+inputData[9]+"', `"+inputOption[10]+"` = '"+inputData[10]+"', `"+inputOption[11]+"` = '"+inputData[11]+"', `"+inputOption[12]+"` = '"+inputData[12]+"'";
			
				   Query+= " WHERE `student` .`"+inputOption[0]+"` = '"+inputData[0]+"', `"+inputOption[1]+"` = '"+inputData[1]+"',`"+inputOption[2]+"` = '"+inputData[2]+"', `"+inputOption[3]+"` = '"+inputData[3]+"', `"+inputOption[4]+"` = '"+inputData[4]+"', `"+inputOption[5]+"` = '"+inputData[5]+"', `"+inputOption[6]+"` = '"+inputData[6]+"',`"+inputOption[7]+"` ='"+inputData[7]+"' ,`"+inputOption[8]+"` = '"+inputData[8]+"', `"+inputOption[9]+"` = '"+inputData[9]+"', `"+inputOption[10]+"` = '"+inputData[10]+"', `"+inputOption[11]+"` = '"+inputData[11]+"', `"+inputOption[12]+"` = '"+inputData[12]+"'";
			dataBase.Update(Query);
		}else if(option == 4) {
			System.out.println("Enter Register Number");
			String temp = input.nextLine();
			String Query = "DELETE FROM `student` WHERE `student`.`Register Number` = '"+temp+"'";
			dataBase.delete(Query);
		}
		
	}
	
	void display() {
		for (int i = 0; i < inputOption.length; i++) {
			getUserInput(i);
		}
		checkNotNull();
	}
	void getUserInput(int i) {
		System.out.println(" Enter "+inputOption[i]+" : ");	
		inputData[i] = input.nextLine();
	}
	void checkNotNull() { // check null
		for (int i = 0; i < inputData.length; i++) {
			if(inputData[i] == "") {
				getUserInput(i);
			}
		}
	}
}