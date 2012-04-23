package five.io;


import org.junit.Assert;
import org.junit.Test;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class CharCountReaderTest {

    @Test
    public void testRead() throws Exception {
        char[] chars = new char[]{'a', 'c', 'g'};
        CharCountReader countReader = new CharCountReader(chars, 'g');
        Assert.assertEquals(1, countReader.read(new char[3], 0, 1));
        Assert.assertEquals(0, countReader.getCharCount());
        Assert.assertEquals(1, countReader.read(new char[3], 1, 1));
        Assert.assertEquals(0, countReader.getCharCount());
        Assert.assertEquals(1, countReader.read(new char[3], 2, 1));
        Assert.assertEquals(1, countReader.getCharCount());
    }

}
