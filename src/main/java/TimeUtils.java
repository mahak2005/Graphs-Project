import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static LocalTime parseTime(String timeString) {
        try {
            // Convert hours > 23 to the next day format
            if (timeString.startsWith("24:")) {
                timeString = "00:" + timeString.substring(3);
            } else if (Integer.parseInt(timeString.substring(0, 2)) >= 24) {
                int hours = Integer.parseInt(timeString.substring(0, 2)) - 24;
                timeString = String.format("%02d:%s", hours, timeString.substring(3));
            }
            return LocalTime.parse(timeString, FORMATTER);
        } catch (DateTimeParseException e) {
            System.err.println("Error parsing time: " + timeString);
            throw e;  // or handle the exception as needed
        }
    }
}
