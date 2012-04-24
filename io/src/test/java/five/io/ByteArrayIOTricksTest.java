package five.io;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class ByteArrayIOTricksTest {
    @Test
    public void testReadWriteBytes() throws Exception {
        byte[] bytes = new byte[100];

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) i;
        }

        Assert.assertArrayEquals(bytes, ByteArrayIOTricks.rewriteBytes(bytes));

        Assert.assertArrayEquals(bytes, ByteArrayIOTricks.readBytes(bytes));
    }
}
