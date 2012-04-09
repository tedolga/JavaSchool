package two.essential;

import org.junit.Test;

import static org.junit.Assert.*;
import static two.essential.CalendarUtils.compareDates;
import static two.essential.CalendarUtils.stringToCalendar;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class CalendarUtilsTest {
    @Test
    public void testCompareDates() throws Exception {
        assertTrue(compareDates(stringToCalendar("09/04/2012 05:03"), stringToCalendar("09/05/2012 05:03")));
        assertTrue(compareDates(stringToCalendar("01/12/2012 05:03"), stringToCalendar("01/01/2013 05:03")));
        assertTrue(compareDates(stringToCalendar("01/01/2012 12:03"), stringToCalendar("01/02/2012 16:03")));
        assertTrue(compareDates(stringToCalendar("28/02/2012 12:03"), stringToCalendar("01/03/2012 16:03")));
        assertTrue(compareDates(stringToCalendar("01/03/2012 12:03"), stringToCalendar("01/02/2012 01:03")));
        assertTrue(compareDates(stringToCalendar("01/03/2012 12:03"), stringToCalendar("31/03/2012 01:03")));
        assertTrue(compareDates(stringToCalendar("01/03/2011 12:03"), stringToCalendar("02/02/2011 16:03")));
        assertTrue(compareDates(stringToCalendar("08/04/2012 05:03"), stringToCalendar("09/04/2012 05:03")));
        assertTrue(compareDates(stringToCalendar("31/12/2011 12:03"), stringToCalendar("15/01/2012 16:03")));
        assertFalse(compareDates(stringToCalendar("01/04/2012 12:03"), stringToCalendar("02/05/2012 16:03")));
        assertFalse(compareDates(stringToCalendar("01/01/2012 12:03"), stringToCalendar("02/02/2012 10:03")));
        assertFalse(compareDates(stringToCalendar("31/01/2011 12:03"), stringToCalendar("01/03/2011 10:03")));
        assertFalse(compareDates(stringToCalendar("31/01/2010 12:03"), stringToCalendar("30/01/2011 10:03")));
        assertFalse(compareDates(stringToCalendar("08/04/2012 05:03"), stringToCalendar("09/05/2012 05:03")));


    }

    @Test
    public void testDetermineDayOfWeek() throws Exception {
        assertEquals("Monday", CalendarUtils.determineDayOfWeek("09/04/2012 12:03"));
    }
}
