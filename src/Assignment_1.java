

//Jay Prajapati (jprajapati2@toromail.csudh.edu)

import java.util.Scanner;

public class Assignment_1 {

	public static void main(String[] args)
	{
		System.out.println("Jay CSC123 Assignment1 ");
		
		System.out.println();
		
// Challenge 1: Coin Counter
		
Scanner scanner = new Scanner(System.in);

System.out.print("Please enter the number of pennies: ");
int pennies = scanner.nextInt();

System.out.print("Please enter the number of nickels: ");
int nickels = scanner.nextInt();

System.out.print("Please enter the number of dimes: ");
int dimes = scanner.nextInt();

System.out.print("Please enter the number of quarters: ");
int quarters = scanner.nextInt();

int totalCents = (pennies * 1) + (nickels * 5) + (dimes * 10) + (quarters * 25);

int dollars = totalCents / 100;
int remainingCents = totalCents % 100;

System.out.println("You have " + dollars + " dollars and "  + remainingCents + " cents.");

scanner.close();


// Challenge 2: Change Maker 

System.out.println("\n Challenge2 Change Maker");

int dollarsCM2 = 4;
int cents = 37;

int totalCentsCM = (dollars * 100) + cents;

int quartersCM = totalCents / 25;
int remainingCentsAfterQuarters = totalCents % 25;

int dimesCM = remainingCentsAfterQuarters / 10;
int remainingCentsAfterDimes = remainingCentsAfterQuarters % 10;

int nickelsCM = remainingCentsAfterDimes / 5;
int penniesCM = remainingCentsAfterDimes % 5;

System.out.println("\n" + dollars + " dollars and " + cents + " cents are:");
System.out.println("\n" + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, and " + pennies + " pennies");


// Challenge 3 Gravity Calculator

double initialPosition = 500; // Example initial position in meters
double time = 2; 
double acceleration = -9.81; // acceleration due to gravity in m/s^2
double initialVelocity = 0;
double timeSquared = time * time;

double distance = 0.5 * acceleration * timeSquared + (initialVelocity * time) + initialPosition;

System.out.println("\n"+"The object was dropped from " + initialPosition + " meters and has fallen " +
        distance + " meters in " + time + " seconds.");
System.out.println("\n"+ "The distance of the object from the ground now is " + (initialPosition - distance));

// Challenge 4  Version Management

//                      Short Summary on Version management by git


/* 

	Git version control is essential to contemporary software development because it tracks code changes, promotes effective teamwork, and maintains project integrity. The main ideas of the given article are condensed into this summary. Software developers must practice version control, also referred to as source code management, since it makes it possible to systematically record code changes. The article centers on Git, Linus Torvalds's popular distributed version control system developed in 2005. It is highlighted in particular because of its widespread use and strong features. Git gives developers the ability to track and log changes, including who made what and when. It makes it simple to navigate between different code versions, which is helpful for tasks like going back to a previous state or identifying code appearance at particular project milestones. The article makes a point of highlighting the advantages of using Git. It covers issues that developers often have, like unintentional modifications, difficulties in collaborating, and the requirement for safe code storage. Until merging changes becomes necessary, developers can work independently on features by creating branches in Git. The article emphasizes the value of version control in team projects, as it facilitates the simultaneous work of several developers on the same codebase. Developers can keep local copies of their work and synchronize changes with a central server thanks to Git's distributed storage system. Git is also flexible when it comes to managing different file formats, not just source code. It meets funding bodies' expectations, which increasingly demand code availability, by offering a safe and systematic approach to code management. The article walks readers through the fundamental commands of Git, including how to set up a repository, commit, create branches, and manage merges. It goes over important ideas like tagging releases, which is a practice that helps with code versioning and helps identify which codebase produced which output files. The article functions as a basic introduction to Git version control, highlighting the importance of this tool in contemporary software development processes, especially for cooperative and open-source projects.

 */

	}

}
