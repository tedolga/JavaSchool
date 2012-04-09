package two.essential;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class CalendarUtils {

    private static final String DATE_FORMAT = "dd/MM/yyyy hh:mm";
    private static final long MILLISECONDS_IN_BIGGEST_MONTH = 2678400000L;
    private static final long MILLISECONDS_IN_SMALLEST_MONTH = 2419200000L;

    public static void main(String[] args) throws ParseException {
        System.out.println("Enter two dates");
        Scanner scanner = new Scanner(System.in);
        String firstDateString = scanner.nextLine();
        String secondDateString = scanner.nextLine();
        System.out.println(firstDateString + " day of week is " + determineDayOfWeek(firstDateString));
        System.out.println(secondDateString + " day of week is " + determineDayOfWeek(secondDateString));
        System.out.println("Dates are within 1 month from one another :" + compareDates(firstDateString, secondDateString));
    }

    public static String compareDates(String firstDateString, String secondDateString) throws ParseException {
        Calendar firstCalendar = stringToCalendar(firstDateString);
        Calendar secondCalendar = stringToCalendar(secondDateString);
        roundTime(firstCalendar);
        roundTime(secondCalendar);
        long millisDifference = Math.abs(firstCalendar.getTimeInMillis() - secondCalendar.getTimeInMillis());
        int monthDifference = firstCalendar.get(Calendar.MONTH) - secondCalendar.get(Calendar.MONTH);
        if (millisDifference <= MILLISECONDS_IN_SMALLEST_MONTH) {
            return "YES";
        } else if (millisDifference > MILLISECONDS_IN_BIGGEST_MONTH) {
            return "NO";
        } else if (Math.abs(monthDifference) > 1) {
            return "NO";
        } else if (Math.abs(monthDifference) == 1) {
            Calendar olderDate = (firstCalendar.compareTo(secondCalendar) > 0) ? firstCalendar : secondCalendar;
            Calendar smallerDate = (firstCalendar.compareTo(secondCalendar) < 0) ? firstCalendar : secondCalendar;
            if (olderDate.get(Calendar.DAY_OF_MONTH) <= smallerDate.get(Calendar.DAY_OF_MONTH)) {
                return "YES";
            } else {
                return "NO";
            }

        } else {
            return "YES";
        }
    }

    public static String determineDayOfWeek(String dateString) throws ParseException {
        Calendar calendar = stringToCalendar(dateString);
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
    }

    private static Calendar stringToCalendar(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = dateFormat.parse(dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    private static void roundTime(Calendar calendar) {
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
    }
}
