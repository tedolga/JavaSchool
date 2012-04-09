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

    public static void main(String[] args) throws ParseException {
        System.out.println("Enter two dates");
        Scanner scanner = new Scanner(System.in);
        String firstDateString = scanner.nextLine();
        String secondDateString = scanner.nextLine();
        System.out.println(firstDateString + " day of week is " + determineDayOfWeek(firstDateString));
        System.out.println(secondDateString + " day of week is " + determineDayOfWeek(secondDateString));
        System.out.println("Dates are within 1 month from one another :" + compareDates(stringToCalendar(firstDateString), stringToCalendar(secondDateString)));
    }

    public static boolean compareDates(Calendar firstCalendar, Calendar secondCalendar) throws ParseException {
        roundTime(firstCalendar);
        roundTime(secondCalendar);
        Calendar[] sortedDates = orderDates(firstCalendar, secondCalendar);
        Calendar smallerDate = sortedDates[0];
        Calendar biggerDate = sortedDates[1];
        biggerDate.add(Calendar.MONTH, -1);
        if (!smallerDate.before(biggerDate)) {
            return true;
        } else {
            return false;
        }

    }

    public static String determineDayOfWeek(String dateString) throws ParseException {
        Calendar calendar = stringToCalendar(dateString);
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("US"));
    }

    public static Calendar stringToCalendar(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = dateFormat.parse(dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    private static void roundTime(Calendar calendar) {
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
    }

    private static Calendar[] orderDates(Calendar firstDate, Calendar secondDate) {
        Calendar[] sortedDates = new Calendar[2];
        if (firstDate.compareTo(secondDate) > 0) {
            sortedDates[0] = secondDate;
            sortedDates[1] = firstDate;
        } else {
            sortedDates[0] = firstDate;
            sortedDates[1] = secondDate;
        }
        return sortedDates;
    }
}
