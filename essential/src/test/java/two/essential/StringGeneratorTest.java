package two.essential;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static two.essential.StringGenerator.generateString;
import static two.essential.StringGenerator.replaceDevilsDozen;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class StringGeneratorTest {
    @Test
    public void testReplaceDevilsDozen() throws Exception {
        String string = "1";
        assertEquals("1", replaceDevilsDozen(string).toString());
        string = "13";
        assertEquals("777", replaceDevilsDozen(string).toString());
        string = "11356";
        assertEquals("177756", replaceDevilsDozen(string).toString());
        string = "565613";
        assertEquals("5656777", replaceDevilsDozen(string).toString());
        string = "13131313";
        assertEquals("777777777777", replaceDevilsDozen(string).toString());
    }

    @Test
    public void testFull() throws Exception {
        long startTime = System.currentTimeMillis();
        replaceDevilsDozen(generateString(1000, 100));
        long endTime = System.currentTimeMillis();
        System.out.println(" duration= " + (endTime - startTime));

    }
}
