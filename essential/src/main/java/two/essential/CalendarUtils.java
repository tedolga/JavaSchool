package two.essential;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Allows user to enter two date/time values in
 * format “dd/MM/yyyy hh:mm”. The program must output weekdays of these
 * dates (e.g. for “05/02/2007 12:00” it must output “MONDAY”), and tell if
 * these dates are within 1 month from one another (e.g. for January 1st and
 * February 1st it must say “YES”, but for February 1st and March 2nd it must
 * say “NO”).
 *
 * @author Tedikova O.
 * @version 1.0
 */
public class CalendarUtils {
    /**
     * String pattern for date formatting
     */
    private static final String DATE_FORMAT = "dd/MM/yyyy hh:mm";

    public static void main(String[] args) throws ParseException {
        System.out.println("Enter two dates");
        Scanner scanner = new Scanner(System.in);
        Calendar firstDate = stringToCalendar(scanner.nextLine());
        Calendar secondDate = stringToCalendar(scanner.nextLine());
        System.out.println(firstDate.getTime() + " day of week is " + determineDayOfWeek(firstDate));
        System.out.println(secondDate.getTime() + " day of week is " + determineDayOfWeek(secondDate));
        System.out.println("Dates are within 1 month from one another :" + compareDates(firstDate, secondDate));
    }

    /**
     * Compares 2 dates and determines if they are within 1 month from each other
     *
     * @param firstCalendar  first date for comparison.
     * @param secondCalendar second date second date for comparison.
     * @return true, if given dates within 1 month from each other, false-in other case.
     */
    public static boolean compareDates(Calendar firstCalendar, Calendar secondCalendar) {
        roundTime(firstCalendar);
        roundTime(secondCalendar);
        Calendar[] sortedDates = orderDates(firstCalendar, secondCalendar);
        Calendar smallerDate = sortedDates[0];
        Calendar biggerDate = sortedDates[1];
        biggerDate.add(Calendar.MONTH, -1);
        return !smallerDate.before(biggerDate);
    }

    /**
     * Determines which day of week is accounted for the given date
     *
     * @param calendar given date
     * @return day of week in string representation in full style and US locale
     */
    public static String determineDayOfWeek(Calendar calendar) {
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("US"));
    }

    /**
     * Converts string in {@link two.essential.CalendarUtils#DATE_FORMAT} to {@link java.util.Calendar} object
     *
     * @param dateString string in {@link two.essential.CalendarUtils#DATE_FORMAT} which will be parsed
     * @return Calendar instance which was received after {@code dateString} parsing
     * @throws ParseException in case when {@code dateString} can't be parsed
     */
    public static Calendar stringToCalendar(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = dateFormat.parse(dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * Sets to {@literal 0} {@link java.util.Calendar#MILLISECOND}, {@link java.util.Calendar#SECOND},
     * {@link java.util.Calendar#MINUTE} and {@link java.util.Calendar#HOUR_OF_DAY} field values of the given calendar
     * instance.
     *
     * @param calendar instance to be round
     */
    private static void roundTime(Calendar calendar) {
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
    }

    /**
     * Orders two dates in their chronological order
     *
     * @param firstDate  one of dates
     * @param secondDate one of dates
     * @return sorted array of 2 dates
     */
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
