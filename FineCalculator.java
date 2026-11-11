
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FineCalculator {

    public static int calculateFine(String studentId, Library library) {

        LocalDate dueDate = library.dueDates.get(studentId);

        if (dueDate == null) {
            return 0;
        }

        LocalDate today = LocalDate.now();

        if (today.isAfter(dueDate)) {
            long lateDays = ChronoUnit.DAYS.between(dueDate, today);
            return (int) lateDays * 5;
        }

        return 0;
    }
}
