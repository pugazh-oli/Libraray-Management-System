
public class Librarian {

    Library library;

    public Librarian(Library library) {
        this.library = library;
    }

    public void approveBookIssue(String studentId, int bookId) {
        System.out.println("Book issue approved by librarian.");
        library.issueBook(studentId, bookId);
    }

    public void collectFine(String studentId) {
        int fine = FineCalculator.calculateFine(studentId, library);

        if (fine > 0) {
            System.out.println("Fine Amount: Rs." + fine);
            System.out.println("Fine collected successfully!");
        } else {
            System.out.println("No fine to collect.");
        }
    }

    public void generateReport() {
        library.generateReport();
    }
}
