package one.types;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class DoubleRepresenterTest {
    @Test
    public void testGetIntegralPart() throws Exception {
        double doubleValue = 4.97;
        DoubleRepresenter doubleRepresenter = new DoubleRepresenter(doubleValue);
        Assert.assertEquals(4, doubleRepresenter.getIntegralPart());
        doubleValue = -4.97;
        doubleRepresenter = new DoubleRepresenter(doubleValue);
        Assert.assertEquals(-4, doubleRepresenter.getIntegralPart());
        doubleValue = 5.34E10;
        doubleRepresenter = new DoubleRepresenter(doubleValue);
        Assert.assertEquals(53400000000L, doubleRepresenter.getIntegralPart());
    }

    @Test
    public void testGetFractionalPart() throws Exception {
        double doubleValue = 4.6799;
        DoubleRepresenter doubleRepresenter = new DoubleRepresenter(doubleValue);
        Assert.assertEquals(6799, doubleRepresenter.getFractionalPart());
        doubleValue = -4.67;
        doubleRepresenter = new DoubleRepresenter(doubleValue);
        Assert.assertEquals(6700, doubleRepresenter.getFractionalPart());
        doubleValue = 5.34E10;
        doubleRepresenter = new DoubleRepresenter(doubleValue);
        Assert.assertEquals(0, doubleRepresenter.getFractionalPart());
    }

    @Test
    public void testToString() throws Exception {
        double doubleValue = -4.67;
        DoubleRepresenter doubleRepresenter = new DoubleRepresenter(doubleValue);
        Assert.assertEquals("-4.6700", doubleRepresenter.toString());
    }
}
