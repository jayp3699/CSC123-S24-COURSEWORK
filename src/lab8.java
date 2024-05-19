import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Address {
    private String city;
    private String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return city + ", " + state;
    }
}

class Library {
    private String name;
    private Address address;
    private List<Book> books;

    public Library(String name, Address address) {
        this.name = name;
        this.address = address;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
        book.setLibrary(this);
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.setLibrary(null);
    }

    @Override
    public String toString() {
        return "Library: " + name + ", Address: " + address.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Library library = (Library) obj;
        return Objects.equals(name, library.name) &&
                Objects.equals(address, library.address);
    }
}

class Book {
    private String title;
    private String author;
    private int numberOfPages;
    private String ISBN;
    private Library library;

    public Book(String title, String author, int numberOfPages, String ISBN) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getISBN() {
        return ISBN;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public String toString() {
        return "Book: " + title + ", Author: " + author + ", Pages: " + numberOfPages + ", ISBN: " + ISBN;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return numberOfPages == book.numberOfPages &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(ISBN, book.ISBN);
    }
}

public class Main {
    public static void main(String[] args) {
        Address libraryAddress = new Address("New York City", "NY");
        Library library = new Library("Public Library", libraryAddress);

        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 180, "9780743273565");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 281, "9780061120084");

        library.addBook(book1);
        library.addBook(book2);

        System.out.println(library);
        System.out.println("Books in the library:");
        for (Book book : library.getBooks()) {
            System.out.println(book);
        }
    }
}
