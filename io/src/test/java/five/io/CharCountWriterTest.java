package five.io;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class CharCountWriterTest {
    @Test
    public void testGetCharCount() throws Exception {
        char[] chars = new char[]{'a', 'c', 'g'};
        CharCountWriter countWriter = new CharCountWriter('g');
        countWriter.write(chars, 0, 2);
        Assert.assertEquals(0, countWriter.getCharCount());
        countWriter.write(chars, 2, 1);
        Assert.assertEquals(1, countWriter.getCharCount());
        countWriter.write(chars, 0, 3);
        Assert.assertEquals(2, countWriter.getCharCount());
    }
}
