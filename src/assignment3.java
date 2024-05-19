//Name: Jay Prajapati
//school email: jprajapati2@toromail.csudh.edu 

import java.util.*;

// Define the Vehicle class
class Vehicle {
    private String licensePlate;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}

// Define the Owner class
class Owner {
    private String name;

    public Owner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Define the Registration class
class Registration {
    private Vehicle vehicle;
    private Owner owner;
    private Date expiryDate;

    public Registration(Vehicle vehicle, Owner owner, Date expiryDate) {
        this.vehicle = vehicle;
        this.owner = owner;
        this.expiryDate = expiryDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Owner getOwner() {
        return owner;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
}

// Define the Citation class
class Citation {
    private Vehicle vehicle;
    private Date date;

    public Citation(Vehicle vehicle, Date date) {
        this.vehicle = vehicle;
        this.date = date;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Date getDate() {
        return date;
    }
}

// Define the Database class to manage registrations and citations
class Database {
    private List<Registration> registrations = new ArrayList<>();
    private List<Citation> citations = new ArrayList<>();

    public void registerVehicle(Vehicle vehicle, Owner owner, Date expiryDate) {
        Registration existingRegistration = findActiveRegistration(vehicle);
        if (existingRegistration != null) {
            System.out.println("Error: Vehicle already registered with an active registration.");
            return;
        }

        registrations.add(new Registration(vehicle, owner, expiryDate));
        System.out.println("Vehicle registered successfully.");
    }

    public void registerCitation(Vehicle vehicle, Date date) {
        Registration activeRegistration = findActiveRegistration(vehicle);
        if (activeRegistration == null) {
            System.out.println("Error: Vehicle not found or does not have an active registration.");
            return;
        }

        citations.add(new Citation(vehicle, date));
        System.out.println("Citation registered successfully.");
    }

    public void listAllRegistrations() {
        for (Registration registration : registrations) {
            System.out.println("Vehicle: " + registration.getVehicle().getLicensePlate() +
                    ", Owner: " + registration.getOwner().getName() +
                    ", Expiry Date: " + registration.getExpiryDate());
        }
    }

    public void listAllCitations() {
        for (Citation citation : citations) {
            System.out.println("Vehicle: " + citation.getVehicle().getLicensePlate() +
                    ", Date: " + citation.getDate());
        }
    }

    public void listRegistrationsForVehicle(Vehicle vehicle) {
        for (Registration registration : registrations) {
            if (registration.getVehicle().equals(vehicle)) {
                System.out.println("Vehicle: " + registration.getVehicle().getLicensePlate() +
                        ", Owner: " + registration.getOwner().getName() +
                        ", Expiry Date: " + registration.getExpiryDate());
            }
        }
    }

    public void listRegistrationsForOwner(Owner owner) {
        for (Registration registration : registrations) {
            if (registration.getOwner().equals(owner)) {
                System.out.println("Vehicle: " + registration.getVehicle().getLicensePlate() +
                        ", Owner: " + registration.getOwner().getName() +
                        ", Expiry Date: " + registration.getExpiryDate());
            }
        }
    }

    public void listCitationsForVehicle(Vehicle vehicle) {
        for (Citation citation : citations) {
            if (citation.getVehicle().equals(vehicle)) {
                System.out.println("Vehicle: " + citation.getVehicle().getLicensePlate() +
                        ", Date: " + citation.getDate());
            }
        }
    }

    public void listCitationsForOwner(Owner owner) {
        for (Citation citation : citations) {
            for (Registration registration : registrations) {
                if (registration.getOwner().equals(owner) && citation.getVehicle().equals(registration.getVehicle())) {
                    System.out.println("Vehicle: " + citation.getVehicle().getLicensePlate() +
                            ", Date: " + citation.getDate());
                }
            }
        }
    }

    private Registration findActiveRegistration(Vehicle vehicle) {
        for (Registration registration : registrations) {
            if (registration.getVehicle().equals(vehicle) && registration.getExpiryDate().after(new Date())) {
                return registration;
            }
        }
        return null;
    }
}

public class assignment3 {
    public static void main(String[] args) {
        Database database = new Database();

        // Sample usage
        Vehicle vehicle1 = new Vehicle("ABC123");
        Vehicle vehicle2 = new Vehicle("XYZ789");
        Owner owner1 = new Owner("John Doe");
        Owner owner2 = new Owner("Jane Smith");
        Date expiryDate1 = new Date(System.currentTimeMillis() + 100000000); // Expiry date in the future
        Date expiryDate2 = new Date(System.currentTimeMillis() - 100000000); // Expired registration
        Date citationDate = new Date();

        database.registerVehicle(vehicle1, owner1, expiryDate1);
        database.registerVehicle(vehicle2, owner2, expiryDate2);

        database.registerCitation(vehicle1, citationDate);
        database.registerCitation(vehicle2, citationDate);

        System.out.println("All Registrations:");
        database.listAllRegistrations();

        System.out.println("\nAll Citations:");
        database.listAllCitations();

        System.out.println("\nRegistrations for Vehicle ABC123:");
        database.listRegistrationsForVehicle(vehicle1);

        System.out.println("\nRegistrations for Owner John Doe:");
        database.listRegistrationsForOwner(owner1);

        System.out.println("\nCitations for Vehicle ABC123:");
        database.listCitationsForVehicle(vehicle1);

        System.out.println("\nCitations for Owner John Doe:");
        database.listCitationsForOwner(owner1);
    }
}