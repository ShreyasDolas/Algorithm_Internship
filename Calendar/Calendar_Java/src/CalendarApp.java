import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class CalendarApp {

    public static void main(String[] args) {
        int year = 2024;

        System.out.println("Calendar for the year " + year);
        System.out.println("===========================");

        for (Month month : Month.values()) {
            System.out.println("\n" + month.toString() + " " + year);
            System.out.println("---------------------------");
            printMonthCalendar(month, year);
        }
    }

    public static void printMonthCalendar(Month month, int year) {
        LocalDate date = LocalDate.of(year, month, 1);
        int daysInMonth = month.length(date.isLeapYear());

        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        
        // Print leading spaces
        int startingDayOfWeek = date.getDayOfWeek().getValue();
        for (int i = 1; i < startingDayOfWeek; i++) {
            System.out.print("    ");
        }

        // Print days
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);
            if (date.getDayOfWeek().getValue() == 6) {
                System.out.println();
            }
            date = date.plusDays(1);
        }

        System.out.println();
    }
}
