// John Doe (john.doe@csudh.edu)

import java.util.Scanner;

public class Gravity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: initial height and observation time
        System.out.print("Enter the initial position (height) in meters from where the object was dropped: ");
        double initialPosition = scanner.nextDouble();

        System.out.print("Enter the observation time in seconds: ");
        double time = scanner.nextDouble();

        // Constants
        final double acceleration = -9.81; // Acceleration due to gravity (m/s^2)
        final double initialVelocity = 0.0; // Initial velocity (m/s)

        // Calculate the position of the object after the given time
        double finalPosition = 0.5 * acceleration * Math.pow(time, 2) + initialVelocity * time + initialPosition;

        // Calculate the distance fallen
        double distanceFallen = initialPosition - finalPosition;

        // Output the results
        System.out.println("The object has fallen " + distanceFallen + " meters in " + time + " seconds.");
        System.out.println("The distance of the object from the ground is " + finalPosition + " meters.");

        scanner.close();
    }
}
