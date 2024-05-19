// John Doe (john.doe@csudh.edu)

import java.util.Scanner;

public class ChangeMaker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: amount in dollars and cents
        System.out.print("Please enter your amount in dollars: ");
        int dollars = scanner.nextInt();

        System.out.print("Please enter your amount in cents: ");
        int cents = scanner.nextInt();

        // Convert dollars to cents and add to total cents
        int totalCents = dollars * 100 + cents;

        // Calculate the number of each coin
        int quarters = totalCents / 25;
        totalCents %= 25;

        int dimes = totalCents / 10;
        totalCents %= 10;

        int nickels = totalCents / 5;
        totalCents %= 5;

        int pennies = totalCents;

        // Output the number of each coin with proper pluralization
        System.out.println(dollars + " dollars and " + cents + " cents are:");
        System.out.println(quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, and " + pennies + " pennies.");

        scanner.close();
    }
}
