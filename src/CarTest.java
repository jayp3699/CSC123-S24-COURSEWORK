// Custom Exception Classes
class IncompleteCarConfigurationException extends Exception {
    public IncompleteCarConfigurationException(String message) {
        super(message);
    }
}

class CarNotInParkedException extends Exception {
    public CarNotInParkedException(String message) {
        super(message);
    }
}

class CarAlreadyRunningException extends Exception {
    public CarAlreadyRunningException(String message) {
        super(message);
    }
}

class BrakesNotAppliedException extends Exception {
    public BrakesNotAppliedException(String message) {
        super(message);
    }
}

// Car Class
class Car {
    private String make;
    private String model;
    private String color;
    private boolean isRunning;
    private boolean isBrakeApplied;
    private String transmission;

    public Car(String make, String model, String color) throws IncompleteCarConfigurationException {
        if (make == null || model == null || color == null) {
            throw new IncompleteCarConfigurationException("Make, model, and color must be provided.");
        }
        this.make = make;
        this.model = model;
        this.color = color;
    }

    public void start() throws CarAlreadyRunningException, CarNotInParkedException, BrakesNotAppliedException {
        if (isRunning) {
            throw new CarAlreadyRunningException("Car is already running.");
        }
        if (!"P".equals(transmission)) {
            throw new CarNotInParkedException("Car is not in 'P' transmission mode.");
        }
        if (!isBrakeApplied) {
            throw new BrakesNotAppliedException("Brakes are not applied.");
        }
        isRunning = true;
        System.out.println("Car started.");
    }

    public void stop() {
        isRunning = false;
        System.out.println("Car stopped.");
    }

    public void applyBrake() {
        isBrakeApplied = true;
        System.out.println("Brakes applied.");
    }

    public void releaseBrake() {
        isBrakeApplied = false;
        System.out.println("Brakes released.");
    }

    public boolean isBrakeApplied() {
        return isBrakeApplied;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
        System.out.println("Transmission set to " + transmission);
    }
}

// Test Program
public class CarTest {
    public static void main(String[] args) throws IncompleteCarConfigurationException {
        try {
            // Testing IncompleteCarConfigurationException
            Car car1 = new Car("Toyota", null, "Red");
        } catch (IncompleteCarConfigurationException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Testing start() method with various scenarios
            Car car2 = new Car("Toyota", "Corolla", "Red");
            car2.applyBrake();
            car2.setTransmission("P");
            car2.start(); // Should start successfully

            car2.start(); // Testing CarAlreadyRunningException
        } catch (CarAlreadyRunningException | CarNotInParkedException | BrakesNotAppliedException e) {
            System.out.println(e.getMessage());
        }
    }
}
