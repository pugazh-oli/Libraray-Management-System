
import java.time.LocalDate;

public class Book {
    int bookId;
    String bookName;
    String author;
    boolean available;
    LocalDate dueDate;

    public Book(int bookId, String bookName, String author) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.available = true;
    }

    public void displayBook() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Book Name: " + bookName);
        System.out.println("Author: " + author);
        System.out.println("Availability: " + available);
    }
}
