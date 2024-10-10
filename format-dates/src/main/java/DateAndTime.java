import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateAndTime {

    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now();


        DateTimeFormatter usTime = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(today.format(usTime));

        // LocalDate.now() also prints this format out
        DateTimeFormatter dashFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(today.format(dashFormat));

        DateTimeFormatter fullMonthDate = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        System.out.println(today.format(fullMonthDate));

        DateTimeFormatter dayAndDate = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm");
        System.out.println(today.format(dayAndDate));

        DateTimeFormatter challengeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String formattedDate = today.format(challengeFormatter);
        System.out.println(today.getHour() + ":" + today.getMinute() + " on " + formattedDate);

    }
}
