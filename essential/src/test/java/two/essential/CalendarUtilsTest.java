package two.essential;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class CalendarUtilsTest {
    @Test
    public void testCompareDates() throws Exception {
        Assert.assertEquals("YES", CalendarUtils.compareDates("09/04/2012 12:03", "09/05/2012 16:03"));
        Assert.assertEquals("YES", CalendarUtils.compareDates("01/01/2012 12:03", "01/02/2012 16:03"));
        Assert.assertEquals("YES", CalendarUtils.compareDates("03/02/2012 12:03", "04/02/2012 16:03"));
        Assert.assertEquals("YES", CalendarUtils.compareDates("28/02/2012 12:03", "01/03/2012 16:03"));
        Assert.assertEquals("YES", CalendarUtils.compareDates("01/03/2012 12:03", "01/02/2012 01:03"));
        Assert.assertEquals("YES", CalendarUtils.compareDates("01/03/2012 12:03", "31/03/2012 01:03"));
        Assert.assertEquals("YES", CalendarUtils.compareDates("01/03/2011 12:03", "02/02/2011 16:03"));
        Assert.assertEquals("NO", CalendarUtils.compareDates("01/04/2012 12:03", "02/05/2012 16:03"));
        Assert.assertEquals("NO", CalendarUtils.compareDates("01/01/2012 12:03", "02/02/2012 10:03"));
        Assert.assertEquals("NO", CalendarUtils.compareDates("31/01/2011 12:03", "01/03/2011 10:03"));

    }

    @Test
    public void testDetermineDayOfWeek() throws Exception {
        Assert.assertEquals("Monday", CalendarUtils.determineDayOfWeek("09/04/2012 12:03"));
    }
}
