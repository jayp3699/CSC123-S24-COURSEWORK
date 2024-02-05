import java.util.Scanner;


public class GradeCategorization 
{

	public static void main(String[] args) 
	{
		System.out.println("Jay CSC123 GradeCategorization ");
		
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your numerical grade (0-100):");
		
		
	int grade = scanner.nextInt();
	
	 if (grade >= 90) {
		 
         System.out.println("Grade A");
     } 
	 else if (grade >= 80) {
		 
         System.out.println("Grade B");
     } 
	 else if (grade >= 70) {
		 
         System.out.println("Grade C");
     } 
	 else if (grade >= 60) {
		 
         System.out.println("Grade D");
     } 
	 else {
         System.out.println("Grade F");
     }
	 
	 scanner.close();
	 
	}

}
