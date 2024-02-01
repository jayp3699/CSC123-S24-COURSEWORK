
public class LAB3 {

	public static void main(String[] args) {
		System.out.println("Jay CSC123 Lab3");
		
		
		System.out.println();
		
		
//                              TASK1 IF STATEMENT
		
	int number = 12;
	if(number>10) {
		System.out.print("The number is greater than 10");
	}
	
	
System.out.println();
	
	
//                               TASK2 ELSE STATEMENT
	
	
	int elsenumber = 8;
	if(elsenumber>10) {
		System.out.println("The number is greater than 10");
	}
	else {
		System.out.println("The number is less than 10");
	}
	
	
//                               TASK3 ELSE IF MULTIPLE CONDITION
	
	int time = 21;
	
	if(time>=17 && time<20) {
		System.out.println("it will be evening outside.");
	}
	
	else if (time>=12 && time<17) {
		System.out.println("It will be afternoon outside.");
	}
	
	else {
		System.out.println("It will be morning or late night.");
	}
	
	}

}
