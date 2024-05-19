// John Doe (john.doe@csudh.edu)

import java.util.Scanner;

public class CoinCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: number of each type of coin
        System.out.print("Please enter the number of pennies: ");
        int pennies = scanner.nextInt();

        System.out.print("Please enter the number of nickels: ");
        int nickels = scanner.nextInt();

        System.out.print("Please enter the number of dimes: ");
        int dimes = scanner.nextInt();

        System.out.print("Please enter the number of quarters: ");
        int quarters = scanner.nextInt();

        // Calculate total amount in cents
        int totalCents = pennies + nickels * 5 + dimes * 10 + quarters * 25;

        // Convert total cents to dollars and cents
        int dollars = totalCents / 100;
        int cents = totalCents % 100;

        // Output the total amount with proper pluralization
        System.out.print("You have ");
        if (dollars == 1) {
            System.out.print("1 dollar");
        } else {
            System.out.print(dollars + " dollars");
        }

        if (cents == 1) {
            System.out.println(" and 1 cent.");
        } else {
            System.out.println(" and " + cents + " cents.");
        }

        scanner.close();
    }
}
