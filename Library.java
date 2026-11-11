
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.util.Map;

public class Library {

    ArrayList<Book> books = new ArrayList<>();
    HashMap<String, Book> issuedBooks = new HashMap<>();
    HashMap<String, LocalDate> dueDates = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void searchBook(String name) {
        boolean found = false;

        for (Book book : books) {
            if (book.bookName.equalsIgnoreCase(name)) {
                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found!");
        }
    }

    public void displayBooks() {
        for (Book book : books) {
            book.displayBook();
            System.out.println("----------------");
        }
    }

    public void issueBook(String studentId, int bookId) {
        if (issuedBooks.containsKey(studentId)) {
            System.out.println("Student already has a book!");
            return;
        }

        for (Book book : books) {
            if (book.bookId == bookId && book.available) {

                book.available = false;
                book.dueDate = LocalDate.now().plusDays(14);

                issuedBooks.put(studentId, book);
                dueDates.put(studentId, book.dueDate);

                System.out.println("Book issued successfully!");
                System.out.println("Due Date: " + book.dueDate);
                return;
            }
        }

        System.out.println("Book not available!");
    }

    public void returnBook(String studentId) {
        Book book = issuedBooks.get(studentId);

        if (book != null) {
            book.available = true;
            book.dueDate = null;

            issuedBooks.remove(studentId);
            dueDates.remove(studentId);

            System.out.println("Book returned successfully!");
        } else {
            System.out.println("No issued book found!");
        }
    }

    public void generateReport() {
        System.out.println("Total Books: " + books.size());
        System.out.println("Issued Books: " + issuedBooks.size());
        System.out.println("Available Books: " +
                (books.size() - issuedBooks.size()));

        for (Map.Entry<String, Book> entry :
                issuedBooks.entrySet()) {
            System.out.println("Student: " + entry.getKey());
            System.out.println("Book: " + entry.getValue().bookName);
        }
    }
}
