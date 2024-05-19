import java.util.*;

 

public class Assignment_5 {

 public static void main(String[] args) {

 Scanner scanner = new Scanner(System.in);

 Library library = new Library();

 

 int choice;

 do {

 System.out.println("1 - New Membership");

 System.out.println("2 - Add Material");

 System.out.println("3 - Issue Item");

 System.out.println("4 - Return Item");

 System.out.println("5 - Report Inventory");

 System.out.println("6 - Report Loans");

 System.out.println("7 - Lookup Membership");

 System.out.println("8 - Exit");

 System.out.print("Please enter your choice: ");

 choice = scanner.nextInt();

 scanner.nextLine(); // consume newline

 

 switch (choice) {

 case 1:

 library.addMember();

 break;

 case 2:

 library.addCatalogueItem();

 break;

 case 3:

 library.issueItem();

 break;

 case 4:

 library.returnItem();

 break;

 case 5:

 library.generateInventoryReport();

 break;

 case 6:

 library.generateLoansReport();

 break;

 case 7:

 library.lookupMembership();

 break;

 case 8:

 System.out.println("Exiting...");

 break;

 default:

 System.out.println("Invalid choice! Please try again.");

 break;

 }

 } while (choice != 8);

 

 scanner.close();

 }

}

 

public class Library {

 private List<CatalogueItem> catalogue;

 private List<Member> members;

 

 public Library() {

 catalogue = new ArrayList<>();

 members = new ArrayList<>();

 }

 

 public void addMember() {

 // Implementation for adding a new member

 }

 

 public void addCatalogueItem() {

 // Implementation for adding a new catalogue item

 }

 

 public void issueItem() {

 // Implementation for issuing an item

 }

 

 public void returnItem() {

 // Implementation for returning an item

 }

 

 public void generateInventoryReport() {

 // Implementation for generating an inventory report

 }

 

 public void generateLoansReport() {

 // Implementation for generating a loans report

 }

 

 public void lookupMembership() {

 // Implementation for looking up a membership

 }

}

 

public class CatalogueItem {

 private int itemReferenceNumber;

 private ItemType type;

 private boolean suitableForChildren;

 private double replacementValue;

 private String location;

 private Status status;

 

 public CatalogueItem(int itemReferenceNumber, ItemType type, boolean suitableForChildren, double replacementValue, String location) {

 this.itemReferenceNumber = itemReferenceNumber;

 this.type = type;

 this.suitableForChildren = suitableForChildren;

 this.replacementValue = replacementValue;

 this.location = location;

 this.status = Status.AVAILABLE;

 }

 

 // Getters and setters

}

 

public enum ItemType {

 BOOK,

 MAGAZINE,

 DVD

}

 

public enum Status {

 AVAILABLE,

 ON_LOAN

}

 

public class Book extends CatalogueItem {

 private String title;

 private String author;

 private String ISBN;

 private int numberOfPages;

 

 public Book(int itemReferenceNumber, boolean suitableForChildren, double replacementValue, String location, String title, String author, String ISBN, int numberOfPages) {

 super(itemReferenceNumber, ItemType.BOOK, suitableForChildren, replacementValue, location);

 this.title = title;

 this.author = author;

 this.ISBN = ISBN;

 this.numberOfPages = numberOfPages;

 }

 

 // Getters and setters

}

 

public class Magazine extends CatalogueItem {

 private String title;

 private String publicationDate;

 private int issueNumber;

 

 public Magazine(int itemReferenceNumber, boolean suitableForChildren, double replacementValue, String location, String title, String publicationDate, int issueNumber) {

 super(itemReferenceNumber, ItemType.MAGAZINE, suitableForChildren, replacementValue, location);

 this.title = title;

 this.publicationDate = publicationDate;

 this.issueNumber = issueNumber;

 }

 

 // Getters and setters

}

 

public class DVD extends CatalogueItem {

 private String title;

 private String releaseDate;

 private int durationInMinutes;

 

 public DVD(int itemReferenceNumber, boolean suitableForChildren, double replacementValue, String location, String title, String releaseDate, int durationInMinutes) {

 super(itemReferenceNumber, ItemType.DVD, suitableForChildren, replacementValue, location);

 this.title = title;

 this.releaseDate = releaseDate;

 this.durationInMinutes = durationInMinutes;

 }

 

 // Getters and setters

}

 

public class Member {

 private int membershipNumber;

 private String firstName;

 private String lastName;

 private Date dateOfBirth;

 private String city;

 private String zipCode;

 private Member guardian;

 private boolean isChildMember;

 

 public Member(int membershipNumber, String firstName, String lastName, Date dateOfBirth, String city, String zipCode, Member guardian, boolean isChildMember) {

 this.membershipNumber = membershipNumber;

 this.firstName = firstName;

 this.lastName = lastName;

 this.dateOfBirth = dateOfBirth;

 this.city = city;

 this.zipCode = zipCode;

 this.guardian = guardian;

 this.isChildMember = isChildMember;

 }

}

 

 // Getters and setters

 // to persist to the disk

 /* 

 import java.io.*;

 import java.util.*;

 

 public class App {

 private static final String DATA_FILE = "library_data.ser";

 

 public static void main(String[] args) {

 Library library = loadLibrary();

 if (library == null) {

 library = new Library();

 }

 

 Scanner scanner = new Scanner(System.in);

 int choice;

 do {

 System.out.println("1 - New Membership");

 System.out.println("2 - Add Material");

 System.out.println("3 - Issue Item");

 System.out.println("4 - Return Item");

 System.out.println("5 - Report Inventory");

 System.out.println("6 - Report Loans");

 System.out.println("7 - Lookup Membership");

 System.out.println("8 - Exit");

 System.out.print("Please enter your choice: ");

 choice = scanner.nextInt();

 scanner.nextLine(); // consume newline

 

 switch (choice) {

 case 1:

 library.addMember();

 break;

 case 2:

 library.addCatalogueItem();

 break;

 case 3:

 library.issueItem();

 break;

 case 4:

 library.returnItem();

 break;

 case 5:

 library.generateInventoryReport();

 break;

 case 6:

 library.generateLoansReport();

 break;

 case 7:

 library.lookupMembership();

 break;

 case 8:

 saveLibrary(library);

 System.out.println("Exiting...");

 break;

 default:

 System.out.println("Invalid choice! Please try again.");

 break;

 }

 } while (choice != 8);

 

 scanner.close();

 }

 

 private static void saveLibrary(Library library) {

 try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {

 oos.writeObject(library);

 System.out.println("Library data saved to disk.");

 } catch (IOException e) {

 System.err.println("Error saving library data: " + e.getMessage());

 }

 }

 

 private static Library loadLibrary() {

 try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {

 return (Library) ois.readObject();

 } catch (FileNotFoundException e) {

 System.out.println("No saved data found. Starting with empty library.");

 } catch (IOException | ClassNotFoundException e) {

 System.err.println("Error loading library data: " + e.getMessage());

 }

 return null;

 }

 }

 

 

*/