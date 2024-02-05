
public class Lab5_Loops 
{

	public static void main(String[] args) 
	{
		System.out.println("Jay CSC123 Lab5 Loops ");
		
		System.out.println();

		
//                    Task1 Exploring 'for'Loops
		
//1. Create a Java program where students write a `for` loop to print numbers from 1 to 10.
//2. Modify the loop to count in steps (e.g., count by 2s).
//3. Experiment with different start points, end points, and step sizes.
		System.out.println("Task 1");
		
		System.out.println();
		
	for (int i = 1; i <= 10; i++) 
	{
            System.out.print(i + " ");
    }
	System.out.println();
	
	for (int i = 1; i <= 10; i += 2) 
	{
        System.out.print(i + " ");
    }
	
	System.out.println();
	
	for (int i = 5; i <= 20; i += 5) 
	{
        System.out.print(i + " ");
    }
	System.out.println();
	
//                       Task2 While Loops
	
/*1. Write a `while` loop that continues to add numbers (e.g., starting from 1) until a sum limit is reached.
  2. Display each addition step and the running total.
  3. Test different conditions and limits to see how the `while` loop behaves.
 */
	
	System.out.println();
	
	System.out.println("Task 2");
	
	System.out.println();
	
	
	int sumLimit = 50;  // Set the sum limit directly

    int sum = 0;
    int number = 1;
    
    while (sum <= sumLimit) 
    {
    	System.out.println("Adding " + number + " (Running Total: " + sum + ")");
        sum += number;
        number++;
    }
    
    
 //                       Task3 Combining Loops with Conditional Statements
    
/*1. Create a program that uses a loop to iterate through numbers (e.g., 1 to 50).
  2. Inside the loop, use `if` or `else if` statements to categorize numbers (e.g., print "Even" for even numbers and "Odd" for odd numbers).
  3. Encourage creativity in categorization (e.g., multiples of a certain number).
  */

    System.out.println("\nTask 3");
	
    System.out.println();
	
    for (int i = 1; i <= 50; i++) 
    {
        if (i % 2 == 0) 
        {
            System.out.println(i + " is Even");

        } else 
        {
        System.out.println(i + " is Odd");
        }
        if (i % 5 == 0) 
        {
            System.out.println(i + " is a Multiple of 5");
        }
    }	
    
   
	}
}
	
