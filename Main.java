
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();
        Librarian librarian = new Librarian(library);

        library.addBook(new Book(101, "Java Programming", "James"));
        library.addBook(new Book(102, "Python Basics", "Guido"));
        library.addBook(new Book(103, "C Programming", "Dennis"));

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Collect Fine");
            System.out.println("7. Generate Report");
            System.out.println("8. Book Availability");
            System.out.println("9. Calculate Fine");
            System.out.println("10. Due Date Reminder");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    library.addBook(new Book(id, name, author));
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Book Name: ");
                    String search = sc.nextLine();
                    library.searchBook(search);
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    String studentId = sc.nextLine();

                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();

                    librarian.approveBookIssue(studentId, bookId);
                    break;

                case 5:
                    System.out.print("Enter Student ID: ");
                    String returnId = sc.nextLine();

                    library.returnBook(returnId);
                    break;

                case 6:
                    System.out.print("Enter Student ID: ");
                    String fineId = sc.nextLine();

                    librarian.collectFine(fineId);
                    break;

                case 7:
                    librarian.generateReport();
                    break;

                case 8:
                    for (Book book : library.books) {
                        if (book.available) {
                            book.displayBook();
                        }
                    }
                    break;

                case 9:
                    System.out.print("Enter Student ID: ");
                    String calculateId = sc.nextLine();

                    int fine = FineCalculator.calculateFine(
                            calculateId, library);

                    System.out.println("Fine: Rs." + fine);
                    break;

                case 10:
                    DueDateReminder.showReminders(library);
                    break;

                case 0:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
