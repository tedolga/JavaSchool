package two.essential;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class CalendarUtils {

    private static final String DATE_FORMAT = "dd/MM/yyyy hh:mm";

    public static String compareDates(String firstDateString, String secondDateString) throws ParseException {
        Calendar firstCalendar = stringToCalendar(firstDateString);
        Calendar secondCalendar = stringToCalendar(secondDateString);

    }

    public static String determineDayOfWeek(String dateString) throws ParseException {
        Calendar calendar = stringToCalendar(dateString);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    private static Calendar stringToCalendar(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = dateFormat.parse(dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
