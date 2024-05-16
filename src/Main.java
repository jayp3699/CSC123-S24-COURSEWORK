import java.util.ArrayList;
import java.util.List;

class Car {
    private String make;
    private String model;
    private int year;
    private CarOwner owner;
    private Engine engine;
    private Tires[] tires;

    public Car(String make, String model, int year, Engine engine, Tires[] tires) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.tires = tires;
    }

    // getters and setters
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", owner=" + owner +
                ", engine=" + engine +
                '}';
    }
}

class Engine {
    private int horsepower;
    private int cylinders;
    private String fuelType;
    private String manufacturer;
    private String modelNumber;

    public Engine(int horsepower, int cylinders, String fuelType, String manufacturer, String modelNumber) {
        this.horsepower = horsepower;
        this.cylinders = cylinders;
        this.fuelType = fuelType;
        this.manufacturer = manufacturer;
        this.modelNumber = modelNumber;
    }

    // getters and setters
    public String toString() {
        return "Engine{" +
                "horsepower=" + horsepower +
                ", cylinders=" + cylinders +
                ", fuelType='" + fuelType + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", modelNumber='" + modelNumber + '\'' +
                '}';
    }
}

class Tires {
    private int size;
    private String type;
    private String brand;
    private String treadPattern;
    private int wearRating;

    public Tires(int size, String type, String brand, String treadPattern, int wearRating) {
        this.size = size;
        this.type = type;
        this.brand = brand;
        this.treadPattern = treadPattern;
        this.wearRating = wearRating;
    }

    // getters and setters
    public String toString() {
        return "Tires{" +
                "size=" + size +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", treadPattern='" + treadPattern + '\'' +
                ", wearRating=" + wearRating +
                '}';
    }
}

class CarOwner {
    private String name;
    private int age;
    private String address;
    private String licenseNumber;
    private Car car;

    public CarOwner(String name, int age, String address, String licenseNumber, Car car) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.licenseNumber = licenseNumber;
        this.car = car;
    }

    // getters and setters
    public String toString() {
        return "CarOwner{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", car=" + car +
                '}';
    }
}

class DMV {
    private List<Car> registeredCars;
    private String location;
    private int timeOpen;
    private String timeClose;
    private String phoneNumber;

    public DMV(String location, int timeOpen, String timeClose, String phoneNumber) {
        this.location = location;
        this.timeOpen = timeOpen;
        this.timeClose = timeClose;
        this.phoneNumber = phoneNumber;
        this.registeredCars = new ArrayList<>();
    }

    public void registerCar(Car car) {
        registeredCars.add(car);
    }

    // other methods for DMV
    public String toString() {
        return "DMV{" +
                "registeredCars=" + registeredCars +
                ", location='" + location + '\'' +
                ", timeOpen=" + timeOpen +
                ", timeClose='" + timeClose + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine(200, 4, "Gasoline", "Toyota", "MNK1213");
        Tires[] tires = {new Tires(18, "Summer", "Goodyear", "All Season", 400),
                new Tires(18, "Summer", "Goodyear", "All Season", 400),
                new Tires(18, "Summer", "Goodyear", "All Season", 400),
                new Tires(18, "Summer", "Goodyear", "All Season", 400)};
        Car car = new Car("Toyota", "Camry", 2022, engine, tires);
        CarOwner owner = new CarOwner("Jay Prajapati", 22, "123 Main St", "MNK1213", car);
        DMV dmv = new DMV("City Center", 11, "6", "123-456-7890");
        dmv.registerCar(car);

        System.out.println(car);
        System.out.println(owner);
        System.out.println(dmv);
    }
}
