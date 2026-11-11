
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class DueDateReminder {

    public static void showReminders(Library library) {

        LocalDate today = LocalDate.now();

        for (Map.Entry<String, LocalDate> entry :
                library.dueDates.entrySet()) {

            System.out.println("Student ID: " + entry.getKey());
            System.out.println("Due Date: " + entry.getValue());

            if (today.isAfter(entry.getValue())) {
                System.out.println("Book is overdue!");
            } else if (today.equals(entry.getValue())) {
                System.out.println("Today is the last date!");
            } else {
                long days = ChronoUnit.DAYS.between(
                        today, entry.getValue());

                System.out.println("Days remaining: " + days);
            }

            System.out.println("------------------");
        }
    }
}
